package mum.asd.prototypeDarith;

import java.io.Serializable;
import java.util.Arrays;

public class Employee implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private Employee supervisor;
	private Employee staff[];
	
	public Employee() {}
	public Employee(int id) {
		this.id = id;
	}
	public Employee(int id, Employee[] list) {
		this(id);
		staff = list;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", supervisor=" + supervisor + ", staff=" + Arrays.toString(staff) + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
	
}