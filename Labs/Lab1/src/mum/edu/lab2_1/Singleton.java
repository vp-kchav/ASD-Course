package mum.edu.lab2_1;

public class Singleton {
	private static Singleton uniqueInstance = null; 
	
	public static Singleton getInstance() {   
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();    
		}
		return uniqueInstance;
	}
	 
	private Singleton() { 
		System.out.println("Tranditional singleton");
	}  
	
	
	public void doPrint() {
		System.out.println("I am doing the printing for tranditional singleton!!!");
	}
}
