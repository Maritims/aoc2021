package puzzles


import submarine.Sonar
import submarine.Submarine

class DayOne implements Puzzle {
    /**
     * Returns a map with all solutions for day one.
     * @return map with all solutions for day one.
     */
    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    /**
     * Returns the number of measurements which are larger than the previous measurement.
     * @return number of measurements larger than the previous measurement
     */
    int solvePartOne() {
        def readings = DayOne.class.classLoader.getResourceAsStream('day1.txt').readLines().collect { Integer.parseInt(it) }
        new Submarine(null, new Sonar(readings)).sonar.read()
    }

    /**
     * Returns the number of sums from three-measurement windows where the sum is larger than the previous sum.
     * @return number of sums larger than the previous sum.
     */
    int solvePartTwo() {
        def readings = DayOne.class.classLoader.getResourceAsStream('day1.txt').readLines().collect { Integer.parseInt(it) }
        def submarine = new Submarine(null, new Sonar(readings))
        submarine.sonar.read(submarine.sonar.readAsWindows())
    }
}
