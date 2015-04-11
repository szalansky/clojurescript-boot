(ns tiktak.core
  (:require [rum :as r]))

(enable-console-print!)

(def post
  {:text "First post"
   :author "Jane"})

(r/defc render-post [post]
  [:blockquote (str (:text post) " ") [:cite (:author post)]])

(r/mount (render-post post)
         (.getElementById js/document "app"))
