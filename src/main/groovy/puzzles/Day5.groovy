package puzzles

import geometry.Line2D
import geometry.Point2D
import submarine.subsystems.AdvancedHydrothermalSensor
import submarine.subsystems.HydrothermalSensor

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
        [partOne: solvePartOne(), partTwo: solvePartTwo()]
    }

    List<Line2D> getLinesFromData() {
        def data = getData(day)
        def p = Pattern.compile("^(\\d+),(\\d+) -> (\\d+),(\\d+)\$")
        def lines = data.collect { line ->
            def m = p.matcher(line)
            m.find()
            new Line2D(
                    new Point2D(parseInt(m.group(1)), parseInt(m.group(2))),
                    new Point2D(parseInt(m.group(3)), parseInt(m.group(4)))
            )
        }
        lines
    }

    Integer solvePartOne() {
        new HydrothermalSensor(1000, 1000, linesFromData).overlappingPoints.size()
    }

    Integer solvePartTwo() {
        new AdvancedHydrothermalSensor(1000, 1000, linesFromData).overlappingPoints.size()
    }
}
