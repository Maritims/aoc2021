package puzzles

import submarine.Submarine
import submarine.subsystems.Battery
import submarine.subsystems.LifeSupport

import static helpers.FileHelper.getData

class Day3 implements Puzzle {
    @Override
    int getDay() {
        3
    }

    @Override
    Map<String, Object> solve() {
        [partOne:solvePartOne(), partTwo:solvePartTwo()]
    }

    Integer solvePartOne() {
        def diagnostics = getData(day)
        def submarine = new Submarine(battery: new Battery(12))
        submarine.battery.getPowerConsumption(diagnostics)
    }

    Integer solvePartTwo() {
        def diagnostics = getData(day)
        def submarine = new Submarine(lifeSupport: new LifeSupport(12))
        submarine.lifeSupport.getLifeSupportRating(diagnostics)
    }
}
