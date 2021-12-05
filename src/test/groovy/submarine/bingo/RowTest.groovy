package submarine.bingo

import spock.lang.Specification

class RowTest extends Specification {
    def "FromDelimitedStrings"() {
        given:
        def lines = ['78 27 82 68 20', '14  2 34 51  7', '58 57 99 37 81', ' 9  4  0 76 45', '67 69 70 17 23']

        when:
        def rows = Row.fromDelimitedStrings(lines)

        then:
        rows[0][0] == 78
        rows[0][1] == 27
        rows[0][2] == 82
        rows[0][3] == 68
        rows[0][4] == 20

        rows[1][0] == 14
        rows[1][1] == 2
        rows[1][2] == 34
        rows[1][3] == 51
        rows[1][4] == 7

        rows[2][0] == 58
        rows[2][1] == 57
        rows[2][2] == 99
        rows[2][3] == 37
        rows[2][4] == 81

        rows[3][0] == 9
        rows[3][1] == 4
        rows[3][2] == 0
        rows[3][3] == 76
        rows[3][4] == 45

        rows[4][0] == 67
        rows[4][1] == 69
        rows[4][2] == 70
        rows[4][3] == 17
        rows[4][4] == 23
    }
}
