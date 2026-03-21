package GridNeighboorScanner;

public class ScanGrid {
    private final char[][] grid;

    public ScanGrid(char[][] grid) {
        this.grid = grid;
    }

    public void scan() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 'x') {
                    System.out.printf("(%d , %d) %s%n", row, col, countNeighbors(row, col));
                }
            }
        }
    }

    private String countNeighbors(int row, int col) {
        int gridRow = grid.length;
        int gridColumn = grid[row].length;
        int countNeighbors = 0;

        int[][] allDirections = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
        };

        for (int[] direction : allDirections) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < gridRow &&
                    newCol >= 0 && newCol < gridColumn &&
                    grid[newRow][newCol] == 'x') {
                countNeighbors++;
            }
        }
        return String.format("%d Neighbours found", countNeighbors);
    }

}
