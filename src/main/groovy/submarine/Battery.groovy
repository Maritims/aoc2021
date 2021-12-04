package submarine

import helpers.BitHelper

class Battery {
    int diagnosticReadingLength

    Battery(int diagnosticReadingLength) {
        this.diagnosticReadingLength = diagnosticReadingLength
    }

    Integer getGammaRate(List<String> binaryNumbers) {
        Integer.parseInt((0..(diagnosticReadingLength - 1)).collect { BitHelper.getMostCommonBit(binaryNumbers, it) }.join(''), 2)
    }

    Integer getEpsilonRate(List<String> binaryNumbers) {
        Integer.parseInt((0..(diagnosticReadingLength - 1)).collect { BitHelper.getLeastCommonBit(binaryNumbers, it) }.join(''), 2)
    }

    Integer getPowerConsumption(List<String> binaryNumbers) {
        getGammaRate(binaryNumbers) * getEpsilonRate(binaryNumbers)
    }
}
