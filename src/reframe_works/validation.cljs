(ns reframe-works.validation
  (:require [reagent.core :as reagent]))

(defn password-valid?
  "Valid if password is greater than 5 characters"
  [password]
  (> (count password) 5))

(defn password-color [password]
  (let [valid-color "green"
        invalid-color "red"]
    (if (password-valid? password)
      valid-color
      invalid-color)))

(def form-state (reagent/atom {:password nil}))

(defn password []
  [:input {:type "password"
           :on-change #(swap! form-state assoc :password (-> % .-target .-value))}])

(defn home []
  [:div {:style {:margin-top "30px"}}
   "Please enter a password greater than 5 characters. "
   [:span {:style {:padding "20px"
                   :background-color (password-color (@form-state :password))}}
    [password]]])