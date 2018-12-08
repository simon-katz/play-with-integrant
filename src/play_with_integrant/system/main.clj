(ns play-with-integrant.system.main
  (:require [integrant.core :as ig]
            [play-with-integrant.system.config-for-ig :as config-for-ig]))

(defn -main []
  (let [config-for-ig (config-for-ig/read-config)]
    (ig/load-namespaces config-for-ig) ; TODO Seems odd to do this at run time. Is this right?
    (ig/init config-for-ig)))
