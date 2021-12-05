package puzzles

import submarine.bingo.Bingo
import submarine.bingo.Board
import submarine.bingo.Row

class DayFour implements Puzzle {
    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne()]
    }

    Integer solvePartOne() {
        def bingoData = DayFour.class.classLoader.getResourceAsStream('day4.txt').readLines()
        def numbers = bingoData.pop()
                .split(',')
                .collect {Integer.parseInt(it) }
        def boards = new ArrayList<Board>()

        bingoData = bingoData.findAll { it }
        def iterator = bingoData.iterator()

        while(iterator.hasNext()) {
            def lines = (1..5).collect { iterator.next() }
            boards.add(new Board(Row.fromDelimitedStrings(lines)))
        }

        def bingo = new Bingo(boards, numbers)
        def winningScore = bingo.play()
        def winningBoard = bingo.boards.find { it.isWon() }
        winningScore
    }
}
