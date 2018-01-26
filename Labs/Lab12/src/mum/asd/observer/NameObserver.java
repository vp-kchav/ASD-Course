/*
 * Created on Jan 25, 2018
 */
package mum.asd.observer;


public class NameObserver extends Observer{
    Subject subject;
    String nameDisplay;
    
    public NameObserver(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void update() {
        for(String name : subject.getNames()) {
            System.out.println(name + "  ");
        }
    }

    
}
