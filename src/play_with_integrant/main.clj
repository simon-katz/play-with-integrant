(ns play-with-integrant.main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
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

(defn make-greeting [name]
  (str/join " "
            ["Hello there,"
             name]))

(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (log/info "Initializing :handler/greet .")
  (fn [_] (resp/response (str/join " "
                                   ["[Less-dynamic string]"
                                    (make-greeting name)]))))

;;;; Note that we don't need to define a halt-key! for `:handler/greet`.

;;;; ___________________________________________________________________________

(defmethod ig/init-key :my-key-001 [k v]
  (log/info "Initializing :my-key-001 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  v)

(defmethod ig/halt-key! :my-key-001 [k v]
  (log/info "Halting :my-key-001 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)

;;;; ___________________________________________________________________________

(defmethod ig/init-key :my-key-002 [k v]
  (log/info "Initializing :my-key-002 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  v)

(defmethod ig/halt-key! :my-key-002 [k v]
  (log/info "Halting :my-key-002 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)

;;;; ___________________________________________________________________________

(defmethod ig/init-key :my-key-003 [k v]
  (log/info "Initializing :my-key-003 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  v)

(defmethod ig/halt-key! :my-key-003 [k v]
  (log/info "Halting :my-key-003 .")
  (log/debug "    x =" k)
  (log/debug "    y =" v)
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)

;;;; ___________________________________________________________________________

(defn -main []
  (ig/init (read-config)))
