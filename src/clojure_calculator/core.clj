(ns clojure-calculator.core)

(defn string->numbers [string]
  (map read-string (re-seq #"[\d]+|-[\d]+" string)))

(defn sum-a-string [string]
  (let [numbers (string->numbers string)]
    (when-let [negative-numbers (not-empty (filter neg? numbers))]
      (throw (Exception. (str "Negatives not allowed:" negative-numbers))))
    (reduce + (filter #(< % 1001) numbers))))





