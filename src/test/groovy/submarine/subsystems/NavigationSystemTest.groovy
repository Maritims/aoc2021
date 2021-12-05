package submarine.subsystems

import spock.lang.Specification
import submarine.subsystems.NavigationSystem

class NavigationSystemTest extends Specification {
    def "Move around"() {
        given:
        def sut = new NavigationSystem()

        when:
        sut.forward(5)
                .down(5)
                .forward(8)
                .up(3)
                .down(8)
                .forward(2)

        then:
        assert sut.x == 15
        assert sut.depth == 10
    }
}
