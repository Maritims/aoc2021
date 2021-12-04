import spock.lang.Specification
import submarine.NavigationSystem
import submarine.Submarine

class SubmarineTest extends Specification {
    def "ExecuteCourse"() {
        given:
        def sut = new Submarine(new NavigationSystem(), null)
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
