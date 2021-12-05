package submarine.bingo

class Board {
    List<Row> rows

    Board(List<List<Integer>> rows) {
        this.rows = rows.collect {new Row(it) }
    }

    boolean isChecked(int x, int y) {
        rows[y].squares[x].checked
    }

    boolean isWonByRow() {
        rows.any { row -> row.squares.count { it.checked } == row.squares.size() }
    }

    boolean isWonByColumn() {
        boolean wonByColumn = true
        for(def col = 0; col < 5; col++) {
            wonByColumn = rows.count { row -> row.squares[col].checked } == 5
            if(wonByColumn) break
        }
        wonByColumn
    }

    boolean isWon() {
        isWonByRow() || isWonByColumn()
    }
}
