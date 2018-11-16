(ns reframe-works.react-lib
  (:require
   [reagent.core :as reagent]
   ["react-bulma-components" :as bulma :refer (Box Section Button Hero Container Heading)]))

(def state (reagent/atom true))

(defn on-click []
  (reset! state (not @state)))

(defn hero-container []
  [:> Container
   [:> Heading "Hero title Primary0"]
   [:> Heading {:subtitle true :size 3} "Subtitle"]])

(defn home []
  [:div
   [:> Section
    [:> Box nil "Play with the button"]
    [:> Button {:onClick on-click} "Button #1"]
    [:> Button {:rounded true :disabled @state} "Button #2"]]
   [:> Hero {:color "primary"}
    [:> bulma/Hero.Body (hero-container)]]])