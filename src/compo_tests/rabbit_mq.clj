(ns compo-tests.rabbit-mq
  (:require [clojure.test :refer :all]
            [langohr.core :as langohr]
            [langohr.channel :as channel]
            [com.stuartsierra.component :as component]))

(defrecord RabbitMQ [config connection channel]
  component/Lifecycle

  (start [component]
    (let [connection (langohr/connect)
          channel (channel/open )]
      (assoc component
             :connection connection
             :channel channel)))

  (stop [component]
    (-> component :channel langohr/close)
    (-> component :connection langohr/close)
    (assoc component
           :connection nil
           :channel nil)))

(defn new-rabbit-mq [config]
  (map->RabbitMQ config))
