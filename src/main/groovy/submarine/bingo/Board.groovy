package submarine.bingo

class Board {
    List<Integer> numbers
    List<Row> rows
    Integer winningNumber

    Board(List<Integer> numbers, List<List<Integer>> rows) {
        this.numbers = numbers
        this.rows = rows.collect {new Row(it) }
    }

    boolean drawNumber() {
        def number = numbers.pop()
        rows.each {row ->
            row.squares.findAll { square -> square.number == number }.each {square -> square.checked = true }
        }

        def isWon = isWon()
        if(isWon) winningNumber = number
        isWon
    }

    boolean isChecked(int x, int y) {
        rows[y].squares[x].checked
    }

    boolean isWon() {
        rows.any { row -> row.squares.count { it.checked } == row.squares.size() }
    }
}
