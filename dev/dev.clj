(ns dev
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.move :refer :all]
            [clojure.tools.namespace.repl :refer :all]
            [com.nomistech.clj-utils :as nu]
            [midje.repl :refer :all]
            [nomis-clj-repl-tools :refer :all]
            [play-with-integrant.main :as main]
            [taoensso.timbre :as log]))

#_
(do (main/stop)
    (main/start))
