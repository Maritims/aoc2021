package submarine

class AdvancedNavigationSystem extends NavigationSystem {
    def aim = 0

    @Override
    NavigationSystem forward(int factor) {
        x += factor
        depth += aim * factor
        this
    }

    @Override
    NavigationSystem up(int factor) {
        aim -= factor
        this
    }

    @Override
    NavigationSystem down(int factor) {
        aim += factor
        this
    }
}
