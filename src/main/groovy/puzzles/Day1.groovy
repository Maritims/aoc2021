package puzzles


import submarine.Submarine
import submarine.subsystems.Sonar

import static helpers.FileHelper.getData

class Day1 implements Puzzle {
    /**
     * Returns a map with all solutions for day one.
     * @return map with all solutions for day one.
     */
    @Override
    int getDay() {
        1
    }

    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    /**
     * Returns the number of measurements which are larger than the previous measurement.
     * @return number of measurements larger than the previous measurement
     */
    int solvePartOne() {
        def readings = getData(day).collect { Integer.parseInt(it) }
        new Submarine(sonar: new Sonar(readings)).sonar.read()
    }

    /**
     * Returns the number of sums from three-measurement windows where the sum is larger than the previous sum.
     * @return number of sums larger than the previous sum.
     */
    int solvePartTwo() {
        def readings = getData(day).collect { Integer.parseInt(it) }
        def submarine = new Submarine(sonar: new Sonar(readings))
        submarine.sonar.read(submarine.sonar.readAsWindows())
    }
}
