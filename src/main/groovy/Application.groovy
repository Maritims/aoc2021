import puzzles.DayOne
import puzzles.DayTwo

class Application {
    static void main(String[] args) {
        [new DayOne(), new DayTwo()].each {puzzle ->
            puzzle.solve().each { solution -> println "${puzzle.class.getSimpleName()}: ${solution}" }
        }
    }
}
