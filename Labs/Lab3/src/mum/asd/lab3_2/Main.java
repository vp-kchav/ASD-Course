package mum.asd.lab3_2;

public class Main {

	
	
	public static void main(String[] args) {

		ProxyTable t = new ProxyTable();	
		
		for(int i = 0; i < 5; i++) {
			t.addRow(new Row("Row " + i), i);
		}
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			    IRow modifiedRow = new Row("first modify row " + 1);
				t.modifyRow(1,modifiedRow);
			}			
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				IRow modifiedRow = new Row("second modify row " + 2);		
				t.modifyRow(1,modifiedRow);
			}			
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i = 0; i < 5; i++) {
					System.out.println(t.getRow(i).get());
				}
				
			}			
		});
		
		t1.start();
		
		t2.start();
		
		t3.start();
	
		
		
		
		
		
	}

	
	
}
