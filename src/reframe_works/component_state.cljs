(ns reframe-works.component-state
  (:require [reagent.core :as reagent]))

(defn foo []
  (let [state (reagent/atom {:count 0})]
    (fn []
      [:div
       [:p "Current count is: " (:count @state)]
       [:button {:on-click #(swap! state update-in [:count] inc)} "Click me"]])))
