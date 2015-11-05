(ns compo-tests.app
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]))

(defrecord App [config database message-queue]
  component/Lifecycle

  (start [component]
    component)

  (stop [component]
    component))

(defn new-app [config]
  (map->App {:config config}))
