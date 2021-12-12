package puzzles

import spock.lang.Specification
import submarine.subsystems.FuelCalculator

class FuelCalculatorTest extends Specification {
    def "GetFuelCost"(List<Integer> numbers, boolean stepUp, Integer expectedFuelCost) {
        when:
        def sut = new FuelCalculator()
        def map = sut.getFuelCost(numbers, stepUp)

        then:
        expectedFuelCost == map.fuel

        where:
        numbers                          | stepUp | expectedPosition | expectedFuelCost
        [0, 1, 1, 2, 2, 2, 4, 7, 14, 16] | false  | 2                | 37
        [0, 1, 1, 2, 2, 2, 4, 7, 14, 16] | true   | 5                | 168
    }
}