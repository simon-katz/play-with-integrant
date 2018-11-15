(ns play-with-integrant.main
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

;;;; ___________________________________________________________________________

(defn read-config []
  (ig/read-string (slurp (io/resource "integrant-play.edn"))))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :adapter/jetty [_ {:keys [handler] :as opts}]
  (log/info "Initializing :adapter/jetty .")
  (jetty/run-jetty handler
                   (-> opts
                       (dissoc :handler)
                       (assoc :join? false))))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (log/info "Halting :adapter/jetty .")
  (.stop server))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (log/info "Initializing :handler/greet .")
  (fn [_] (resp/response (str "Hello " name))))

;;;; Note that we don't need to define a halt-key! for `:handler/greet`.

;;;; ___________________________________________________________________________

(defn -main []
  (ig/init (read-config)))
