(ns aoc.day1
    (:require aoc.challenge))

(defn day1Part1 []
    (aoc.challenge/challenge 1 (fn [input] (->> 
            (clojure.string/split-lines input)
            (map (fn [e] (->>
                e
                (filter #(Character/isDigit %))
            )))
            (map #(str (first %) (last %)))
            (map #(Integer/parseInt %))
            (reduce +)
        )))
)

(defn parseToken [tok]
    (case tok
        "one" "1"
        "two" "2"
        "three" "3"
        "four" "4"
        "five" "5"
        "six" "6"
        "seven" "7"
        "eight" "8"
        "nine" "9"
        tok
    )
)


(defn day1Part2 []
    (aoc.challenge/challenge 1 (fn [input] (->> 
            (clojure.string/split-lines input)
            (map #(map (fn [e] (parseToken (last e))) (re-seq #"(?=(one|two|three|four|five|six|seven|eight|nine|\d))" %)))
            (map #(str (first %) (last %)))
            (map #(Integer/parseInt %))
            (reduce +)
        )))  
)
