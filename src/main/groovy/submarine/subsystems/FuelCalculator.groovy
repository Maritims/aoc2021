package submarine.subsystems

import static java.lang.Math.abs

class FuelCalculator {
    def summarize(Integer n) {
        n * (n+1) / 2
    }

    def getFuelCost(List<Integer> numbers, boolean stepUp = false) {
        def map = numbers.collect { source ->
            [
                    position: source,
                    fuel    : numbers.sum { destination ->
                        def movements = abs(source - destination)
                        stepUp ? movements * (movements + 1) / 2 : movements
                    }
            ]
        }
        map.min { it.fuel }
    }
}
