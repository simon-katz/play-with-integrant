(ns play-with-integrant.system.main
  (:gen-class)
  (:require [integrant.core :as ig]
            [play-with-integrant.system.config-for-ig :as config-for-ig]))

(defn -main []
  (-> (config-for-ig/read-config-loading-namespaces)
      ig/prep
      ig/init))
