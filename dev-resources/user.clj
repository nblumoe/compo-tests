(ns user
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.namespace.repl :refer (refresh)]
            [compo-tests.core :as compo-tests]))

(def system nil)

(defn config []
  {:db {:uri "foo/bar"}
   :rabbit-mq {:queues ["queue-tweets" "queue-emails"]}})

(defn init []
  (alter-var-root #'system
                  (constantly (compo-tests/system (config)))))

(defn start []
  (alter-var-root #'system component/start))

(defn stop []
  (alter-var-root #'system
                  (fn [s] (when s (component/stop s)))))

(defn go []
  (init)
  (start))

(defn reset []
  (stop)
  (refresh :after 'user/go))
