package submarine.subsystems

import spock.lang.Specification

class HydrothermalSensorTest extends Specification {
    static def vectors = [
            new submarine.Vector(0,9, 5,9),
            new submarine.Vector(8,0, 0,8),
            new submarine.Vector(9,4 ,3,4),
            new submarine.Vector(2,2, 2,1),
            new submarine.Vector(7,0, 7,4),
            new submarine.Vector(6,4, 2,0),
            new submarine.Vector(0,9, 2,9),
            new submarine.Vector(3,4, 1,4),
            new submarine.Vector(0,0, 8,8),
            new submarine.Vector(5,5, 8,2)]

    def "Visualize"() {
        given:
        def sut = new HydrothermalSensor(9, 9, new ArrayList<>(vectors))

        when:
        def lines = sut.visualization.split('\r\n')

        then:
        lines[0] == '.......1..'
        lines[1] == '..1....1..'
        lines[2] == '..1....1..'
        lines[3] == '.......1..'
        lines[4] == '.112111211'
        lines[5] == '..........'
        lines[6] == '..........'
        lines[7] == '..........'
        lines[8] == '..........'
        lines[9] == '222111....'
    }

    def "GetOverlappingPoints"() {
        given:
        def sut = new HydrothermalSensor(9, 9, new ArrayList<>(vectors))

        when:
        def overlappingPoints = sut.overlappingPoints

        then:
        overlappingPoints.size() == 5
        overlappingPoints.find { it.x == 3 && it.y == 4 }
        overlappingPoints.find { it.x == 7 && it.y == 4 }
        overlappingPoints.find { it.x == 0 && it.y == 9 }
        overlappingPoints.find { it.x == 1 && it.y == 9 }
        overlappingPoints.find { it.x == 2 && it.y == 9 }
    }
}
