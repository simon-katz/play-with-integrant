(ns play-with-integrant.layer-1.top-level-handler
  (:require [clojure.string :as str]
            [integrant.core :as ig]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

(defn ^:private make-greeting [name]
  (str/join " "
            ["Hello there,"
             name
             "-- no `reset` is needed to change this"]))

(defmethod ig/init-key :play-with-integrant.layer-1/top-level-handler
  [_ {:keys [name]}]
  (log/info "Initializing `:play-with-integrant.layer-1/top-level-handler`.")
  (fn [_] (resp/response (str/join " "
                                   [(make-greeting name)
                                    "-- a `reset` is needed to change this"]))))

;;;; Note that we don't need to define a halt-key!.
