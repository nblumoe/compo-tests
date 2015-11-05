(ns compo-tests.db
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]))

(defn get-user [database username]
  ;; retrieve user
  )

(defn seed [database filename]
  (println "Seeding data from" filename))

(defn tear-down [database]
  (println "Tearing down DB..."))

(defrecord Database [uri]
  component/Lifecycle

  (start [component]
    component)

  (stop [component]
    component))

(defn new-database [{:as config :keys [uri]}]
  (map->Database {:uri uri}))
