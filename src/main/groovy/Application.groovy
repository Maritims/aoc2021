import puzzles.*

class Application {
    static void main(String[] args) {
        [new Day1(), new Day2(), new Day3(), new Day4(), new Day5(), new Day6()].each { puzzle ->
            puzzle.solve().each { solution -> println "${puzzle.class.getSimpleName()}: ${solution}" }
        }
    }
}
