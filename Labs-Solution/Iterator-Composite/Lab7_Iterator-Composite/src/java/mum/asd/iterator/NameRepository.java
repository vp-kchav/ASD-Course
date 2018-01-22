/*
 * Created on Jan 21, 2018
 */
package mum.asd.iterator;

public class NameRepository implements Aggregation {

    private String names[][] = {
        {"Rob" , "Jon" ,"Jul" , "Lor", "Pat", "Ken"},
        {"chav","kim","tey"},
        {"sok","so","van","nary"}
    };
        
    @Override
    public Iterator getIterator() {
        
        return new NameIterator();
    }
    
    private class NameIterator implements Iterator {
        int row;
        int column;

        @Override
        public Object getNext() {
            if(hasNext()) {
                if(column > names[row].length-1) {
                    row++;
                    column =0;
                }
                
                Object next = names[row][column];
                column++;
                return next;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if(names.length-1 == row && names[row].length-1 < column ) {
                return false;
            }
            return true;
        }

        @Override
        public void remove() {
            names[row][column] = "-";
        }
        
    }

}
