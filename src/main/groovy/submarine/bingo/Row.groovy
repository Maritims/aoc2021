package submarine.bingo

import java.util.regex.Pattern

import static java.lang.Integer.parseInt

class Row {
    Square[] squares

    Row(List<Integer> numbers) {
        this.squares = numbers.collect { new Square(it) }
    }

    String toString() {
        squares.join(', ')
    }

    static List<Row> fromDelimitedStrings(List<String> lines) {
        def p = Pattern.compile("(\\d+)")
        lines.collect {line ->
            def m = p.matcher(line)
            def numbers = new ArrayList<Integer>()
            while(m.find()) {
                numbers.add(parseInt(m.group()))
            }
            new Row(numbers)
        }
    }
}
