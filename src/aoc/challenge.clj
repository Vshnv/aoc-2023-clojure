(ns aoc.challenge)

(defn challenge [day solution]
    (let [input (slurp (format "resources/day%d.txt" day))]
        (solution input)
    )
)