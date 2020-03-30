(ns user
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [css-playground.core :as css-playground]))

(defonce server (atom nil))

(def reloadable-app (wrap-reload #'css-playground/app))

(defn start []
  (let [s @server]
    (if (some? s) (.stop s))
    (reset! server
            (run-jetty reloadable-app {:port 3000 :join? false}))))

(defn stop []
  (let [s @server]
    (if (some? s) (.stop s))
    (reset! server nil)))
