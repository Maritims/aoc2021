package submarine.bingo

import spock.lang.Specification

class BoardTest extends Specification {
    static def numbers = [7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1]
    static def rows = [[22, 13, 17, 11, 0],
                       [8, 2, 23, 4, 24],
                       [21, 9, 14, 16, 7],
                       [6, 10, 3, 18, 5],
                       [1, 12, 20, 15, 19]]

    def "DrawNumber"() {
        given:
        def sut = new Board(numbers, rows)

        when:
        sut.drawNumber()

        then:
        sut.isChecked(4, 2)
    }

    def "IsWon"() {
        given:
        def sut = new Board(numbers, rows)

        when:
        (1..20).each {sut.drawNumber() }

        then:
        sut.isWon()
    }
}