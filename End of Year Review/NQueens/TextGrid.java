/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.*;

public class TextGrid extends JPanel {
    
    // Members
    private int numrows;
    private int numcols;
    private char[][] chargrid;
    private int boxsize;
    
    // Constructor
    public TextGrid(int m, int n,char[][] inchargrid,int inboxsize){
        
        this.numrows = m;
        this.numcols = n;
        this.chargrid = inchargrid.clone();        
        this.boxsize = inboxsize;
        
    }  // End of TextGrid constructor    
    
    // display various lines, rectangles and ovals
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g); // call superclass's paint method

        //this.setBackground(Color.GRAY);                
        
        // Iterators & misc. variables
        int i;
        int j;
        char tempchar;
        String tempstring = null;
        
        // Length of the lines
        int rowlinelength = numcols*boxsize;
        int collinelength = numrows*boxsize;
                
        // Draw the row lines
        int yloc;
        for(i = 0;i<numrows+1;i++){
           yloc = i*boxsize;
           g.drawLine(0, yloc, rowlinelength, yloc);            
        }
        
        // Draw the column lines
        int xloc;
        for(i = 0;i<numcols+1;i++){
            xloc = i*boxsize;
            g.drawLine(xloc, 0, xloc, collinelength);
        }
        
        // Set the font
        g.setFont(new Font("SansSerif", Font.PLAIN, 24));
        
        // Draw the text
        for(i = 0;i<numrows;i++){
            yloc = (boxsize*i) + (int)Math.floor(boxsize/2);            
            for(j = 0;j<numcols;j++){
                xloc = (boxsize*j) + (int)Math.floor(boxsize/2);
                tempchar = chargrid[i][j];
                tempstring = Character.toString(tempchar);
                g.drawString(tempstring, xloc, yloc);
            }
        }
                
    
    } // End of paintComponent class
    
    
    // Get window xlength
    public int getxlength(){        
        return numcols*boxsize;
    }
    
    // Get window ylength
    public int getylength(){
        return numrows*boxsize;
    }

    // Set the char grid
    public void setchargrid(char[][] inchargrid){
        this.chargrid = inchargrid;
    }
    
    
} // End of TextGrid class definition
