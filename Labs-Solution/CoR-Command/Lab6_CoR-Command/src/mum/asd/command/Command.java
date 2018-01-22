/*
 * Created on Jan 19, 2018
 */
package mum.asd.command;


public interface Command {
    public void execute();
    public void undo();
}
