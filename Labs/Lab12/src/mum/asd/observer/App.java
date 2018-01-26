/*
 * Created on Jan 25, 2018
 */
package mum.asd.observer;


public class App {

    public static void main(String arg[]) {
        Subject subject = new Subject();
        Observer nameObserver = new NameObserver(subject);
        subject.attache(nameObserver);
        subject.addName("Kimtey");
        subject.addName("Nary");
        subject.addName("Panhaseth");
        subject.addName("Dara");
        subject.removeName("Dara");
//    	print("hello", 10);
    }
    
//    public static void print(String text,int x) {
//    	if(x == 1) {
//    		System.out.println(text);
//    	}else {
//    		System.out.println(text);
//    		print(text,x-1);
//    	}
//    }
}
