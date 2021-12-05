package puzzles

interface Puzzle {
    int getDay()
    Map<String, Object> solve()
}