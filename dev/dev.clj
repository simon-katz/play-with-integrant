(ns dev
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.move :refer :all]
            [clojure.tools.namespace.repl :refer [refresh
                                                  refresh-all]]
            [com.nomistech.clj-utils :as nu]
            [integrant.repl
             :as ig-repl
             :refer [prep
                     init
                     go
                     halt
                     reset
                     reset-all
                     clear]]
            [integrant.repl.state :as ig-state]
            [midje.repl :refer :all]
            [nomis-clj-repl-tools :refer :all]
            [play-with-integrant.system.config :as config]
            [integrant.core :as ig]))

(defn dev-prep [] ; TODO Is this right?
  (let [config (config/read-config)]
    (ig/load-namespaces config)
    config))

(ig-repl/set-prep! dev-prep)

(defn the-preparer [] ig-state/preparer)
(defn the-config   [] ig-state/config)
(defn the-system   [] ig-state/system)

(defn the-info []
  {:preparer ig-state/preparer
   :config   ig-state/config
   :system   ig-state/system})

(defn start []
  (throw (Exception. "This is an Integrant project. You want `xxxx`.")) ; TODO
  )

(defn stop []
  (throw (Exception. "This is an Integrant project. You want `halt`.")) ; TODO
  )

;; ;;;; TODO Learn all the `ig-repl` functions above.
;; ;;;; TODO What about `ig-repl/suspend`?
;; ;;;; TODO Isn't there a `resume` thing?
