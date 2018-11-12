(ns reframe-works.react-lib
  (:require
   [reagent.core :as reagent]
   ["react" :as react]
   ["react-bulma-components" :as bulma :refer (Box Section Button Hero Container Heading)]))

(def state (reagent/atom true))

(defn on-click []
  (reset! state (not @state)))

(defn $
  ([element] ($ element nil nil))
  ([element props] ($ element props nil))
  ([element props body]
   (let [new-props (clj->js (merge {:key (str (gensym))} props))]
     (react/createElement element new-props body))))

(defn hero-container []
  ($ Container nil
     [($ Heading nil "Hero title Primary")
      ($ Heading {:subtitle true :size 3} "Subtitle")]))

(defn home []
  [:div
   ($ Section nil
      [($ Box nil "Play with the button")
       ($ Button {:onClick on-click} "Button #1")
       ($ Button {:rounded true :disabled @state} "Button #2")])
   ($ Hero {:color "primary"}
      ($ bulma/Hero.Body nil (hero-container)))])