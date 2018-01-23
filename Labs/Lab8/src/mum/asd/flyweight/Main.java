package mum.asd.flyweight;

public class Main {

	public static void main(String[] args) {

		Customer c = CustomerFactory.getInstance("SR");
		
		c.showInfo(11, "Jon", "Nena", new Address("room 120"), new HealthProfile("history 1"));
		
		Customer c2 = CustomerFactory.getInstance("PP");
		
		c2.showInfo(13, "Kelvin", "Storm", new Address("room 121"), new HealthProfile("history 2"));
	}

}
