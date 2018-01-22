/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public class App {
    
    public static void main(String []arg) {
        Square s = new Square(5);
        Broker broker = new Broker();
        broker.execute(new CreateCommand(s));
//        broker.execute(new MoveCommand(s, 2));
        broker.execute(new ScaleCommand(s,2));
        broker.undo();
    }

}
