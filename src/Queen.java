/*
 * @author Roberto Rodriguez
 */
public class Queen {

    private int x,y;

    // constructor to create queen
    public Queen(int i, int j) {
        x = i;
        y = j;
    }

    // assigns a new position of a queen
    public void setPosition(int i, int j) {
        x = i;
        y = j;
    }

    // returns the x position of the queen
    public int getPositionX() {
        return x;
    }

    // returns the y position of the queen
    public int getPositionY() {
        return y;
    }

    // calculates the right diagonal of the queen
    public int positionValueR() {
        return x + y;
    }

    // calculates the left diagonal of the queen
    public int positionValueL() {
        return x - y;
    }


}
