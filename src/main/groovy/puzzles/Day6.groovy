package puzzles

import submarine.subsystems.FishIncubator

import static helpers.FileHelper.getData

class Day6 implements Puzzle {
    @Override
    int getDay() {
        6
    }

    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne()]
    }

    Integer solvePartOne() {
        def data = getData(6)
        new FishIncubator(data[0].split(',').collect { Integer.parseInt(it) }).incubate(80).size()
    }
}
