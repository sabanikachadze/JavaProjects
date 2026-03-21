package GridNeighboorScanner;



public class Main {
    public static void main(String[] args){
        Grid grid = new Grid();
        ScanGrid scanGrid = new ScanGrid(grid.getGrid());

        scanGrid.scan();
    }
}
