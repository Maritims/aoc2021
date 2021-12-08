package geometry

class Point2D {
    Integer x
    Integer y

    Point2D(Integer x, Integer y) {
        this.x = x
        this.y = y
    }

    String toString() {
        "(${x}, ${y})"
    }
}
