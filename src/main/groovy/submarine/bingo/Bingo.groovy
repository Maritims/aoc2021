package submarine.bingo

class Bingo {
    List<Board> boards

    Bingo(List<Board> boards) {
        this.boards = boards
    }

    void drawNumber() {
        boards.each { it.drawNumber() }
    }

    boolean isWon() {
        boards.any { it.isWon() }
    }

    Integer summarizeUnmarkedNumbers() {
        def sum = 0
        boards.find { it.isWon() }.rows
                .each { row ->
                    row.squares.findAll { square -> !square.checked }.each {square -> sum += square.number }
                }
        sum
    }

    Integer getWinningNumber() {
        boards.find { it.isWon() }.winningNumber
    }

    Integer getWinningScore() {
        summarizeUnmarkedNumbers() * getWinningNumber()
    }
}
