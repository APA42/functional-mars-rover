(ns mars-clojure.core)


(defmulti execute-command (fn [rover _] (:facing rover)))

(defmethod execute-command :north
  [rover command]
  (case command
    \f (assoc rover :y (inc (:y rover)))
    \b (assoc rover :y (dec (:y rover)))
    \r (assoc rover :facing :east)
    \l (assoc rover :facing :west)
    )
  )

(defmethod execute-command :east
  [rover command]
  (case command
    \f (assoc rover :x (inc (:x rover)))
    \b (assoc rover :x (dec (:x rover)))
    \r (assoc rover :facing :south)
    \l (assoc rover :facing :north)
    )
  )


(defn move-rover
  [rover commands]
  (reduce (fn
            [partial-rover command]
            (execute-command partial-rover command)) rover commands)

  )
