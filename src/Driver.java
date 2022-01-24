/*
 * @author Roberto Rodriguez
 */

public class Driver {

    public static void main(String[] args) {
        // Creating a starting board
        Board b1 = new Board();

        //initializing variables
        int lowerNeighbors = 0;
        int numRestart = 0; // Number of restarts it took to find solution
        int numChanges = 0; // Number of times the board was changed before finding a solution

        //do-while to allow user to see board find a solution
        do {
            System.out.println("Current H: " + b1.getHValue()); // Print current Heuristic value
            System.out.println(b1.toString()); // Print board
            lowerNeighbors = b1.getLowerHValues(); // Finding how many neighbors have lower Heuristic values
            System.out.println("Neighbor's found with lower h: " + lowerNeighbors); // Print lower value
            if (lowerNeighbors == 0) { // if no more neighbors then restart
                numChanges++;
                System.out.println("RESTART");
                numRestart++;
                b1.randomRestart();
            }
            else { // Add 1 to numChanges and tell user the board is making a change
                System.out.println("Setting new current State");
                numChanges++;
            }
            System.out.println();
        } while(b1.getHValue() > 0); // end loop if the board has a 0 heuristic value

        // tell user and display the board which is the solution
        System.out.println("Current State\n" + b1.toString());
        System.out.println("Solution Found!");
        System.out.println("State Changes: " + numChanges);
        System.out.println("Restarts: " + numRestart);
    }

}
