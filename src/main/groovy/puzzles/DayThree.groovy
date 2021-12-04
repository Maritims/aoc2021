package puzzles

import submarine.Battery
import submarine.LifeSupport
import submarine.Submarine

class DayThree implements Puzzle {
    @Override
    Map<String, Object> solve() {
        [partOne:solvePartOne(), partTwo:solvePartTwo()]
    }

    Integer solvePartOne() {
        def diagnostics = DayOne.class.classLoader.getResourceAsStream('day3.txt').readLines()
        def submarine = new Submarine(battery: new Battery(12))
        submarine.battery.getPowerConsumption(diagnostics)
    }

    Integer solvePartTwo() {
        def diagnostics = DayOne.class.classLoader.getResourceAsStream('day3.txt').readLines()
        def submarine = new Submarine(lifeSupport: new LifeSupport(12))
        submarine.lifeSupport.getLifeSupportRating(diagnostics)
    }
}
