package submarine

class Sonar {
    List<Integer> readings

    Sonar(List<Integer> readings) {
        this.readings = readings;
    }

    Integer read(def readings = this.readings) {
        def solution = 0
        readings.eachWithIndex { current, i -> if(i > 0 && current > readings.get(i - 1)) solution++ }
        solution
    }

    List<Integer> readAsWindows() {
        def windowReadings = []
        readings.eachWithIndex { def reading, def i ->
            if (i + 2 > readings.size() - 1) return
            windowReadings.add((0..2).sum { readings.get(i + it) })
        }
        windowReadings
    }
}
