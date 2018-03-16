(ns forca.core
  (:gen-class))

(defn shortCut [carros]
    (->> carros
        (map (fn [x] (* x 2)))
        (map (fn [x] (* x 3)))
        (reduce (fn [acc n] (+ acc n)))
    )
)