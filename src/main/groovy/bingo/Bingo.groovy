package bingo

class Bingo {
    List<Board> boards
    List<Integer> numbers

    Bingo(List<Board> boards, List<Integer> numbers) {
        this.boards = boards
        this.numbers = numbers
    }

    void drawNumber() {
        def number = numbers.pop()
        boards.each { board -> board.checkNumber(number) }
    }

    boolean isWon() {
        boards.any {it.isWon() }
    }

    Integer getWinningScore() {
        boards.find { it.isWon() }.winningScore
    }

    Board[] getWinningBoards() {
        boards.findAll { it.isWon() }
    }

    Integer play(boolean winAsap = true) {
        while(winAsap ? !isWon() : boards.count { !it.isWon() } > 0) {
            drawNumber()
        }
        winningScore
    }
}
