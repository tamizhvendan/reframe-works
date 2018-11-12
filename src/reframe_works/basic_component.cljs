(ns reframe-works.basic-component
  (:require [reagent.core :as reagent]))

; Form-3
(defn foo []
  (reagent/create-class
   {:reagent-render (fn []
                      [:div "Foo: Hello, world!"])}))
; Form-1
(defn bar []
  [:div "Bar: Hello, World!"])

; Form-2
(defn baz []
  (fn []
    [:div "Baz: Hello, World!"]))

(defn hello-world []
  [:div
   [foo]
   [bar]
   [baz]])