(ns compo-tests.db
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]))

(defn get-user [database username]

  )

(defrecord Database [uri]
  component/Lifecycle

  (start [component]
    component)

  (stop [component]
    component))

(defn new-database [{:as config :keys [uri]}]
  (map->Database {:uri uri})
  )
