// Nqueens_backtracking
// Purpose: Apply the backtracking-search algorithm to the nqueens problem
//
// Author:  Tom Troast
// Date: 02/01/2014
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Nqueens_backtracking {

    public static int SLEEP_TIME_MS = 300;

    public static void main(String[] args) {

        // Specify the n in the n-queens problem
        int n = 10;

        // Create a new queenstate
        queenstate tempqueenstate = new queenstate(n);
        //tempqueenstate.set_goalstate_row(0,0);
        
        // create frame for TextGrid
        JFrame frame = new JFrame("Drawing lines, rectangles and ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rows and columns
        int numrows = n;
        int numcols = n;
        char[][] chargrid = new char[numrows][numcols];
        int boxsize = 40;

        // Initialize the grid
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {
                chargrid[i][j] = ' ';
            }
        }

        // Draw the grid
        TextGrid temptextgrid = new TextGrid(numrows, numcols, chargrid, boxsize);
        temptextgrid.setBackground(Color.WHITE);

        frame.add(temptextgrid); // add panel to frame
        frame.setSize(600, 600); // set frame size
        frame.setVisible(true); // display frame   



        // Call the recursive backtracking algorithm
        tempqueenstate = recursive_backtracking(tempqueenstate,temptextgrid);

        // Display the solved queenstate OR notify the user of the problem
        if (tempqueenstate == null) {
            System.out.println(" ");
            System.out.println("****** Search failed *****");
        } else {
            System.out.println(" ");
            System.out.println("GOAL STATE FOUND:");
            tempqueenstate.print_queenstate();
            
            temptextgrid.setchargrid(tempqueenstate.getqueenchararray());
            temptextgrid.setBackground(Color.GREEN);
            temptextgrid.repaint();
        }

    } // End of main function

    public static queenstate recursive_backtracking(queenstate instate,TextGrid intextgrid) {

        // Declare a temp state;
        queenstate tempqueenstate = instate.clone();
        
        // Clone the input
        instate = instate.clone();
        
        // Draw the grid
        intextgrid.setchargrid(tempqueenstate.getqueenchararray());
        intextgrid.repaint();

        try {
            // Pause for a few milliseconds
            Thread.sleep(SLEEP_TIME_MS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Nqueens_backtracking.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        // Display the queenstate
        //instate.print_queenstate();

        // Check if the goal state has been reached
        if (instate.checkgoalstate()) {
            return instate;
        }

        // Find the next unassigned column
        int var = instate.get_next_unassigned();

        for (int j = 0; j < instate.get_nval(); j++) {
            if (!instate.test_for_conflict(j, var)) {
                tempqueenstate.set_goalstate_row(var, j);
                tempqueenstate = recursive_backtracking(tempqueenstate,intextgrid);
                if (tempqueenstate != null) {
                    return tempqueenstate;
                } else {
                    tempqueenstate = instate.clone();
                }
            }
        }
        
        // If you get to this point, it's because of a failure
        System.out.println("Had to backtrack");
        return null;
        

    } // End of recursive_backtracking method
} // End of Nqueens_backtracking class
