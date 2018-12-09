(ns play-with-integrant.system.config-for-ig
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]))

(defn ^:private read-config []
  (let [config-filename "ig-config.edn"
        config-file     (io/resource config-filename)]
    (assert config-file (format "Could not find file  \"%s\""
                                config-filename))
    (-> config-file
        slurp
        ig/read-string)))

(defn read-config-loading-namespaces []
  (let [config-for-ig (read-config)]
    (ig/load-namespaces config-for-ig) ; TODO Seems odd to do this at run time. Is this right?
    config-for-ig))
