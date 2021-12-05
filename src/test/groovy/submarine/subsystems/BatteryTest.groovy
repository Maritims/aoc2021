package submarine.subsystems

import spock.lang.Specification
import submarine.subsystems.Battery

class BatteryTest extends Specification {
    def "GetGammaRate"() {
        given:
        def sut = new Battery(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def gammaRate = sut.getGammaRate(binaryNumbers)

        then:
        gammaRate == 22
    }

    def "GetEpsilonRate"() {
        given:
        def sut = new Battery(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def epsilonRate = sut.getEpsilonRate(binaryNumbers)

        then:
        epsilonRate == 9
    }

    def "GetPowerConsumption"() {
        given:
        def sut = new Battery(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def powerConsumption = sut.getPowerConsumption(binaryNumbers)

        then:
        powerConsumption == 198
    }
}
