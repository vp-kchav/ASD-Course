/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public class ScaleCommand implements Command {
    private Square square;
    int scale;
    
    public ScaleCommand(Square square,int scale) {
        this.square = square;
        this.scale = scale;
    }
    public int getScale() {
        return scale;
    }

    
    public void setScale(int scale) {
        this.scale = scale;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
       square = new Square(this.square.getWidth() * scale);
       square.draw(0);
    }

    @Override
    public void undo() {
        square.setWidth(square.getWidth() / scale);
        square.draw(0);
    }

}
