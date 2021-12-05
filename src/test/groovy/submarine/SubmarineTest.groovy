package submarine

import spock.lang.Specification
import submarine.subsystems.NavigationSystem

class SubmarineTest extends Specification {
    def "ExecuteCourse"() {
        given:
        def sut = new Submarine(navigationSystem: new NavigationSystem())
        def instructions = [
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        ]

        when:
        sut.executeCourse(instructions)

        then:
        assert 15 == sut.navigationSystem.x
        assert 10 == sut.navigationSystem.depth
    }
}
