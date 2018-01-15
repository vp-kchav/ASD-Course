package mum.edu.lab2_2;


public class App {

	public static void main(String[] args) throws InterruptedException {
		for(int i = 1; i<=1000000; i++) {
			Thread.sleep(100);
			Singleton singleton = Singleton.INSTANCE;
			singleton.doPrint();
		}
	}
}
