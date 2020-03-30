(ns css-playground.core
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [ring.util.response :refer [content-type response]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]))

(defn materialize-hiccup-page []
  "head elem based on https://materializecss.com/templates/parallax-template/preview.html"
  (html5
   [:head
    [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
    [:meta {:name "viewport" :content "width-device-width, initial-scale=1"}]
    [:title "Materialize side nav example"]
    (include-css "https://fonts.googleapis.com/icon?family=Material+Icons"
                 "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")]
   [:body {:style "background-color: gray;"}
    [:div.container
     [:div.row {:style "background-color: black;"}
      [:div.col.s8.offset-s2.m5.l4 {:style "background-color: aliceblue;"}
       [:h1 "Mother"]]
      [:div.col.s6.m4.l3 {:style "background-color: antiquewhite;"}
       [:h3 "Funkin'"]]
      [:div.col.s6.m3.l3 {:style "background-color: aquamarine;"}
       [:h1 "CSS"]]
      [:div.col.s4.offset-s4.m2.l2 {:style "background-color: coral;"}
       [:h2 "Ya"]]
      [:div.col.s12.m8.l6.offset-l2 {:style "background-color: deeppink;"}
       [:h1 "Biiiiiiiiiiish!!!"]]
      [:div.col.s2.offset-s5.m2.l2 {:style "background-color: gold;"}
       [:h3 "!"]]]]
    (include-js "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js")]))

(defn handler [request]
  "If we get to this handler it means the `wrap-resource`
  middleware failed to find the file."
  (let [body (materialize-hiccup-page)]
    (-> body
        response
        (content-type "text/html"))))

(def app
  (-> handler
      (wrap-resource "public")
      (wrap-content-type)))

(defn -main [& args]
  (run-jetty app {:port 3000}))
