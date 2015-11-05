(defproject compo-tests "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.stuartsierra/component "0.3.0"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [io.aviso/config "0.1.8"]
                 [com.novemberain/langohr "3.4.1"]]
  :main ^:skip-aot compo-tests.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
