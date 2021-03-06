(defproject play-with-integrant "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[com.nomistech/clj-utils "0.9.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [integrant "0.7.0"]
                 [org.clojure/clojure "1.9.0"]
                 [ring "1.7.1"]]
  :main play-with-integrant.system.main
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[integrant/repl "0.3.1"]
                                  [midje "1.9.4"]
                                  [nomis-clj-repl-tools "0.1.2"]]
                   :plugins [[lein-nomis-ns-graph "0.14.2"]]
                   :source-paths ["dev"]
                   :repl-options {:init-ns dev}}
             :uberjar {:aot :all}})
