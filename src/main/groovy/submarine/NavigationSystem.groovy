package submarine

class NavigationSystem {
    def x = 0
    def depth = 0

    NavigationSystem forward(int factor) {
        x += factor
        this
    }

    NavigationSystem up(int factor) {
        depth -= factor
        this
    }

    NavigationSystem down(int factor) {
        depth += factor
        this
    }
}
