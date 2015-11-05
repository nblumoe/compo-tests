(ns compo-tests.rabbit-mq-test
  (:require [clojure.test :refer :all]
            [compo-tests.fixtures.system :refer [system-fixture *system*]]
            [compo-tests.rabbit-mq :refer :all]
            [com.stuartsierra.component :as component]))

(use-fixtures :each system-fixture)

(deftest start-test
  (let [this-component (component/start (:message-queue *system*))]
    (is (:connection this-component))
    (is (:channel this-component))
    (is (= ["test-queue-1" "test-queue-2"]
           (map :queue (:queues this-component))))))
