package submarine

import submarine.subsystems.Point

class Vector {
    Point p1
    Point p2

    Vector(Point p1, Point p2) {
        if(!p1) throw new IllegalArgumentException('p1')
        if(!p2) throw new IllegalArgumentException('p2')

        this.p1 = p1
        this.p2 = p2
    }

    Vector(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.p1 = new Point(x1, y1)
        this.p2 = new Point(x2, y2)
    }
}
