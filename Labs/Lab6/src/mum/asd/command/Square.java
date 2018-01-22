/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public class Square {
    private int move = 0;
    private int width;
    
    
    public int getMove() {
        return move;
    }
    
    
    public void setMove(int move) {
        this.move = move;
    }
    
    public Square(int width) {
        this.width = width;
    }
    
    public int getWidth() {
        return width;
    }

    
    public void setWidth(int width) {
        this.width = width;
    }

    public void draw(int start) {
        String move ="";
        for (int k = 0; k < start; k++) {
            move += " ";
        }
        for (int i=0; i<width; i++)
        { 
           System.out.print(move);
           for (int j=0; j<width; j++)
           { 
               System.out.print("* "); 
           }
           System.out.println();
        }
    }
    
    public void unDraw() {
        System.out.println(" ");
    }
}
