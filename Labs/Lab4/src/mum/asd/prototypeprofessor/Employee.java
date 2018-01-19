package mum.asd.prototypeprofessor;

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
	private boolean supervisorCloned = false;
	
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
//	    Employee emp = (Employee) clone(this, this);
//        //emp.supervisor.supervisor = null; 
//        emp.supervisor.staff[0] = this; //complete it by removing other staff
//        return emp;
	    
	    ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(this);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);

            // return the new object
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("Exception in ObjectCloner = " + e);

        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException ioe) {
                System.out.println("IOException in ObjectCloner = " + ioe);
            }
        }

        return null;
	}
	
	private Employee clone(Employee start, Employee e1){
        // this just shows the idea how to do it
        Employee e = new Employee();
        // set all attributes to the instance
        e.id = e1.id;
        e.setFirstName(new String(e1.getFirstName()));
        e.setLastName(new String(e1.getLastName()));
        e.setStreeAddress(new String(e1.getStreeAddress()));
        e.city = new String(e1.city);
        e.state = new String(e1.state);
        e.zipCode = new String(e1.zipCode);

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
}
