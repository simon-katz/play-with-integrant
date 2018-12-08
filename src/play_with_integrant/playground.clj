(ns play-with-integrant.playground
  (:require [integrant.core :as ig]
            [taoensso.timbre :as log]))

;;;; ___________________________________________________________________________

(defmethod ig/init-key :play-with-integrant.playground/key-001
  [k v]
  (log/info "Initializing `:play-with-integrant.playground/key-001`.")
  {:wrapped-by-init v})

(defmethod ig/halt-key! :play-with-integrant.playground/key-001
  [k v]
  (log/info "Halting `:play-with-integrant.playground/key-001`.")
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)

;;;; ___________________________________________________________________________

;;;; TODO Add `ig/suspend-key!` and `ig/resume-key` examples.
;;;; TODO Add `ig/prep-key!` examples.

;;;; ___________________________________________________________________________
;;;; Keyword hierarchy example.

(derive :play-with-integrant.playground/key-002
        :play-with-integrant.playground/super-of-key-002)

(defmethod ig/init-key :play-with-integrant.playground/super-of-key-002
  [k v]
  (log/info "Initializing `:play-with-integrant.playground/super-of-key-002`.")
  {:wrapped-by-init v})

(defmethod ig/halt-key! :play-with-integrant.playground/super-of-key-002
  [k v]
  (log/info "Halting `:play-with-integrant.playground/super-of-key-002`.")
  :this-value-is-ignored-which-means-you-cannot-change-the-values-in-the-system)
