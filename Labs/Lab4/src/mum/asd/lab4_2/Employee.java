package mum.asd.lab4_2;

public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String streeAddress;
	private String city;
	private String state;
	private String zipCode;
	private Employee supervisor;
	private Employee staff[];
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreeAddress() {
		return streeAddress;
	}

	public void setStreeAddress(String streeAddress) {
		this.streeAddress = streeAddress;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public Employee[] getStaff() {
		return staff;
	}

	public void setStaff(Employee[] staff) {
		this.staff = staff;
	}

	public Employee(Long id, String firstName, String lastName, String streeAddress, String city, String state,
			String zipCode, Employee supervisor, Employee[] staff) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streeAddress = streeAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.supervisor = supervisor;
		this.staff = staff;
	}

	@Override
	protected Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
