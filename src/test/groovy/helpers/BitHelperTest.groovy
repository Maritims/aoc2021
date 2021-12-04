package helpers

import spock.lang.Specification

class BitHelperTest extends Specification {
    def "GetMostCommonBit"(int position, int expectedMostCommonBit) {
        given:
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def mostCommonBit = BitHelper.getMostCommonBit(binaryNumbers, position)

        then:
        mostCommonBit == expectedMostCommonBit

        where:
        position | expectedMostCommonBit
        0 | 1
        1 | 0
        2 | 1
        3 | 1
        4 | 0
    }

    def "1 wins when the there's a draw"() {
        when:
        def binaryNumbers = ['10110', '10111', '10110', '10111']

        then:
        BitHelper.getMostCommonBit(binaryNumbers, 4) == 1
    }
}
