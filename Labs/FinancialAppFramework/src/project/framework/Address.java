package project.framework;

import project.framework.interfaces.IAddress;

public class Address implements IAddress {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;

	public Address() {
	}

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address(String street, String city, String state, String zip, String email) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}


	public String getEmail() {
		return email;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		String n = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		sb.append("\tStreet: " + street + n);
		sb.append("\tCity: " + city + n);
		sb.append("\tState: " + state + n);
		sb.append("\tZip: " + zip + n);
		sb.append("\tEmail: " + email + n);
		return sb.toString();
	}

	@Override
	public Object getFormattedAddress() {
		return toString();
	}
}
