package submarine.subsystems

import spock.lang.Specification

class FishIncubatorTest extends Specification {
    def "Incubate"(Integer days, Map<Integer, Integer> expectedFishes) {
        when:
        def fishes = [0, 1, 1, 2, 1, 0, 0, 0, 0]
        def sut = new FishIncubator()
        def result = sut.incubate(days, fishes)

        then:
        result.eachWithIndex { int fish, int i ->
            println "${i}: ${fish}"
        }
        result == expectedFishes

        where:
        days | expectedFishes
         0 | [0, 1, 1, 2, 1, 0, 0, 0, 0]
         1 | [1, 1, 2, 1, 0, 0, 0, 0, 0]
         2 | [1, 2, 1, 0, 0, 0, 1, 0, 1]
         3 | [2, 1, 0, 0, 0, 1, 1, 1, 1]
         4 | [1, 0, 0, 0, 1, 1, 3, 1, 2]
         5 | [0, 0, 0, 1, 1, 3, 2, 2, 1]
         6 | [0, 0, 1, 1, 3, 2, 2, 1, 0]
         7 | [0, 1, 1, 3, 2, 2, 1, 0, 0]
         8 | [1, 1, 3, 2, 2, 1, 0, 0, 0]
         9 | [1, 3, 2, 2, 1, 0, 1, 0, 1]
        10 | [3, 2, 2, 1, 0, 1, 1, 1, 1]
        11 | [2, 2, 1, 0, 1, 1, 4, 1, 3]
        12 | [2, 1, 0, 1, 1, 4, 3, 3, 2]
        13 | [1, 0, 1, 1, 4, 3, 5, 2, 2]
        14 | [0, 1, 1, 4, 3, 5, 3, 2, 1]
        15 | [1, 1, 4, 3, 5, 3, 2, 1, 0]
        16 | [1, 4, 3, 5, 3, 2, 2, 0, 1]
        17 | [4, 3, 5, 3, 2, 2, 1, 1, 1]
        18 | [3, 5, 3, 2, 2, 1, 5, 1, 4]
    }
}