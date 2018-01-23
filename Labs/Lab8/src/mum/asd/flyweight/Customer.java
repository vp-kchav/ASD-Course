package mum.asd.flyweight;

public class Customer implements ACustomer {
	//private int customerId;
	//private String firstName;
	//private String lastName;
	
	//private Address residenceAddress;
	//private HealthProfile profile;
	
	//city map with a red dot representing residence location
	private Image locationMap;
	
	
	
	public Customer(String location) {
		locationMap = new Image(location);
	}



	@Override
	public void showInfo(int id, String f, String l, Address a, HealthProfile p) {
		System.out.println(id + ": " + f + " " + l);
		System.out.println(a + " - " + p + " - " + locationMap);
		System.out.println("=========================");
	}
	
	
	
	
	
}
