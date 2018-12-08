(ns dev
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.move :refer :all]
            [clojure.tools.namespace.repl :refer [refresh
                                                  refresh-all]]
            [com.nomistech.clj-utils :as nu]
            [integrant.core :as ig]
            [integrant.repl
             :as ig-repl
             :refer [
                     ;; TODO Learn all the `ig-repl` functions.
                     ;; TODO Do you need all these?
                     prep
                     init
                     go
                     suspend
                     resume
                     halt
                     reset
                     reset-all
                     clear]]
            [integrant.repl.state :as ig-state]
            [midje.repl :refer :all]
            [nomis-clj-repl-tools :refer :all]
            [play-with-integrant.system.config-for-ig :as config-for-ig]))

(defn dev-prep [] ; TODO Is this right?
  (let [config-for-ig (config-for-ig/read-config)]
    (ig/load-namespaces config-for-ig)
    config-for-ig))

(ig-repl/set-prep! dev-prep)

(defn the-ig-preparer [] ig-state/preparer)
(defn the-ig-config   [] ig-state/config)
(defn the-ig-system   [] ig-state/system)

(defn the-ig-info []
  {:the-ig-preparer (the-ig-preparer)
   :the-ig-config   (the-ig-config)
   :the-ig-system   (the-ig-system)})

(defn start []
  (throw
   (Exception. "This is an Integrant project. You want `resume`." ; TODO Right?
               )))

(defn stop []
  (throw
   (Exception. "This is an Integrant project. You want `suspend`." ; TODO Right?
               )))
