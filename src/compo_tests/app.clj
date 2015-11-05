(ns compo-tests.app
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]))

(defrecord App [config db rabbit-mq]
  component/Lifecycle

  (start [component]
    component)

  (stop [component]
    component))

(defn new-app [config]
  (map->App config))
