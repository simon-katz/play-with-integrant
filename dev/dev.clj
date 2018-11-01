(ns dev
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.move :refer :all]
            [clojure.tools.namespace.repl :refer :all]
            [com.nomistech.clj-utils :as nu]
            [integrant.repl :as ig-repl]
            [integrant.repl.state :as ig-state]
            [midje.repl :refer :all]
            [nomis-clj-repl-tools :refer :all]
            [play-with-integrant.main :as main]
            [taoensso.timbre :as log]))

;;;; TODO See manage-recordings-v3 stuff

(defn go [ig-config]
  (ig-repl/set-prep! main/read-config)
  (ig-repl/go))

(defn reset []
  (ig-repl/reset))

(defn reset-all []
  (ig-repl/reset-all))

(defn halt
  "Stops system"
  []
  (ig-repl/halt))

#_
(defn clear
  "Clears system state"
  []
  (ig-repl/clear))

(defn the-config []
  ig-state/config)

(defn the-system []
  "Return system state"
  ig-state/system)
