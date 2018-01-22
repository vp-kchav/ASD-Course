/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;

import java.util.Stack;

public class Broker {
    private Command command = null;
    private Stack<Command> stackCommand = new Stack<Command>();

    public void execute(Command com) {
        command = com;
        stackCommand.add(com);
        command.execute();
    }
    
    public void undo() {
        stackCommand.pop().undo();
    }
    
    public Command getCommand() {
        return command;
    }
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public Stack<Command> getStackCommand() {
        return stackCommand;
    }
    
    public void setStackCommand(Stack<Command> stackCommand) {
        this.stackCommand = stackCommand;
    }
    
}
