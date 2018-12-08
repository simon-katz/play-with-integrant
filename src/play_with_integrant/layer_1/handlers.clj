(ns play-with-integrant.layer-1.handlers
  (:require [clojure.string :as str]
            [integrant.core :as ig]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

(defn make-greeting [name]
  (str/join " "
            ["Hello there,"
             name]))

(defmethod ig/init-key :play-with-integrant.layer-1/handlers
  [_ {:keys [name]}]
  (log/info "Initializing `:play-with-integrant.layer-1/handlers`.")
  (fn [_] (resp/response (str/join " "
                                   ["[Less-dynamic string]"
                                    (make-greeting name)]))))

;;;; Note that we don't need to define a halt-key!.
