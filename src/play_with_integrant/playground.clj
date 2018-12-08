(ns play-with-integrant.playground
  (:require [integrant.core :as ig]
            [taoensso.timbre :as log]))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :play-with-integrant.playground/key-001
  [k v]
  (log/info "Initializing `play-with-integrant.playground/key-001`.")
  {:wrapped-by-init v})

(defmethod ig/halt-key! :play-with-integrant.playground/key-001
  [k v]
  (log/info "Halting `play-with-integrant.playground/key-001`.")
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)

;;;; ___________________________________________________________________________

;;;; TODO Getting rid of this and doing `reset` doesn't give an error.
;;;;      The methods are still there.
;;;;      So this breaks dev workflow.
;;;;      Is this a general thing when you define methods for multimethods that
;;;;      are defined in libraries?

(defmethod ig/init-key :play-with-integrant.playground/key-002
  [k v]
  (log/info "Initializing `play-with-integrant.playground/key-002`.")
  {:wrapped-by-init v})

(defmethod ig/halt-key! :play-with-integrant.playground/key-002
  [k v]
  (log/info "Halting `play-with-integrant.playground/key-002`.")
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)
