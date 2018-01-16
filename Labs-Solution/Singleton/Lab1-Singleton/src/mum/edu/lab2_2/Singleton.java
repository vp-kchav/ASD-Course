package mum.edu.lab2_2;

public enum Singleton {
	INSTANCE;
	private Singleton() {
		System.out.println("I am here!!!");
	}

	public void doPrint() {
		System.out.println("I am doing the printing!!!");
	}
}
