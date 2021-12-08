package submarine.subsystems

import spock.lang.Specification

class FishIncubatorTest extends Specification {
    def "Incubate"(int days, List<Integer> expectedFishes) {
        when:
        def initialFishes = new LinkedList<Integer>([3, 4, 3, 1, 2])
        def sut = new FishIncubator(initialFishes)

        then:
        def fishes = sut.incubate(days)
        fishes == expectedFishes

        where:
        days | expectedFishes
        1  | [2, 3, 2, 0, 1]
        2  | [1, 2, 1, 6, 0, 8]
        3  | [0, 1, 0, 5, 6, 7, 8]
        4  | [6, 0, 6, 4, 5, 6, 7, 8, 8]
        5  | [5, 6, 5, 3, 4, 5, 6, 7, 7, 8]
        6  | [4, 5, 4, 2, 3, 4, 5, 6, 6, 7]
        7  | [3, 4, 3, 1, 2, 3, 4, 5, 5, 6]
        8  | [2, 3, 2, 0, 1, 2, 3, 4, 4, 5]
        9  | [1, 2, 1, 6, 0, 1, 2, 3, 3, 4, 8]
        10 | [0, 1, 0, 5, 6, 0, 1, 2, 2, 3, 7, 8]
        11 | [6, 0, 6, 4, 5, 6, 0, 1, 1, 2, 6, 7, 8, 8, 8]
        12 | [5, 6, 5, 3, 4, 5, 6, 0, 0, 1, 5, 6, 7, 7, 7, 8, 8]
        13 | [4, 5, 4, 2, 3, 4, 5, 6, 6, 0, 4, 5, 6, 6, 6, 7, 7, 8, 8]
        14 | [3, 4, 3, 1, 2, 3, 4, 5, 5, 6, 3, 4, 5, 5, 5, 6, 6, 7, 7, 8]
        15 | [2, 3, 2, 0, 1, 2, 3, 4, 4, 5, 2, 3, 4, 4, 4, 5, 5, 6, 6, 7]
        16 | [1, 2, 1, 6, 0, 1, 2, 3, 3, 4, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 8]
        17 | [0, 1, 0, 5, 6, 0, 1, 2, 2, 3, 0, 1, 2, 2, 2, 3, 3, 4, 4, 5, 7, 8]
        18 | [6, 0, 6, 4, 5, 6, 0, 1, 1, 2, 6, 0, 1, 1, 1, 2, 2, 3, 3, 4, 6, 7, 8, 8, 8, 8]
    }

    def "Check fishes after X days"(Integer days, Integer size) {
        when:
        def initialFishes = new LinkedList<Integer>([3, 4, 3, 1, 2])
        def sut = new FishIncubator(initialFishes)

        then:
        def fishes = sut.incubate(days)
        fishes.size() == size

        where:
        days | size
        80 | 5934
    }
}