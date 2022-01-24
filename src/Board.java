import java.util.*;
/*
 * @author Roberto Rodriguez
 */
public class Board {
    private Queen q;
    private Queen[] arrQ = new Queen[8];
    private int board[][] = new int[8][8];
    private int hValue;

    // no-args constructor
    public Board() {
        for (int y = 0; y < 8; y++) {
            Random random = new Random();
            int temp = random.nextInt(8);
            for (int x = 0; x < 8; x++) {
                if (temp == x) {
                    board[x][y] = 1;
                    q = new Queen(x,y);
                    arrQ[y] = q;
                }
                else
                    board[x][y] = 0;
            }
        }
        createHValue();
    }

    // creates a new board from scratch
    public void randomRestart() {
        for (int y = 0; y < 8; y++) {
            Random random = new Random();
            int temp = random.nextInt(8);
            for (int x = 0; x < 8; x++) {
                if (temp == x) {
                    board[x][y] = 1;
                    q = new Queen(x,y);
                    arrQ[y] = q;
                }
                else
                    board[x][y] = 0;
            }
        }
        createHValue();
    }

    // Calculates a heuristic value which is the number of conflicts that occur on the board
    public void createHValue() {
        hValue = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i+1; j < 8; j++) {
                if (arrQ[i].getPositionX() == arrQ[j].getPositionX())
                    hValue++;
                else if (arrQ[i].positionValueL() == arrQ[j].positionValueL())
                    hValue++;
                else if (arrQ[i].positionValueR() == arrQ[j].positionValueR())
                    hValue++;
            }
        }
    }

    // return heuristic value
    public int getHValue() {
        return hValue;
    }

    // finds the number of lower heuristic values compared to the original heuristic value and moves a
    // queen to the first overall lowest heuristic value if there is one
    public int getLowerHValues() {
        int count = 0;
        int currHValue = hValue;
        int min = currHValue;
        int holdX = 0;
        int holdY = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.nextMove(i, j);
                if (currHValue > hValue) {
                    count++;
                    if (min > hValue) {
                        min = hValue;
                        holdX = i;
                        holdY = j;
                    }
                }
            }
        }
        if (count > 0)
            moveQueen(holdX, holdY);
        return count;
    }

    // temporarily moves a queen to another spot to calculate a new heuristic value
    public void nextMove(int x, int y) {
        int tempX = arrQ[y].getPositionX();
        arrQ[y].setPosition(x,y);
        createHValue();
        arrQ[y].setPosition(tempX, y);
    }

    // permanently moves a queen to another spot and changes the board and heuristic value
    public void moveQueen(int x, int y) {
        int temp = arrQ[y].getPositionX();
        board[temp][y] = 0;
        board[x][y] = 1;
        arrQ[y].setPosition(x, y);
        createHValue();
    }

    // creates a display of the board and locations of the queens with 0's and 1's
    // 1's being the queens and 0's being empty
    public String toString() {
        String display = "";

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (y == 7)
                    display = display.concat(board[x][y]+ "");
                else
                    display = display.concat(board[x][y] + ",");
            }
            display = display.concat("\n");
        }
        return display;
    }
}

