(ns play-with-integrant.layer-1.webserver
  (:require [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]
            [taoensso.timbre :as log]))

(defmethod ig/init-key :play-with-integrant.layer-1/webserver
  [_ {:keys [handler] :as opts}]
  (log/info "Initializing `:play-with-integrant.layer-1/webserver`.")
  (jetty/run-jetty handler
                   (-> opts
                       (dissoc :handler)
                       (assoc :join? false))))

(defmethod ig/halt-key! :play-with-integrant.layer-1/webserver
  [_ server]
  (log/info "Halting `:play-with-integrant.layer-1/webserver`.")
  (.stop server))
