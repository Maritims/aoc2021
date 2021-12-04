package submarine

import spock.lang.Specification
import submarine.AdvancedNavigationSystem

class AdvancedNavigationSystemTest extends Specification {
    def "Move around"() {
        given:
        def sut = new AdvancedNavigationSystem()

        when:
        sut.forward(5)
                .down(5)
                .forward(8)
                .up(3)
                .down(8)
                .forward(2)

        then:
        assert sut.x == 15
        assert sut.depth == 60
    }
}
