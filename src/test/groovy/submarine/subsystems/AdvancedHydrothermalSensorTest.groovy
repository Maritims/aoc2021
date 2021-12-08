package submarine.subsystems

import geometry.Line2D
import spock.lang.Specification
import spock.lang.Unroll

class AdvancedHydrothermalSensorTest extends Specification {
    static def vectors = [
            new Line2D(0,9, 5,9),
            new Line2D(8,0, 0,8),
            new Line2D(9,4 ,3,4),
            new Line2D(2,2, 2,1),
            new Line2D(7,0, 7,4),
            new Line2D(6,4, 2,0),
            new Line2D(0,9, 2,9),
            new Line2D(3,4, 1,4),
            new Line2D(0,0, 8,8),
            new Line2D(5,5, 8,2)]

    @Unroll("#name")
    def "Loop test"(String name, int x1, int y1, int x2, int y2, List<String> expectedPoints) {
        when:
        def points = []

        for(def x = x1; x1 < x2 ? x <= x2 : x >= x2; x += (x1 < x2 ? 1 : -1)) {
            for(def y = y1; y1 < y2 ? y <= y2 : y >= y2; y += (y1 < y2 ? 1 : -1)) {
                points.add "${x},${y}"
                if(x1 != x2 && y1 != y2) {
                    if (x1 < x2 && (x + 1) <= x2) x++
                    else if ((x - 1) >= x2) x--
                }
            }
        }

        then:
        points == expectedPoints

        where:
        name | x1 | y1 | x2 | y2 | expectedPoints
        '0,9 -> 5,9' | 0 | 9 | 5 | 9 | ['0,9', '1,9', '2,9', '3,9', '4,9', '5,9']
        '8,0 -> 0,8' | 8 | 0 | 0 | 8 | ['8,0', '7,1', '6,2', '5,3', '4,4', '3,5', '2,6', '1,7', '0,8']
        '9,4 -> 3,4' | 9 | 4 | 3 | 4 | ['9,4', '8,4', '7,4', '6,4', '5,4', '4,4', '3,4']
        '2,2 -> 2,1' | 2 | 2 | 2 | 1 | ['2,2', '2,1']
        '7,0 -> 7,4' | 7 | 0 | 7 | 4 | ['7,0', '7,1', '7,2', '7,3', '7,4']
        '6,4 -> 2,0' | 6 | 4 | 2 | 0 | ['6,4', '5,3', '4,2', '3,1', '2,0']
        '0,9 -> 2,9' | 0 | 9 | 2 | 9 | ['0,9', '1,9', '2,9']
        '3,4 -> 1,4' | 3 | 4 | 1 | 4 | ['3,4', '2,4', '1,4']
        '0,0 -> 8,8' | 0 | 0 | 8 | 8 | ['0,0', '1,1', '2,2', '3,3', '4,4', '5,5', '6,6', '7,7', '8,8']
        '5,5 -> 8,2' | 5 | 5 | 8 | 2 | ['5,5', '6,4', '7,3', '8,2']
    }

    def "GetVisualization"() {
        when:
        def sut = new AdvancedHydrothermalSensor(9, 9, new ArrayList<>(vectors))

        then:
        println sut.visualization
    }

    def "GetVisualization with only one vector"(int x1, int y1, int x2, int y2) {
        when:
        def sut = new AdvancedHydrothermalSensor(9, 9, [new Line2D(x1, y1, x2, y2)])

        then:
        println sut.visualization

        where:
        x1 | y1 | x2 | y2
        //1 | 1 | 3 | 3
        //6 | 4 | 2 | 0
        //0 | 9 | 2 | 9
    }
}
