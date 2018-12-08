(ns dev
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.move :refer :all]
            ;; [clojure.tools.namespace.repl :refer :all]
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
            [play-with-integrant.system.main :as main] ; TODO Delete this.
            [integrant.core :as ig]))

(ig-repl/set-prep! #(let [config (main/read-config)] ; TODO Is this right?
                      (ig/load-namespaces config)
                      config))

;; (defn the-preparer [] ig-state/preparer)
;; (defn the-config   [] ig-state/config)
;; (defn the-system   [] ig-state/system)

;; (comment

;;   [ig-state/preparer
;;    ig-state/config
;;    ig-state/system]

;;   )

;; ;;;; TODO Maybe define `stop` and `start` functions that tell the user what they
;; ;;;;      should use instead. ("This project uses Integrant. You want xxxx.".)

;; ;;;; TODO Learn all the `ig-repl` functions above.
;; ;;;; TODO What about `ig-repl/suspend`?
;; ;;;; TODO Isn't there a `resume` thing?
