package puzzles

import submarine.AdvancedNavigationSystem
import submarine.NavigationSystem
import submarine.Submarine

class DayTwo implements Puzzle {

    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    int solvePartOne() {
        def submarine = new Submarine(new NavigationSystem(), null)
        def instructions = DayTwo.class.classLoader.getResourceAsStream('day2.txt').readLines()
        submarine.executeCourse(instructions)

        submarine.navigationSystem.x * submarine.navigationSystem.depth
    }

    int solvePartTwo() {
        def submarine = new Submarine(new AdvancedNavigationSystem(), null)
        def instructions = DayTwo.class.classLoader.getResourceAsStream('day2.txt').readLines()
        submarine.executeCourse(instructions)

        submarine.navigationSystem.x * submarine.navigationSystem.depth
    }
}
