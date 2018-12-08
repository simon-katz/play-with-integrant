(ns play-with-integrant.system.main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [integrant.core :as ig]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

(defn read-config []
  (ig/read-string (slurp (io/resource "integrant-play.edn"))))

(defn -main []
  (ig/load-namespaces) ; TODO Seems odd to do this at run time. Is this right?
  (ig/init (read-config)))
