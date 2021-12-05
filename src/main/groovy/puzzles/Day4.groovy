package puzzles

import bingo.Bingo
import bingo.Board
import bingo.Row

import static helpers.FileHelper.getData

class Day4 implements Puzzle {
    @Override
    int getDay() {
        4
    }

    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    static Bingo setUpGame(List<String> bingoData) {
        def numbers = bingoData.pop()
                .split(',')
                .collect { Integer.parseInt(it) }
        def boards = new ArrayList<Board>()

        bingoData = bingoData.findAll { it }
        def iterator = bingoData.iterator()

        while (iterator.hasNext()) {
            def lines = (1..5).collect { iterator.next() }
            boards.add(new Board(Row.fromDelimitedStrings(lines)))
        }

        new Bingo(boards, numbers)
    }

    Integer solvePartOne() {
        Bingo bingo = setUpGame(getData(day))
        def winningScore = bingo.play()
        winningScore
    }

    Integer solvePartTwo() {
        Bingo bingo = setUpGame(getData(day))
        bingo.play(false)
        bingo.boards.sort { a, b -> a.wonAt <=> b.wonAt }.last().winningScore
    }
}
