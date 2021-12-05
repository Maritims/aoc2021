package submarine.subsystems

import spock.lang.Specification
import submarine.subsystems.LifeSupport

class LifeSupportTest extends Specification {
    def "GetOxygenRate"() {
        given:
        def sut = new LifeSupport(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def oxygenRate = sut.getOxygenRate(binaryNumbers)

        then:
        oxygenRate == 23
    }

    def "GetCO2Rate"() {
        given:
        def sut = new LifeSupport(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def co2Rate = sut.getCO2Rate(binaryNumbers)

        then:
        co2Rate == 10
    }

    def "GetLifeSupportRating"() {
        given:
        def sut = new LifeSupport(5)
        def binaryNumbers = ['00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010', '01010']

        when:
        def lifeSupportRate = sut.getLifeSupportRating(binaryNumbers)

        then:
        lifeSupportRate == 230
    }
}
