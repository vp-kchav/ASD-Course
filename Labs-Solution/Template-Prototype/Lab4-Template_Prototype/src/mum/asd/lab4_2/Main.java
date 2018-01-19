package mum.asd.lab4_2;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employee[] list = new Employee[] {
			new Employee(101L,"1","1","1","1","1","1"),
		};

		Employee s = new Employee(202L,"2","2","2","2","2","2");
		
		Employee e = new Employee(303L,"3","3","3","3","3","3");
		e.setSupervisor(s);
		e.setStaff(list);
		
		Employee c = (Employee) e.clone();
		
//			e = null;
		System.out.println(e);
		System.out.println(c);
		
	
	}
}
