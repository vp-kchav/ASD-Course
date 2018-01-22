/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public class CreateCommand implements Command {
    Square square;
    
    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public CreateCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.draw(0);
    }

    @Override
    public void undo() {
        square.unDraw();
    }

}
