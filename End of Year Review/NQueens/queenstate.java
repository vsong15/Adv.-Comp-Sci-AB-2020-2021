
import java.lang.Math;

// queen_boardstate class
public class queenstate implements Cloneable {

    // Class members
    private int nval;
    private int[] columnvals;
    private int nextcolumn;
    
    // Get function
    public int get_nval() {
        return nval;
    }

    // get/set for nextcolumn
    public int get_nextcolumn() {
        return nextcolumn;
    }

    public void set_nextcolumn(int next) {
        this.nextcolumn = nextcolumn;
    }

    // Get for columnvals
    public int[] get_columnvals() {
        return columnvals;
    }   
    
    // Set the columnvals
    public void set_columnvals(int a[]){
        this.columnvals = a;
    }

    public void set_goalstate_row(int column, int row) {
        this.columnvals[column] = row;        
    }
    
    public int get_next_unassigned(){
        for(int j = 0; j < columnvals.length; j++){
            if(columnvals[j] == -1){
                return j;
            }
        }
        return -1;
    }

    // Constructor
    public queenstate(int n) {

        // Set the size
        this.nval = n;

        // Set the nextcolumn
        this.nextcolumn = 0;

        // Create the array 
        columnvals = new int[n];

        // Initialize the vectors
        for (int j = 0; j < columnvals.length; j++) {
            columnvals[j] = -1;
        }        
        
    }

    // Clone the object
    @Override
    public queenstate clone() {  // Clone a Graph object.
        queenstate answer;

        try {
            answer = (queenstate) super.clone();
        } catch (CloneNotSupportedException e) {  // This would indicate an internal error in the Java runtime system
            // because super.clone always works for an Object.
            throw new RuntimeException("This class does not implement Cloneable");
        }

        answer.nval = nval;
        answer.columnvals = columnvals.clone();

        return answer;
    }

    // Test for equality
    public boolean equals(queenstate instate) {
        boolean result = false;
        int n = instate.get_nval();
        int array1[] = this.get_columnvals();
        int array2[] = instate.get_columnvals();
        for (int i = 0; i < n; i++) {
            if (array1[i] != array2[i]) {
                break;
            }
        }
        return result;
    }

    // Print the queenstate
    public void print_queenstate() {
        System.out.print("Queenstate: ");
        for (int j = 0; j < columnvals.length; j++) {
            if(columnvals[j] == -1){
                System.out.print("X");
            } else {
                System.out.print(columnvals[j] + " ");
            }
        }
        System.out.println(" ");
    }

    // Test for a conflict (when adding a new queen to column col)
    public boolean test_for_conflict(int row, int col) {
        boolean result = false;
        int i, j;
        float dy, dx;
        for (i = 0; i < col; i++) {
            // If another queen occupies this row, it's a conflict           
            if (columnvals[i] == row) {
                result = true;
                return result;
            }
            // If another queen intercepts this on a diagonal, it's a conflict
            dx = col - i;
            dy = row - columnvals[i];
            if((Math.abs(dy/dx) == 1)) {
                return true;
            }
        }
        return result;
    }
    
    // Test for a conflict between the queens in two columns
    public boolean test_conflict_cols(int col1,int col2){
        int row1 = columnvals[col1];
        int row2 = columnvals[col2];
        float dy,dx;
        
        // If either row is a negative (unassigned) value, it's a "conflict"
        if((row1 == -1) || (row2 == -1)){
            return true;
        }
        
        // If the queens occupy the same row, it's a conflict
        if(row1 == row2){
            return true;
        }
        
        // If the queens occupy the same diagonal line, it's a conflict
        dx = col1-col2;
        dy = row1-row2;
        if (Math.abs(dy / dx) == 1) {
            return true;
        }

        return false;
    }
    
    // Set the queenstate to a random state
    public void setrandom(){
        for(int i = 0; i < nval; i++){
            columnvals[i] = (int)(Math.random() * ((nval)));
        }
        return;
    }
    
    // Count the number of conflicts in a state
    public int numnonconflicts(){
        int conflict_count = 0;
        int nonconflict_count = 0;
        int i,j;
        int row1,row2;
        for(i = 0;i<nval;i++){
            for(j = i+1;j<nval;j++){                
                if(this.test_conflict_cols(i, j)){
                    conflict_count++;
                }
            }
        }            
        nonconflict_count = (nval*(nval-1))/2 - conflict_count;
        return nonconflict_count;
    }
    
    // Splice two queenstates together
    public queenstate splice(queenstate other, int c) {
        queenstate outstate = new queenstate(this.nval);
        int x[] = this.get_columnvals();
        int y[] = other.get_columnvals();
        int n = this.nval;
        int a[] = new int[n];
        int i;
        // Copy the first part to a from x
        for (i = 0; i < c; i++) {
            a[i] = x[i];
        }
        // Copy the second part to a from y
        for (i = c; i < n; i++) {
            a[i] = y[i];
        }
        outstate.set_columnvals(a);
        return outstate;
    }
    
    // Mutate a queen
    public void mutate(){
        // Pick a queen at random and move it to a random square in its column
        int whichqueen = (int)(Math.random() * nval);
        this.columnvals[whichqueen] = (int)(Math.random() * nval);
    }
    
    // Check for the goal state
    public boolean checkgoalstate() {
        int n = this.nval;
        int total = (n * (n - 1)) / 2;
        if (this.numnonconflicts() == total) {
            return true;
        }
         else {
            return false;
        }        
    }
    
    // Return a character array containing the "queenstate"
    public char[][] getqueenchararray(){
        int n = this.nval;
        char[][] outchar = new char[n][n];
        int i,j;
        
        // Initialize the character array
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                outchar[i][j] = ' ';
            }            
        }
        
        // Put an x where there is a queen
        for (i = 0; i < n; i++) {
            j = this.columnvals[i];
            if (j != -1) {
                outchar[j][i] = 'x';
            }
        }

        return outchar;
    }
    
    
} // End of queenstate class definition
