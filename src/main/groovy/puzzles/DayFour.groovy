package puzzles

import submarine.bingo.Bingo
import submarine.bingo.Board
import submarine.bingo.Row

class DayFour implements Puzzle {
    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne()]
    }

    Bingo solvePartOne() {
        def bingoData = DayFour.class.classLoader.getResourceAsStream('day4.txt').readLines()
        def numbers = bingoData.pop()
                .split(',')
                .collect {Integer.parseInt(it) }
        def boards = new ArrayList<Board>()
        def iterator = bingoData.iterator()
        while(iterator.hasNext()) {
            boards.add(new Board(numbers, Row.fromDelimitedStrings((1..5).collect {iterator.next() })))
            iterator.next()
        }

        def bingo = new Bingo(boards)
    }
}
