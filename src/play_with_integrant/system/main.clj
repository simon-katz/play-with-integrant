(ns play-with-integrant.system.main
  (:require [clojure.string :as str]
            [integrant.core :as ig]
            [play-with-integrant.system.config :as config]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

(defn -main []
  (let [config (config/read-config)]
    (ig/load-namespaces config) ; TODO Seems odd to do this at run time. Is this right?
    (ig/init config)))
