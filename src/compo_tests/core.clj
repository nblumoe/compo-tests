(ns compo-tests.core
  (:gen-class)
  (:require [compo-tests.app :as app]
            [compo-tests.db :as db]
            [compo-tests.rabbit-mq :as rabbit-mq]
            [com.stuartsierra.component :as component]))

(defn system [config]
  (component/system-map
   :db (db/new-database (:db config))
   :rabbit-mq (rabbit-mq/new-rabbit-mq (:rabbit-mq config))
   :app (component/using
         (app/new-app config)
         [:db :rabbit-mq])))

(defn -main
  [& args]
  (component/start
   (system {:db {:uri "foo/bar"}
            :rabbit-mq nil})))
