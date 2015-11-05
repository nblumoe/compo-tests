(ns compo-tests.core
  (:gen-class)
  (:require [compo-tests.app :as app]
            [compo-tests.db :as db]
            [compo-tests.rabbit-mq :as rabbit-mq]
            [com.stuartsierra.component :as component]))

(defonce config
  ;; this data could come from a simple file slurp or be imported via
  ;; a configuration library in whatever way
  {:datomic {:uri "foo/bar"}
   :rabbit-mq {:queues ["queue-tweets" "queue-emails"]}})

(defn system [config]
  (component/system-map
   :database (db/new-database (:datomic config))
   :message-queue (rabbit-mq/new-rabbit-mq (:rabbit-mq config))
   :app (component/using (app/new-app config)
                         [:database :message-queue])))

(defn -main [& args]
  (component/start (system config)))
