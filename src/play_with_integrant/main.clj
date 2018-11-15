(ns play-with-integrant.main
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]))

;;;; ___________________________________________________________________________

(defn read-config []
  (ig/read-string (slurp (io/resource "integrant-play.edn"))))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :adapter/jetty [_ {:keys [handler] :as opts}]
  (jetty/run-jetty handler
                   (-> opts
                       (dissoc :handler)
                       (assoc :join? false))))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (.stop server))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (fn [_] (resp/response (str "Hello " name))))

;;;; Note that we don't need to define a halt-key! for `:handler/greet`.

;;;; ___________________________________________________________________________

(defn -main []
  (ig/init (read-config)))
