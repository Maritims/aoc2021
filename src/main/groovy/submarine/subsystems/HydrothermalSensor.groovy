package submarine.subsystems

import geometry.Line2D
import geometry.Point2D

class HydrothermalSensor {
    Integer[][] coordinateSystem

    final List<Line2D> vectors
    final Integer maxX
    final Integer maxY

    HydrothermalSensor(Integer maxX, Integer maxY, List<Line2D> vectors) {
        this.maxX = maxX
        this.maxY = maxY
        this.coordinateSystem = (0..maxX).collect { row -> (0..maxY).collect { col -> 0 } }
        this.vectors = vectors

        drawVectors()
    }

    protected void drawPoint(Integer x, Integer y) {
        def point = coordinateSystem[y][x]
        coordinateSystem[y][x] = point + 1
    }

    protected void drawVector(Line2D vector) {
        if(vector.p1.x == vector.p2.x) {
            def ys = [vector.p1.y, vector.p2.y]
            (ys.min()..ys.max()).each { y -> drawPoint(vector.p1.x, y) }
        }

        if(vector.p1.y == vector.p2.y) {
            def xs = [vector.p1.x, vector.p2.x]
            (xs.min()..xs.max()).each { x -> drawPoint(x, vector.p1.y) }
        }
    }

    protected void drawVectors() {
        vectors.each { vector -> drawVector(vector) }
    }

    String getVisualization() {
        coordinateSystem.collect { row ->
            row.collect { col-> col == 0 ? '.' : col }.join('')
        }.join('\r\n')
    }

    Point2D[] getOverlappingPoints() {
        def overlappingPoints = new ArrayList<Point2D>()
        coordinateSystem.eachWithIndex { Integer[] col, int y ->
            col.eachWithIndex { int row, int x ->
                if(row > 1) overlappingPoints.add(new Point2D(x, y))
            }
        }
        overlappingPoints
    }
}
