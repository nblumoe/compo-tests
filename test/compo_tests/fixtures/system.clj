(ns compo-tests.fixtures.system
  (:require [compo-tests.core :as compo-tests]
            [compo-tests.db :as db]
            [com.stuartsierra.component :as component]))

(def ^:dynamic *system*)

(def test-config
  {:datomic {:uri "foo/test"}
   :rabbit-mq {:queues ["test-queue-1" "test-queue-2"]}})

(defn system-fixture [test-function]
  (binding [*system* (compo-tests/system test-config)]
    (db/seed (component/start (:database *system*)) "path/to/seed/file.edn")
    (test-function)
    (db/tear-down (:database *system*))
    ))
