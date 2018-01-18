package mum.asd.lab4_2;

public class Main {

	public static void main(String[] args) {
		
		Employee[] list = new Employee[] {
			new Employee(103,),
		};

		Employee s = new Employee(10);
		
		Employee e = new Employee(1);
		e.setId(1);
		e.setSupervisor(s);
		e.setStaff(list);
		
		try {

			Employee c = (Employee) e.clone();
			
//			e = null;
			System.out.println(e);
			System.out.println(c);
			
			
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	}
}
