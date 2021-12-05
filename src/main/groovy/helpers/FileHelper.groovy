package helpers

class FileHelper {
    static List<String> getData(int day) {
        FileHelper.class
                .classLoader
                .getResourceAsStream("day${day}.txt")
                .readLines()
    }
}
