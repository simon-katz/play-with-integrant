(ns play-with-integrant.system.config
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]))

(defn read-config []
  (ig/read-string (slurp (io/resource "integrant-play.edn"))))
