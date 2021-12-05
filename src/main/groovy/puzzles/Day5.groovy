package puzzles


import submarine.subsystems.HydrothermalSensor
import submarine.subsystems.Point

import java.util.regex.Pattern

import static helpers.FileHelper.getData
import static java.lang.Integer.parseInt

class Day5 implements Puzzle {
    @Override
    int getDay() {
        5
    }

    @Override
    Map<String, Object> solve() {
        [partOne: solvePartOne()]
    }

    Integer solvePartOne() {
        def lines = getData(day)
        def p = Pattern.compile("^(\\d+),(\\d+) -> (\\d+),(\\d+)\$")
        def vectors = lines.collect { line ->
            def m = p.matcher(line)
            m.find()
            new submarine.Vector(
                    new Point(parseInt(m.group(1)), parseInt(m.group(2))),
                    new Point(parseInt(m.group(3)), parseInt(m.group(4)))
            )
        }

        new HydrothermalSensor(1000, 1000, vectors).overlappingPoints.size()
    }
}
