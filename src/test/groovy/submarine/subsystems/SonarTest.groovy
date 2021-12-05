package submarine.subsystems

import spock.lang.Specification
import submarine.subsystems.Sonar

class SonarTest extends Specification {
    def "read"() {
        given:
        def sut = new Sonar([607, 618, 618, 617, 647, 716, 769, 792])

        when:
        def solution = sut.read()

        then:
        assert solution == 5
    }
}
