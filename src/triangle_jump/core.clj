(ns triangle-jump.core
  (:require [clojure.set :as set])
  (:gen-class))

(def board
  "The starting board state."
  {1  {:pegged true :connections {4 2, 6 3}}
   2  {:pegged true :connections {7 4, 9 5}}
   3  {:pegged true :connections {8 5, 10 6}}
   4  {:pegged true :connections {1 2, 6 5, 13 8, 11 7}}
   5  {:pegged true :connections {12 8, 14 9}}
   6  {:pegged true :connections {4 5, 13 9, 15 10, 1 3}}
   7  {:pegged true :connections {2 4, 9 8}}
   8  {:pegged true :connections {3 5, 10 9}}
   9  {:pegged true :connections {2 5, 7 8}}
   10 {:pegged true :connections {3 6, 8 9}}
   11 {:pegged true :connections {4 7, 13 12}}
   12 {:pegged true :connections {5 8, 14 13}}
   13 {:pegged true :connections {11 12, 4 8, 6 9, 15 14}}
   14 {:pegged true :connections {12 13, 5 9}}
   15 {:pegged true :connections {13 14, 6 10}}})

(defn triangle-numbers*
  "Generate an infinite sequence of triangle numbers."
  ([] (triangle-numbers* 0 1))
  ([sum n]
   (let [next-sum (+ sum n)]
     (cons next-sum
           (lazy-seq (triangle-numbers* next-sum
                                        (inc n)))))))

(def triangle-numbers (triangle-numbers*))

(defn triangular?
  "Check if a number is a triangle number."
  [n]
  (= n (last (take-while #(<= % n) triangle-numbers))))

(defn row-triangle
  "Get the triangle number at the end of a row."
  [row]
  (nth triangle-numbers (dec row)))

(defn row-number
  "Get the row number the position belongs to."
  [position]
  (inc (count (take-while #(> position %) triangle-numbers))))

(defn connect
  "Create a connection between two positions."
  [board max-position position neighbour destination]
  (if (<= destination max-position)
    nil
    board))

(defn connect-right
  [board max-position position])

(defn connect-down-left
  [board max-position position])

(defn connect-down-right
  [board max-position position])

(defn -main
  [& args]
  (println "Hello, world!"))
