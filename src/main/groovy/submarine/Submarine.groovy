package submarine

class Submarine {
    final Sonar sonar
    final NavigationSystem navigationSystem

    Submarine(NavigationSystem navigationSystem, Sonar sonar) {
        this.navigationSystem = navigationSystem
        this.sonar = sonar
    }

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
