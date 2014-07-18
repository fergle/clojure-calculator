(ns clojure-calculator.core)

(defn string->numbers [string]
  (map read-string (clojure.string/split string #",|\n")))

(defn sum-a-string [string]
  (if (empty? string)
    0
    (reduce + (string->numbers string))))





