package puzzles

import submarine.Submarine
import submarine.subsystems.AdvancedNavigationSystem
import submarine.subsystems.NavigationSystem

import static helpers.FileHelper.getData

class Day2 implements Puzzle {

    @Override
    int getDay() {
        2
    }

    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    int solvePartOne() {
        def submarine = new Submarine(navigationSystem: new NavigationSystem())
        def instructions = getData(day)
        submarine.executeCourse(instructions)

        submarine.navigationSystem.x * submarine.navigationSystem.depth
    }

    int solvePartTwo() {
        def submarine = new Submarine(navigationSystem: new AdvancedNavigationSystem())
        def instructions = getData(day)
        submarine.executeCourse(instructions)

        submarine.navigationSystem.x * submarine.navigationSystem.depth
    }
}
