package MiniBattleship;

public class MiniBattleship {
    private char[][] board;
    private int[] battleShips = new int[]{3,2,2,1};
    private int battleShipCount = 0;
    private String direction;

    public boolean battleship(int battleShipSize, String startingPosition, String direction){
        boolean battleShipFound = false;
        for(int i = 0; i < 4; i++){
            if (battleShipSize == battleShips[i]) {
                battleShipFound = true;
                battleShips[i] = 0;
                break;
            }
        }

        return true;
    }

    public boolean shoot(String coord) {
        return true;
    }

    public void printBoard() {
        // display board
    }
}
