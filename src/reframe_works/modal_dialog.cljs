(ns reframe-works.modal-dialog
  (:require [reagent.core :as reagent]
            [reagent-modals.modals :as reagent-modals]))

(defn modal-window-button []
  [:div.btn.btn-primary
   {:on-click #(reagent-modals/modal! [:div "Some message"])} "My Modal"])

(defn home []
  [:div
   [reagent-modals/modal-window]
   [modal-window-button]])