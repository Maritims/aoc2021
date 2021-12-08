package submarine

import submarine.subsystems.*

class Submarine {
    Sonar sonar
    NavigationSystem navigationSystem
    Battery battery
    LifeSupport lifeSupport
    HydrothermalSensor hydrothermalSensor
    FishIncubator fishIncubator

    Submarine executeCourse(List<String> instructions) {
        instructions.each {
            def parts = it.split(' ')
            def direction = parts[0]
            def factor = Integer.parseInt(parts[1])
            switch(direction) {
                case 'forward': navigationSystem.forward factor; break
                case 'up': navigationSystem.up factor; break
                case 'down': navigationSystem.down factor; break
            }
        }
        this
    }
}
