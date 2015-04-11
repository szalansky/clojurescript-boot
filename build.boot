(set-env!
 :source-paths   #{"src"}
 :resource-paths #{"html"}
 :dependencies
 '[[org.clojure/clojure       "1.7.0-alpha5"   :scope "provided"]
   [org.clojure/clojurescript "0.0-2985"       :scope "provided"]
   [org.clojure/core.async    "0.1.346.0-17112a-alpha"]
   [rum                       "0.2.6"]

   [adzerk/boot-cljs          "0.0-2814-3"     :scope "test"]
   [cljsjs/boot-cljsjs        "0.4.6"          :scope "test"]
   [adzerk/boot-cljs-repl     "0.1.9"          :scope "test"]
   [adzerk/boot-reload        "0.2.6"          :scope "test"]
   [pandeiro/boot-http        "0.6.3-SNAPSHOT" :scope "test"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[cljsjs.boot-cljsjs    :refer [from-cljsjs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]])

(deftask dev
 "Start the dev env..."
 []
 (comp
   (watch)
   (serve :dir "target" :port 3000)
   (cljs-repl)
   (from-cljsjs :profile :development)
   (cljs :unified true
         :source-map true
         :optimizations :none)
   (reload)))
