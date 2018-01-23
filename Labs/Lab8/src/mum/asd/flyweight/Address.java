package mum.asd.flyweight;

public class Address {
	private String address;
	public Address(String a) {
		address = a;
	}
	
	@Override
	public String toString() {
		return address;
	}
}
