(ns aoc.day2
    (:require aoc.challenge))

(defn validateGamePart1 [{red "red" green "green" blue "blue"}] 
    (and (<= red 12) (<= green 13) (<= blue 14))
)

(defn day2Part1 []
    (aoc.challenge/challenge 2 (fn [input] (->> 
            (clojure.string/split-lines input)
            (map (fn [game] (->>
                game
                (#(second (clojure.string/split % #": ")))
                (#(clojure.string/split % #"; "))
                (map #(clojure.string/split % #", | "))
                (map #(apply hash-map (reverse %)))
                (map #(update-vals % (fn [e] (Integer/parseInt e))))
                (apply merge-with max)
                (validateGamePart1)
            )))
            (map-indexed #(if %2 (inc %1) 0))
            (reduce +)
        )))
)


(defn day2Part2 []
    (aoc.challenge/challenge 2 (fn [input] (->> 
            (clojure.string/split-lines input)
            (map (fn [game] (->>
                game
                (#(second (clojure.string/split % #": ")))
                (#(clojure.string/split % #"; "))
                (map #(clojure.string/split % #", | "))
                (map #(apply hash-map (reverse %)))
                (map #(update-vals % (fn [e] (Integer/parseInt e))))
                (apply merge-with max)
                (vals)
                (reduce *)
            )))
            (reduce +)
        )))
)