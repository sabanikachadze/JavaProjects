package CoordinateParser;

public class CoordinationParser {

    public int[] parse(String input) {
        if (input == null || input.length() != 2) return null;

        char c1 = input.charAt(0); // column
        char c2 = input.charAt(1); // row

        if (!Character.isLetter(c1) || !Character.isDigit(c2)) {
            return null;
        }

        int col = Character.toUpperCase(c1) - 'A';
        int row = c2 - '0';

        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return new int[]{row, col};
        }

        return null;
    }
}
