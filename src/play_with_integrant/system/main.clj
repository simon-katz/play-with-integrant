(ns play-with-integrant.system.main
  (:require [integrant.core :as ig]
            [play-with-integrant.system.config-for-ig :as config-for-ig]))

(defn -main []
  (let [config-for-ig (config-for-ig/read-config-loading-namespaces)]
    (ig/init config-for-ig)))
