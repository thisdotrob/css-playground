(ns css-playground.core
  (:require [ring.util.response :refer [not-found]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]))

(defn handler [request]
  "If we get to this handler it means the `wrap-resource`
  middleware failed to find the file."
  (let [body "Resource not found"]
    (not-found body)))

(def app
  (-> handler
      (wrap-resource "public")
      (wrap-content-type)))

(defn -main [& args]
  (run-jetty app {:port 3000}))
