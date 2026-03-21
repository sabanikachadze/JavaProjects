package GridNeighboorScanner;

public class Grid {
    private final char[][] grid = {
            {'x', '.', 'x'},
            {'.', 'x', '.'},
            {'x', '.', '.'}
    };

    public Grid() {
    }

    public char[][] getGrid() {
        return grid;
    }
}
