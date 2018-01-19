package mum.asd.lab4_2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
	private Long id;
	private String firstName;
	private String lastName;
	private String streeAddress;
	private String city;
	private String state;
	private String zipCode;
	private Employee supervisor;
	private Employee staff[] = new Employee[100];
	
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
			String zipCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streeAddress = streeAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public Employee() {
	    
	}

	@Override
	protected Object clone() throws CloneNotSupportedException{
//	    return super.clone();
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);

            oos.writeObject(this);
            oos.flush();
            oos.close();
            bos.close();
            byte[] byteData = bos.toByteArray();

            // restoring class from a stream of bytes
            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            return (Employee) new ObjectInputStream(bais).readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                oos.close();
                bos.close();
            } catch (IOException ioe) {
                System.out.println("IOException in ObjectCloner = " + ioe);
            }
        }
	}

}
