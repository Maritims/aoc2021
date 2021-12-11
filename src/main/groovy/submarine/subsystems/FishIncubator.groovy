package submarine.subsystems

class FishIncubator {
    List<Long> incubate(Integer days, List<Long> fishes) {
        def tomorrow = new ArrayList<Long>([0, 0, 0, 0, 0, 0, 0, 0, 0])
        for(def day = 0; day < days; day++) {
            for (def i = 1; i < fishes.size(); i++) {
                fishes[i - 1] = fishes[i]
            }

            fishes[6] = tomorrow[6]
            fishes[8] = tomorrow[8]
            tomorrow[6] = fishes[0] + fishes[7]
            tomorrow[8] = fishes[0]
        }
        fishes
    }
}
