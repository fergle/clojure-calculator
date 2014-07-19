(ns clojure-calculator.core-test
  (:require [expectations :refer :all]
            [clojure-calculator.core :refer :all]))

;; An empty string should return 0
(expect 0 (sum-a-string ""))

;; A single digit should return itself
(expect 1 (sum-a-string "1"))

;; Two numbers separated by a comma should be summed
(expect 3 (sum-a-string "1,2"))

;; Any amount of comma-separated numbers should be summed
(expect 15 (sum-a-string "1,2,3,4,5"))

;; New line character should be treated as a separator
(expect 6 (sum-a-string "1\n2,3"))

;; Custom delimited should be treated as a separator
(expect 3 (sum-a-string "//;\n1;2"))

;; Numbers bigger than 1000 should be removed
(expect 2 (sum-a-string "2,1001"))

;; Negative numbers should be thrown an exception
(expect Exception (sum-a-string "-1,2"))

;; Multiple character delimiters should be treated as separator
(expect 6 (sum-a-string "//[***]\n1***2***3"))
(expect 6 (sum-a-string "//[*][%]\n1*2%3"))
