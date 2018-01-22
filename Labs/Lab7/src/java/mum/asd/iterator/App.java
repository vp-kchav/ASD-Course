/*
 * Created on Jan 21, 2018
 */
package mum.asd.iterator;


public class App {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        Iterator iter = namesRepository.getIterator();
        while(iter.hasNext()) {
            System.out.println(iter.getNext());
        }
     }
}
