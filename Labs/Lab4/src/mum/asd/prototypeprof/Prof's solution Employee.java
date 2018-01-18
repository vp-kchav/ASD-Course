package mum.asd.prototypeprof;

import java.io.Serializable;

public class Employee implements Cloneable, Serializable {

	private int id;
	private String lastname;
	private String firstname;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private Employee supervisor;
	private Employee staff[];
	private boolean supervisorCloned = false;
	

	@Override
	protected Object clone() {
		Employee emp = (Employee) clone(this, this);
		//emp.supervisor.supervisor = null; 
		emp.supervisor.staff[0] = this; //complete it by removing other staff
		return emp;
	}
	
	private Employee clone(Employee start, Employee e1){
		// this just shows the idea how to do it
		Employee e = new Employee();
		// set all attributes to the instance
		e.id = e1.id;
		e.firstname = new String(e1.firstname);
		e.lastname = new String(e1.lastname);
		e.streetAddress = new String(e1.streetAddress);
		e.city = new String(e1.city);
		e.state = new String(e1.state);
		e.zipcode = new String(e1.zipcode);

		// check if the employee has a supervisor
		if (e1.supervisor != null) {
			e1.supervisorCloned = true;
			e.supervisor = clone(start, e1.supervisor);
		}

		if ( this != e1 ){ //running inside a recursive call
			// check if the employee has direct reports
			if (e1.staff != null && e1.staff.length > 0) {
				e.staff = new Employee[1];
				for (Employee emp : e1.staff) {
					if (emp != null && emp.supervisor == e1 ) {
						e.staff[0] = emp;
						break;
					}
				}
			}
		} else {
			if (e1.staff != null && e1.staff.length > 0) {
				e.staff = new Employee[e1.staff.length];
				int i = 0;
				for (Employee emp : e1.staff) {
					if (emp != null && emp.supervisor == e1 ) {
						e.staff[i] = emp.clone(emp, emp);
						e.staff[i].supervisor = e;
					}
					i++;
				}
			}
			
		}
		return e;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

}
