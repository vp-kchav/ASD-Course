package mum.asd.lab3_1;

public class Main {

	public static void main(String[] args) {
	    Adapter adapter = new Adapter();
        
        System.out.println("Adapter Queue Operation");
        adapter.queue("A");
        adapter.queue("B");
        adapter.dequeue();
        
        System.out.println("Queue : "+ adapter.toString());
        
        
        System.out.println("Adapter Stack Operation");
        adapter.push("AA");
        adapter.push("AB");
        adapter.push("AC");
        adapter.pop();
        
        System.out.println("Stack : "+ adapter.toString());
		
	}

}
