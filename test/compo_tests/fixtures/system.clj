(ns compo-tests.fixtures.system
  (:require [compo-tests.core :as compo-tests]
            [com.stuartsierra.component :as component]))

(def ^:dynamic *system*)

(def test-config
  {:datomic {:uri "foo/test"}
   :rabbit-mq {:queues ["test-queue-1" "test-queue-2"]}})

(defn system-fixture [test-function]
  (binding [*system* (component/start (compo-tests/system test-config))]
    (test-function)))
