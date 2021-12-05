import puzzles.DayFour
import puzzles.DayOne
import puzzles.DayThree
import puzzles.DayTwo

class Application {
    static void main(String[] args) {
        [new DayOne(), new DayTwo(), new DayThree(), new DayFour()].each { puzzle ->
            puzzle.solve().each { solution -> println "${puzzle.class.getSimpleName()}: ${solution}" }
        }
    }
}
