package bingo

class Board {
    List<Row> rows
    long wonAt
    Integer winningNumber
    Integer winningScore

    Board(List<List<Integer>> rows) {
        this.rows = rows.collect {new Row(it) }
    }

    void checkNumber(Integer number) {
        if(isWon()) return

        rows.each {row ->
            row.squares.each {square -> if(square.number == number) square.checkedAt = new Date() }
        }

        if(isWon()) {
            winningNumber = number
            winningScore = summarizeUnmarkedNumbers() * winningNumber
            wonAt = System.nanoTime()
        }
    }

    boolean isWonByRow() {
        rows.any { row -> row.squares.count { it.isChecked() } == row.squares.size() }
    }

    boolean isWonByColumn() {
        boolean wonByColumn = true
        for(def col = 0; col < 5; col++) {
            wonByColumn = rows.count { row -> row.squares[col].isChecked() } == rows.size()
            if(wonByColumn) break
        }
        wonByColumn
    }

    boolean isWon() {
        isWonByRow() || isWonByColumn()
    }

    Integer summarizeUnmarkedNumbers() {
        def sum = 0
        rows.each { row ->
            row.squares.each {square -> if(!square.isChecked()) sum += square.number }
        }
        sum
    }
}
