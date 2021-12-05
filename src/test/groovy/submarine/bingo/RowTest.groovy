package submarine.bingo

import spock.lang.Specification

class RowTest extends Specification {
    def "FromDelimitedStrings"() {
        given:
        def lines = ['78 27 82 68 20', '14  2 34 51  7', '58 57 99 37 81', ' 9  4  0 76 45', '67 69 70 17 23']

        when:
        def rows = Row.fromDelimitedStrings(lines)

        then:
        rows[0].squares[0].number == 78
        rows[0].squares[1].number == 27
        rows[0].squares[2].number == 82
        rows[0].squares[3].number == 68
        rows[0].squares[4].number == 20

        rows[1].squares[0].number == 14
        rows[1].squares[1].number == 2
        rows[1].squares[2].number == 34
        rows[1].squares[3].number == 51
        rows[1].squares[4].number == 7

        rows[2].squares[0].number == 58
        rows[2].squares[1].number == 57
        rows[2].squares[2].number == 99
        rows[2].squares[3].number == 37
        rows[2].squares[4].number == 81

        rows[3].squares[0].number == 9
        rows[3].squares[1].number == 4
        rows[3].squares[2].number == 0
        rows[3].squares[3].number == 76
        rows[3].squares[4].number == 45

        rows[4].squares[0].number == 67
        rows[4].squares[1].number == 69
        rows[4].squares[2].number == 70
        rows[4].squares[3].number == 17
        rows[4].squares[4].number == 23
    }
}
