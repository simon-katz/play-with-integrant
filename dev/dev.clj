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




;;;; TODO Oh, I thought `ig-repl` would provide most of the following.

;;;; TODO Hmmm, does this work? Calling `reset` throws an exception.

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


;;;; ___________________________________________________________________________

(def the-config (main/read-config))

(def z-system)

(defn z-init []
  (alter-var-root #'z-system
                  (fn [_] (integrant.core/init the-config))))

(defn z-reinit
  ([]
   (integrant.core/init z-system))
  ([keys]
   (integrant.core/init z-system keys)))

(defn z-halt!
  ([]
   (assert (bound? #'z-system))
   (integrant.core/halt! z-system))
  ([keys]
   (assert (bound? #'z-system))
   (integrant.core/halt! z-system keys)))


(comment

  ;; Bug, I think. This sequence does not stop the server, and we get an
  ;; "Address already in use" error when trying to start.
  ;; Ah! You are using `alter-var-root` -- that's blatting things.

  (z-init)
  (z-halt! [:my-key-002])
  (z-reinit [:my-key-002])
  (z-halt!)
  (z-reinit) ; This fails with org.eclipse.jetty.server.Server cannot be cast to clojure.lang.IPersistentMap

  )
