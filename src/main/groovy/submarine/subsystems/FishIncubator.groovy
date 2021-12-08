package submarine.subsystems

class FishIncubator {
    protected List<Integer> fishes

    FishIncubator(List<Integer> fishes) {
        this.fishes = fishes
    }

    List<Integer> incubate(Integer days) {
        (1..days).each {
            def iterator = fishes.listIterator()

            def toBeAdded = []
            while (iterator.hasNext()) {
                def fish = iterator.next()
                iterator.set(fish + (fish == 0 ? 6 : -1))
                if (fish == 0) toBeAdded.add(8)
            }

            fishes.addAll(toBeAdded)
        }

        fishes
    }
}
