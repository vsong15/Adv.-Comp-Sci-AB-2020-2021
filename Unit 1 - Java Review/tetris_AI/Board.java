package tetris_AI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;import javax.swing.Timer;

import tetris_AI.Shape.Tetrominoes;

import java.util.concurrent.TimeUnit;

public class Board extends JPanel implements ActionListener {

    final int BoardWidth = 10;
    final int BoardHeight = 22;

    Timer timer;
    boolean isFallingFinished = false;
    boolean isStarted = false;
    boolean isPaused = false;
    int numLinesRemoved = 0;
    int curX = 0;
    int curY = 0;
    JLabel statusbar;
    Shape curPiece;
    Tetrominoes[] board;
        
    // Variables for the Genetic Algorithm
    int iteration_number = 1;
    int population_size = 4;
    int num_lines_per_run[];

    public Board(Tetris parent) {

        setFocusable(true);
        curPiece = new Shape();
        timer = new Timer(30, this);  // ** T. Troast ****** THIS LINE TO SPEED UP / SLOW DOW
        timer.start();

        statusbar = parent.getStatusBar();
        board = new Tetrominoes[BoardWidth * BoardHeight];
        addKeyListener(new TAdapter());
        clearBoard();
        
        // genetic algorithm stuff
        
        
        
    }

    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished) {
            isFallingFinished = false;            
            newPiece();
        } else {
            oneLineDown();
            doNextMove();
        }
    }

    int squareWidth() {
        return (int) getSize().getWidth() / BoardWidth;
    }

    int squareHeight() {
        return (int) getSize().getHeight() / BoardHeight;
    }

    Tetrominoes shapeAt(int x, int y) {
        return board[(y * BoardWidth) + x];
    }

    public void start() {
        if (isPaused) {
            return;
        }

        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();

        newPiece();
        timer.start();
    }

    private void pause() {
        if (!isStarted) {
            return;
        }

        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            statusbar.setText("paused");
        } else {
            timer.start();
            statusbar.setText(String.valueOf(numLinesRemoved));
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();

        for (int i = 0; i < BoardHeight; ++i) {
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape != Tetrominoes.NoShape) {
                    drawSquare(g, 0 + j * squareWidth(),
                            boardTop + i * squareHeight(), shape);
                }
            }
        }

        if (curPiece.getShape() != Tetrominoes.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawSquare(g, 0 + x * squareWidth(),
                        boardTop + (BoardHeight - y - 1) * squareHeight(),
                        curPiece.getShape());
            }
        }
    }

    private void dropDown(boolean normalmode) {
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1, true)) {
                break;
            }
            --newY;
        }
        if (normalmode) {
            pieceDropped(true);
        } else {
            curY = newY;
        }
    }

    private void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1, true)) {
            pieceDropped(true);
        }
    }

    private void clearBoard() {
        for (int i = 0; i < BoardHeight * BoardWidth; ++i) {
            board[i] = Tetrominoes.NoShape;
        }
    }

    private void pieceDropped(boolean removelines) {
        for (int i = 0; i < 4; ++i) {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BoardWidth) + x] = curPiece.getShape();
        }

        // Check the state of the board
        double boardstate_value = this.checkBoardState();
        statusbar.setText(String.valueOf(numLinesRemoved));

        if (removelines) {

            removeFullLines();
        }

        if (!isFallingFinished) {
            newPiece();
        }
    }

    private void newPiece() {
        curPiece.setRandomShape();
        curX = BoardWidth / 2 + 1;
        curY = BoardHeight - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY, true)) {
            curPiece.setShape(Tetrominoes.NoShape);
            // timer.stop();
            // isStarted = false;
            statusbar.setText("game over - total lines cleared = " + numLinesRemoved);
            
            
            System.out.println(numLinesRemoved + " lines cleared on iteration " + iteration_number);
            clearBoard();
            numLinesRemoved = 0;
            iteration_number++;
            
            // Store the results of the tetris run (number of lines cleared)
            
            
            
        }
        

    }

    private boolean tryMove(Shape newPiece, int newX, int newY, boolean repaintboard) {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight) {
                return false;
            }
            if (shapeAt(x, y) != Tetrominoes.NoShape) {
                return false;
            }
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;
        if (repaintboard) {
            repaint();
        }
        return true;
    }

    private void removeFullLines() {
        int numFullLines = 0; 
        
        for (int i = BoardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BoardWidth; ++j) {
                if (shapeAt(j, i) == Tetrominoes.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < BoardHeight - 1; ++k) {
                    for (int j = 0; j < BoardWidth; ++j) {
                        board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            statusbar.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            curPiece.setShape(Tetrominoes.NoShape);
            repaint();
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominoes shape) {
        Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }

    public double checkBoardState() {

        // Define the weights array
        double[] weights = new double[]{20.0, -15.0, -30.0, 3.0, -4.0, -2.0};
        //double[] weights = new double[]{0.1905, -0.3351, -0.5285, 0.05, -0.05, -0.2756};

        // Create an array for the features
        int[] feature_array = new int[6];

        // -----------  Compute the values for the features
        // Determine the number of "full" horizontal lines
        feature_array[0] = this.countFullLines();

        // Compute the height of the tallest piece
        feature_array[1] = this.getMaxHeight();

        // Compute the number of holes (empty cells covered by one or more 
        // filled cells)
        feature_array[2] = this.countNumHoles();
        
        // Compute the row completion percentage
        //feature_array[3] = this.percentage_of_lines_complete();
        
        // Compute the bottom-heaviness of the board (bottom heaviness is good)
        feature_array[3] = bottom_heaviness();
        
        // Compute the difference between the highest and lowest columns
        feature_array[4] = getHeightDifference();
        
        // Compute the total cumulative well depth
        feature_array[5] = getWellDepth();

        // Compute the number of rows with at least one hole
        // TODO
        // Total hole depth (total number of filled cells on top of each hole)
        // TODO
        // -----------  Compute the weighted sum of the features
        double weighted_sum = 0.0;
        for (int i = 0; i < feature_array.length; i++) {
            weighted_sum = weighted_sum + weights[i] * (double) feature_array[i];
        }
        

        return weighted_sum;
    }

    public int countFullLines() {
        int num_full_lines = 0;

        boolean rowisfull = false;

        for (int i = 0; i < BoardHeight; ++i) {
            rowisfull = true;
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape == Tetrominoes.NoShape) {
                    rowisfull = false;
                    break;
                }
            }
            if (rowisfull) {
                num_full_lines++;
            }
        }

        return num_full_lines;
    }

    public int getMaxHeight() {
        int max_height = 0;

        boolean row_is_empty = true;

        for (int i = 0; i < BoardHeight; ++i) {
            row_is_empty = true;
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape != Tetrominoes.NoShape) {
                    row_is_empty = false;
                    break;
                }
            }
            if (!row_is_empty) {
                max_height = BoardHeight - i;
                break;
            }
        }

        return max_height;
    }
    
    public int getHeightDifference(){
        
        int height_difference = 0;
        int max_height = -999;
        int min_height = 999;
        
        for(int j = 0; j < BoardWidth; j++){
            int top_most_block = 0;
            for(int i = BoardHeight - 1; i >= 0; i--){
                Tetrominoes shape = shapeAt(j, i);
                 if (shape != Tetrominoes.NoShape) {
                    top_most_block = i;
                    break;
                }                
            }
            if(top_most_block > max_height){
                max_height = top_most_block;
            } 
            if(top_most_block < min_height){
                min_height = top_most_block;
            }
            
        }
        
        height_difference = max_height - min_height;        
        return height_difference;
    }
    
    public int getWellDepth(){
        
        int total_well_depth = 0;
        boolean initial_state;
        boolean walls_found;        
        int well_depth;

        for (int j = 0; j < BoardWidth; j++) {
            initial_state = true;
            well_depth = 0;
            walls_found = false;
            for (int i = BoardHeight - 1; i >= 0; i--) {
                boolean leftfull = false;
                boolean rightfull = false;
                Tetrominoes shape = shapeAt(j, i);
                if (shape == Tetrominoes.NoShape) {

                    if (initial_state == true) {
                        // Check both left & right side for a wall or filled cell                                          
                        if (j == 0) {
                            leftfull = true;
                        } else {
                            Tetrominoes leftshape = shapeAt(j - 1, i);
                            if (leftshape != Tetrominoes.NoShape) {
                                leftfull = true;
                            }
                        }

                        if (j == (BoardWidth - 1)) {
                            rightfull = true;
                        } else {
                            Tetrominoes rightshape = shapeAt(j + 1, i);
                            if (rightshape != Tetrominoes.NoShape) {
                                rightfull = true;
                            }
                        }

                        walls_found = (leftfull & rightfull);
                        if (walls_found) {
                            initial_state = false;

                        }
                    } 
                    
                    if (initial_state == false) {
                        well_depth++;
                    }

                } else {
                    break;
                }

            } // END OF I LOOP
            
            total_well_depth += well_depth;
            
        } // END OF J LOOP
                        
        
        return total_well_depth;        
    }
    
    
    public int countNumHoles() {

        int num_holes = 0;
        int holestate = 0;

        for (int j = 0; j < BoardWidth; ++j) {
            holestate = 0;
            for (int i = BoardHeight - 1; i >= 0; i--) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape == Tetrominoes.NoShape) {
                    holestate = 1;
                } else {
                    if (holestate == 1) {
                        num_holes++;
                    }
                    holestate = 2;
                }
            } // End of i loop
        } // End of j loop

        return num_holes;
    }
    
    public int percentage_of_lines_complete(){
        
        int percentage_lines_complete = 0;
        int num_filled_squares = 0;
        
        // Compute the max height of occupied rows (rows with < 1 square filled)        
        int max_height = 0;
        boolean row_is_empty = true;
        for (int i = 0; i < BoardHeight; ++i) {
            row_is_empty = true;
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape != Tetrominoes.NoShape) {
                    row_is_empty = false;
                    break;
                }
            }
            if (!row_is_empty) {
                max_height = BoardHeight - i;
                break;
            }
        }
        
        // Generate an array of weights
        double[] weight_array = new double[max_height];
        double weight_multiplier = 2;
        double weight_sum = 0;
        for(int i = 0;i<max_height;i++){
            weight_array[i] = weight_multiplier*(max_height-i);
            weight_sum += weight_array[i];
        }
        
        // Create an array to store the row-wise percentages
        double[] percentage_array = new double[max_height];
        
        // Compute the percentages of occupied squares in occupied rows
        int rowtotal = 0;
        double numerator = 0;
        double denominator = (double)(BoardWidth);
        for (int i = 0; i < max_height; ++i) {
            rowtotal = 0;
            // Count the number of occupied squares in each row
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, i);
                if (shape != Tetrominoes.NoShape) {
                    rowtotal++;
                }                
            }
            // Compute the percentage of filled squares in this row
            numerator = (double)rowtotal;
            double temp_percentage = numerator/denominator;
            percentage_array[i] = temp_percentage;
        }        
        
        // Compute the weighted average of row completions
        double weighted_average = 0;
        for(int i = 0; i<max_height; i++){            
            weighted_average += weight_array[i]*percentage_array[i];
        }
        weighted_average = weighted_average/weight_sum;
       
        percentage_lines_complete = (int)(100*weighted_average);
        
        return percentage_lines_complete;
        
    }

    public int bottom_heaviness(){
        
        int bottom_heaviness = 0;
        double y_coord_sum = 0;     
        double num_y = 0;
        
        // Determine the coordinates of the pieces
        for (int i = 0; i < BoardHeight; ++i) {            
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, i);
                if (shape != Tetrominoes.NoShape) {                    
                    y_coord_sum = y_coord_sum + i;                                 
                    num_y++;
                }            
            }
        }
        
        // Compute the geometric centroid and determine how close it is to the
        // bottom       
        
        int y_mean = (int)(y_coord_sum/num_y);
        bottom_heaviness = BoardHeight - y_mean;
        
        return bottom_heaviness;        
        
    }
    
    
    public void doNextMove() {

        // Set up a matrix for storing the values associated with each move
        double[][] costs = new double[BoardWidth][4];
        
        // Set the costs to a large negative value to initialize
        for (int j = 0; j < BoardWidth; j++) {
            for(int k = 0;k<4;k++){
                costs[j][k] = -9999;
            }
        }
        
        // Store the original X and Y coordinates
        int storedX = curX;
        int storedY = curY;                
        
        // Store the original 
        
        for (int k = 0; k < 4; k++) {

            // Rotate the piece
            for (int i = 0; i < k; i++) {
                tryMove(curPiece.rotateRight(), curX, curY, false);
            }

            for (int j = 0; j < BoardWidth; j++) {

                // Check to see if this is a valid x-shift - if not, continue
                if (!tryMove(curPiece, j, curY, false)) {
                    continue;
                }

                // Drop the piece           
                dropDown(false);

                // Store the piece in the array
                for (int i = 0; i < 4; ++i) {
                    int x = curX + curPiece.x(i);
                    int y = curY - curPiece.y(i);
                    board[(y * BoardWidth) + x] = curPiece.getShape();
                }

                // Debug stuff
                //print_board_state();
                
                // Compute the state associated with this piece
                costs[j][k] = checkBoardState();          
                
                // Debug stuff
                //System.out.println("j = " + j + "  k = " + k);
                //System.out.println(" ");

                // Reset the board to its original state            
                for (int i = 0; i < 4; ++i) {
                    int x = curX + curPiece.x(i);
                    int y = curY - curPiece.y(i);
                    board[(y * BoardWidth) + x] = Tetrominoes.NoShape;
                }

            } // END OF ROTATION LOOP
            
            // Reset the piece to its original state
            curX = storedX;
            curY = storedY;
            tryMove(curPiece, curX, curY, false);
            
            // Rotate the piece
            for (int i = 0; i < k; i++) {
                tryMove(curPiece.rotateLeft(), curX, curY, false);
            }
            
        } // END OF OFFSET LOOP
        
        // Determine the best offset and rotation from the array
        int bestoffset = 0;
        int bestrotation = 0;
        double largestcost = -9999;
        for (int j = 0; j < BoardWidth; j++) {
            for (int k = 0; k < 4; k++) {
                if (costs[j][k] > largestcost) {
                    largestcost = costs[j][k];
                    bestoffset = j;
                    bestrotation = k;
                }
            }
        }

        // Shift and rotate the piece using the best offset & rotation
        for (int i = 0; i < bestrotation; i++) {
            tryMove(curPiece.rotateRight(), curX, curY, true);
        }
        tryMove(curPiece, bestoffset, curY, true);

        // Drop the piece into place
        dropDown(true);

    }

    void print_board_state() {

        for (int i = 0; i < BoardHeight; ++i) {
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape != Tetrominoes.NoShape) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println(' ');
        }

        // Print out some newline charachters
        System.out.println(" ");
        System.out.println("Cost " + checkBoardState());

    }

    class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            if (!isStarted || curPiece.getShape() == Tetrominoes.NoShape) {
                return;
            }

            int keycode = e.getKeyCode();

            if (keycode == 'p' || keycode == 'P') {
                pause();
                return;
            }

            if (isPaused) {
                return;
            }

            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    tryMove(curPiece, curX - 1, curY, true);
                    break;
                case KeyEvent.VK_RIGHT:
                    tryMove(curPiece, curX + 1, curY, true);
                    break;
                case KeyEvent.VK_DOWN:
                    tryMove(curPiece.rotateRight(), curX, curY, true);
                    break;
                case KeyEvent.VK_UP:
                    tryMove(curPiece.rotateLeft(), curX, curY, true);
                    break;
                case KeyEvent.VK_SPACE:
                    dropDown(true);
                    break;
                case 'd':
                    oneLineDown();
                    break;
                case 'D':
                    oneLineDown();
                    break;
            }

        }
    }

}
