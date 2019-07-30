(ns hackernews-pwa.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [hackernews-pwa.events :as events]
   [hackernews-pwa.subs :as subs]
   [hackernews-pwa.views :as views]
   [hackernews-pwa.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
