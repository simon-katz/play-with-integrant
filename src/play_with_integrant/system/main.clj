(ns play-with-integrant.system.main
  (:require [integrant.core :as ig]
            [play-with-integrant.system.config :as config]))

(defn -main []
  (let [config (config/read-config)]
    (ig/load-namespaces config) ; TODO Seems odd to do this at run time. Is this right?
    (ig/init config)))
