package bingo

class Square {
    Integer number
    Date checkedAt
    boolean isChecked() {
        checkedAt
    }

    Square(Integer number) {
        this.number = number
    }

    String toString() {
        "${number}: ${isChecked()}"
    }
}
