package submarine.bingo

class Square {
    Integer number
    boolean checked

    Square(Integer number) {
        this.number = number
    }

    String toString() {
        "${number}: ${checked}"
    }
}
