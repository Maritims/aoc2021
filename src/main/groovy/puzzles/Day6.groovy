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
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    private static List<Long> getLongs() {
        def list = [0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L]
        def map = getData(6)[0].split(',')
                .collect { Long.parseLong(it) }
                .countBy { it }
        map.keySet().each {
            list[it] += map[it]
        }
        list
    }

    def solvePartOne() { new FishIncubator().incubate(80, longs).sum() }

    def solvePartTwo() { new FishIncubator().incubate(256, longs).sum() }
}
