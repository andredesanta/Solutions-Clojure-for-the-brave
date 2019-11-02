(ns solutions.core
  (:gen-class))


(def asym-hobbit-body-parts [
                             {:name  "head" :size 3}
                             {:name  "left-eye" :size 1}
                             {:name  "left-ear" :size 1}
                             {:name  "mouth" :size 1}
                             {:name  "nose" :size 1}
                             {:name  "neck" :size 2}
                             {:name  "left-shoulder" :size 3}
                             {:name  "left-upper-arm" :size 3}
                             {:name  "chest" :size 10}
                             {:name  "back" :size 10}
                             {:name  "left-forearm" :size 3}
                             {:name  "abdomen" :size 6}
                             {:name  "left-kidney" :size 1}
                             {:name  "left-hand" :size 2}
                             {:name  "left-knee" :size 2}
                             {:name  "left-thigh" :size 4}
                             {:name  "left-lower-leg" :size 3}
                             {:name  "left-achilles" :size 1}
                             {:name  "left-foot" :size 2}])
;Ex2
(defn add100
  [number]
  (+ number 100))

;Ex3
(defn dec-maker
  [decnum]
  #(- % decnum))

;Ex4
(defn mapset
  ([f coll]
   (set(map f coll)))
  ([f c1 c2]
   (set(map f c1 c2))))

;Ex5 and 6
(defn erase-and-replace
  [full-string erase-part replace-part]
  (if (clojure.string/includes? full-string erase-part)
    (clojure.string/replace full-string erase-part replace-part)
    (full-string)))


(defn matching-part-n
  [part n]
  (if (clojure.string/includes? (:name part) "left")
    (loop [buffer []
           number 1]
      (if (> number n)
        buffer
        (recur (into buffer [{:name (erase-and-replace (:name part) "left" (str "number" "-" number)) :size (:size part)}])
              (inc number))))
    [part]))

(defn symmetrize-generic-body-parts
  [asym-body-parts number]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (matching-part-n part number)))
          []
          asym-body-parts))
