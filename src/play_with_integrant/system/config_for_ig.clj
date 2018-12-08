(ns play-with-integrant.system.config-for-ig
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]))

(defn ^:private read-config []
  (ig/read-string (slurp (io/resource "integrant-play.edn"))))

(defn read-config-loading-namespaces []
  (let [config-for-ig (read-config)]
    (ig/load-namespaces config-for-ig) ; TODO Seems odd to do this at run time. Is this right?
    config-for-ig))
