package submarine

import helpers.BitHelper

import static java.lang.Integer.parseInt

class LifeSupport {
    int diagnosticReadingLength

    LifeSupport(int diagnosticReadingLength) {
        this.diagnosticReadingLength = diagnosticReadingLength
    }

    Integer getRate(List<String> binaryNumbers, Closure bitHelperClosure) {
        def numbersOfInterest = new ArrayList<>(binaryNumbers)
        (0..(diagnosticReadingLength - 1)).each {position ->
            def bitOfInterest = bitHelperClosure.call(numbersOfInterest, position)
            numbersOfInterest = numbersOfInterest.findAll { binaryNumber -> parseInt(binaryNumber[position]) == bitOfInterest }
        }
        parseInt(numbersOfInterest.get(0), 2)
    }

    Integer getOxygenRate(List<String> binaryNumbers) {
        getRate(binaryNumbers, { List<String> numbersOfInterest, Integer position ->
            BitHelper.getMostCommonBit(numbersOfInterest, position)
        })
    }

    Integer getCO2Rate(List<String> binaryNumbers) {
        getRate(binaryNumbers, { List<String> numbersOfInterest, Integer position ->
            BitHelper.getLeastCommonBit(numbersOfInterest, position, false)
        })
    }

    Integer getLifeSupportRating(List<String> binaryNumbers) {
        getOxygenRate(binaryNumbers) * getCO2Rate(binaryNumbers)
    }
}
