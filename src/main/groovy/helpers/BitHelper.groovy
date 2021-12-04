package helpers

class BitHelper {
    static Map<Integer, Integer> groupBinaryNumbers(List<String> binaryNumbers, int position, boolean oneWinsTheDraw) {
        // Sort in reverse order to ensure that 1 beats 0 in a draw when doing countBy and max
        (oneWinsTheDraw ? binaryNumbers.sort().reverse() : binaryNumbers.sort())
                .collect { Integer.parseInt(it.toCharArray()[position] as String) }
                .countBy { it }
    }

    static Integer getMostCommonBit(List<String> binaryNumbers, int position, boolean oneWinsTheDraw = true) {
        groupBinaryNumbers(binaryNumbers, position, oneWinsTheDraw)
                .max { it.value }
                .key
    }

    static Integer getLeastCommonBit(List<String> binaryNumbers, int position, boolean oneWinsTheDraw = true) {
        groupBinaryNumbers(binaryNumbers, position, oneWinsTheDraw)
                .min { it.value }
                .key
    }
}
