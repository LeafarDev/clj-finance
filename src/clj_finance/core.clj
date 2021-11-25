(ns clj-finance.core
  (:gen-class))

(defn generate-prices [lower-bound upper-bound]
  (filter (fn [x] (>= x lower-bound))
          (repeatedly (fn [] (rand upper-bound)))))

;;(take 1000000 (generate-prices 50 1000000000000000000))
(def pricelist (generate-prices 12 35))
;; (take 25 (map (fn [x] {:price x}) pricelist))

(take 25 (map (fn [x y]
                [x y])
              (map (fn [x] {:time x}) (iterate inc 0))
              (map (fn [x] {:price x}) pricelist)))

;; ([{:time 0} {:price 18.526602758087353}]
; [{:time 1} {:price 33.007014589970545}]...)
(take 25 (->> (map (fn [x y]
                     [x y])
                   (map (fn [x] {:time x}) (iterate inc 0))
                   (map (fn [x] {:price x}) pricelist))
              (map (fn [x] (merge (first x) (second x))))))
;; ({:time 0, :price 18.526602758087353}
; {:time 1, :price 33.007014589970545}...
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))