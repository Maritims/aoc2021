package geometry

class Line2D {
    Point2D p1
    Point2D p2

    Line2D(Point2D p1, Point2D p2) {
        this.p1 = p1
        this.p2 = p2
    }

    Line2D(Integer x1, Integer y1, Integer x2, Integer y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2))
    }
}
