package submarine.subsystems

import geometry.Line2D

class AdvancedHydrothermalSensor extends HydrothermalSensor {
    AdvancedHydrothermalSensor(Integer maxX, Integer maxY, List<Line2D> vectors) {
        super(maxX, maxY, vectors)
    }

    @Override
    void drawVector(Line2D vector) {
        def x1 = vector.p1.x
        def x2 = vector.p2.x
        def y1 = vector.p1.y
        def y2 = vector.p2.y
        for(def x = x1; x1 < x2 ? x <= x2 : x >= x2; x += (x1 < x2 ? 1 : -1)) {
            for(def y = y1; y1 < y2 ? y <= y2 : y >= y2; y += (y1 < y2 ? 1 : -1)) {
                drawPoint x, y
                if(x1 != x2 && y1 != y2) {
                    if (x1 < x2 && (x + 1) <= x2) x++
                    else if ((x - 1) >= x2) x--
                }
            }
        }
    }
}
