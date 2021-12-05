package submarine.subsystems

class HydrothermalSensor {
    List<submarine.Vector> vectors
    Integer maxX
    Integer maxY

    HydrothermalSensor(Integer maxX, Integer maxY, List<submarine.Vector> vectors) {
        this.maxX = maxX
        this.maxY = maxY
        this.vectors = vectors
    }

    Integer[][] getDiagram() {
        def diagram = (0..maxX).collect {row -> (0..maxY).collect { col -> 0 } }
        def drawPoint = { Integer x, Integer y ->
            def point = diagram[y][x]
            if(point == null) throw new UnsupportedOperationException("Attempted to draw at (${x}, ${y}) which is outside of the diagram")
            diagram[y][x] = point + 1
        }

        vectors.each { vector ->
            if(vector.p1.x == vector.p2.x) {
                def ys = [vector.p1.y, vector.p2.y]
                (ys.min()..ys.max()).each { y -> drawPoint(vector.p1.x, y) }
            }

            if(vector.p1.y == vector.p2.y) {
                def xs = [vector.p1.x, vector.p2.x]
                (xs.min()..xs.max()).each { x -> drawPoint(x, vector.p1.y) }
            }
        }
        diagram
    }

    String getVisualization() {
        diagram.collect { row ->
            row.collect { col-> col == 0 ? '.' : col }.join('')
        }.join('\r\n')
    }

    Point[] getOverlappingPoints() {
        def overlappingPoints = new ArrayList<Point>()
        getDiagram().eachWithIndex { Integer[] col, int y ->
            col.eachWithIndex { int row, int x ->
                if(row > 1) overlappingPoints.add(new Point(x, y))
            }
        }
        overlappingPoints
    }
}
