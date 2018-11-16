(ns reframe-works.core
  (:require [reagent.core :as r]
            [reframe-works.react-lib :refer [home hero-container]]
            [reframe-works.routing :refer [app-routes current-page]]))

(defn start []
  ; (app-routes)
  (r/render-component [home]
                      (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
