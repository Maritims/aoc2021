package puzzles

import submarine.subsystems.FuelCalculator

import static helpers.FileHelper.getData

class Day7 implements Puzzle {
    @Override
    int getDay() {
        7
    }

    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    Integer solvePartOne() {
        def fuelCalculator = new FuelCalculator()
        def numbers = getData(day)[0].split(',').collect {Integer.parseInt(it) }
        fuelCalculator.getFuelCost(numbers).fuel
    }

    Integer solvePartTwo() {
        def fuelCalculator = new FuelCalculator()
        def numbers = getData(day)[0].split(',').collect {Integer.parseInt(it) }
        fuelCalculator.getFuelCost(numbers, true).fuel
    }
}
