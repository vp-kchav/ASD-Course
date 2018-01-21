/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public class MoveCommand implements Command {
    
    int move;
    Square square;
    
    public int getMove() {
        return move;
    }
    
    public void setMove(int move) {
        this.move = move;
    }
    
    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
    public MoveCommand(Square square,int move) {
        this.square = square;
        this.move = move;
    }
    
    @Override
    public void execute() {
        square.draw(move);
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }

}
