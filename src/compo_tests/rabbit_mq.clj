(ns compo-tests.rabbit-mq
  (:require [com.stuartsierra.component :as component]
            [langohr.channel :as channel]
            [langohr.core :as langohr]
            [langohr.queue :as queue]))

(defn declare-queues [{:as component :keys [config channel]}]
  (->> (doall (map #(queue/declare channel %) (:queues config)))
       (assoc component :queues)))

(defrecord RabbitMQ [config connection channel]
  component/Lifecycle

  (start [component]
    (let [connection (langohr/connect)
          channel (channel/open connection)]
      (-> (assoc component
                 :connection connection
                 :channel channel)
          declare-queues)))

  (stop [component]
    (-> component :channel langohr/close)
    (-> component :connection langohr/close)
    (assoc component
           :connection nil
           :channel nil)))

(defn new-rabbit-mq [config]
  (map->RabbitMQ {:config config}))
