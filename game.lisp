(def x 320)
(def y 100)
(def cubes nil)

(defn settings ()
    (size 640 360)
    (background 0))

(defn draw ()
    (background 120)
    (rect x y 32 32)
    (if (not (is-nil? cubes))
        (map draw-cube cubes))

    (if (mouse-button)
        (set cubes (list-append cubes '(@(mouse-x) @(mouse-y))))))

(defn draw-cube (element)
    (rect (n-th element 1)
          (n-th element 2)
          16
          16))

(defn key-pressed ()
    (def key (get-key))
    (if (= key "a") (set x (- x 10)))
    (if (= key "d") (set x (+ x 10)))
    (if (= key "s") (set y (+ y 10)))
    (if (= key "w") (set y (- y 10)))
    (if (= key " ") (set cubes nil)))