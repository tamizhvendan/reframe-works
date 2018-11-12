(ns reframe-works.react-lib
  (:require
   [reagent.core :as reagent]
   ["react" :rename {createElement $}]
   ["react-bulma-components" :as bulma :refer (Box Section Button Hero Container Heading)]))

(def state (reagent/atom true))

(defn on-click []
  (reset! state (not @state)))

(defn hero-container []
  ($ Container nil
     [($ Heading nil "Hero title Primary")
      ($ Heading #js {:subtitle true :size 3} "Subtitle")]))

(defn home []
  [:div
   ($ Section nil
      [($ Box nil "Play with the button")
       ($ Button #js {:onClick on-click} "Button #1")
       ($ Button #js {:rounded true :disabled @state} "Button #2")])
   ($ Hero #js {:color "primary"}
      ($ bulma/Hero.Body #js {} (hero-container)))])