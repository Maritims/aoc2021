package submarine.bingo

class Bingo {
    List<Board> boards
    List<Integer> numbers
    Integer winningNumber

    Bingo(List<Board> boards, List<Integer> numbers) {
        this.boards = boards
        this.numbers = numbers
    }

    void drawNumber() {
        def number = numbers.pop()
        boards.each { board ->
            board.rows.each {row ->
                row.squares.findAll { square -> square.number == number }.each {square -> square.checked = true }
            }
        }
        if(isWon()) winningNumber = number
    }

    boolean isWon() {
        boards.any {it.isWon() }
    }

    Integer summarizeUnmarkedNumbers() {
        def sum = 0
        boards.find { it.isWon() }.rows
                .each { row ->
                    row.squares.findAll { square -> !square.checked }.each {square -> sum += square.number }
                }
        sum
    }

    Integer getWinningScore() {
        def sum = summarizeUnmarkedNumbers()
        sum * winningNumber
    }

    Integer play() {
        while(!isWon()) {
            drawNumber()
        }
        winningScore
    }
}
