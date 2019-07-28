(ns hackernews-pwa.events
  (:require
   [re-frame.core :as re-frame]
   [hackernews-pwa.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
