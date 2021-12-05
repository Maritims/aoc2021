package submarine.bingo

import spock.lang.Specification

class BingoTest extends Specification {
    static def numbers = [7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1]
    def boards = [
            new Board([[22, 13, 17, 11, 0],
                       [8, 2, 23, 4, 24],
                       [21, 9, 14, 16, 7],
                       [6, 10, 3, 18, 5],
                       [1, 12, 20, 15, 19]]),
            new Board([[3, 15, 0, 2, 22],
                       [9, 18, 13, 17, 5],
                       [19, 8, 7, 25, 23],
                       [20, 11, 10, 24, 4],
                       [14, 21, 16, 12, 6]]),
            new Board([[14, 21, 17, 24, 4],
                       [10, 16, 15, 9, 19],
                       [18, 8, 23, 26, 20],
                       [22, 11, 13, 6, 5],
                       [2, 0, 12, 3, 7]])
            ]

    def "Play the game"() {
        given:
        def sut = new Bingo(new ArrayList<>(boards), numbers)

        when:
        while(!sut.isWon()) {
            sut.drawNumber()
        }

        then:
        sut.isWon()
        sut.summarizeUnmarkedNumbers() == 188
        sut.getWinningScore() == 4512
    }

    def "Win by column"() {
        given:
        def board = new Board([[1, 2, 3, 4, 5],
                               [11, 22, 33, 44, 55],
                               [111, 222, 333, 444, 555],
                               [1111, 2222, 3333, 4444, 5555],
                               [11111, 22222, 33333, 44444, 5555]])
        def numbers = [1, 11, 111, 1111, 11111]
        def sut = new Bingo(Arrays.asList(board), numbers)

        when:
        while(!sut.isWon()) {
            sut.drawNumber()
        }

        then:
        sut.boards.find { it.isWonByColumn() }
    }
}
