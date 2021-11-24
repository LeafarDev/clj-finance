(ns clj-finance.core
  (:gen-class))

(defn generate-prices [lower-bound upper-bound]
  (filter (fn [x] (>= x lower-bound))
          (repeatedly (fn [] (rand upper-bound)))))

;;(take 1000000 (generate-prices 50 1000000000000000000))
(def pricelist (c/generate-prices 12 35))
;; (take 25 (map (fn [x] {:price x}) pricelist))
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))