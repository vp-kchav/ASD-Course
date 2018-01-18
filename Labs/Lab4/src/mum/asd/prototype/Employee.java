package mum.asd.prototype;

import java.io.Serializable;
import java.util.HashMap;

public class Employee implements Cloneable, Serializable {
	private int id;
	private String Lastname;
	private String Firstname;
	private Employee supervisor;
	private Employee staff[];
	static HashMap map = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	private Employee cloneHelper(Employee sup, Employee staff) {
		if (map == null) {
			map = new HashMap<Integer, Employee>();
		}
		Employee employee = null;
		try {
			//copy staff object information to employee object
			employee = new Employee(staff.getId(), staff.getLastname(), staff.getFirstname());
			map.put(employee.getId(), employee);
			if (map.containsKey(sup.getId())) {
				//if map already contain supervisor that is already cloned, set the supervisor to the employee
				employee.setSupervisor((Employee) map.get(sup.getId()));
			} else {
				Employee clone = null;
				if (sup != this) {
					clone = (Employee) sup.clone();
				} else {
					clone = this;
				}
				map.put(clone.getId(), clone);
				employee.setSupervisor(clone);
			}
			//
			Employee[] staff2 = staff.getStaff();
			if (staff2 != null) {
				Employee[] staff3 = new Employee[staff2.length];
				for (int i = 0; i < staff2.length; i++) {
					if (map.containsKey(staff2[i].getId())) {
						staff3[i] = (Employee) map.get(staff2[i].getId());
					} else {
						Employee cloneHelp = cloneHelper(staff, staff2[i]);
						staff3[i] = cloneHelp;
						map.put(staff3[i].getId(), staff3[i]);
					}
				}
				employee.setStaff(staff3);
			} else {
				employee.setStaff(null);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return employee;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee employee = new Employee(id, Lastname, Firstname);
		if (supervisor != null) {
			employee.setSupervisor((Employee) supervisor.clone());
		} else {
			employee.setSupervisor(null);
		}
		if (staff != null) {
			Employee[] s = new Employee[staff.length];
			for (int i = 0; i < s.length; i++) {
				Employee cloneStaff = cloneHelper(employee, staff[i]);
				s[i] = cloneStaff;
			}
			employee.setStaff(s);
		} else {
			employee.setStaff(null);
		}
		return employee;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Lastname=" + Lastname + ", Firstname=" + Firstname + "]";
	}

	public static void print(Employee emp) {
		System.out.println(emp.toString());
		System.out.println("Supervisor:");
		System.out.println(emp.getSupervisor().toString());
		Employee[] staffs = emp.getStaff();
		if (staffs == null)
			return;
		for (Employee e : staffs) {
			System.out.println("Staff Information");
			print(e);
		}
	}

	public Employee(int id, String lastname, String firstname) {
		super();
		this.id = id;
		Lastname = lastname;
		Firstname = firstname;
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

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Jonh", "Da");
		Employee e2 = new Employee(2, "Jonh", "Da");
		Employee e3 = new Employee(3, "Jonh", "Da");
		Employee e4 = new Employee(4, "Jonh", "Da");
		Employee e5 = new Employee(5, "Jonh", "Da");
		Employee e6 = new Employee(6, "Jonh", "Da");
		Employee e7 = new Employee(7, "Jonh", "Da");
		Employee e8 = new Employee(8, "Jonh", "Da");
		Employee e9 = new Employee(9, "Jonh", "Da");
		Employee e10 = new Employee(10, "Jonh", "Da");

		Employee[] staff1 = new Employee[] { e5, e6, e7 };
		Employee[] staff2 = new Employee[] { e8 };
		Employee[] staff3 = new Employee[] { e9, e10 };
		e1.setSupervisor(e2);
		e2.setSupervisor(e3);
		e3.setSupervisor(e4); // e4 supervisor is null

		e1.setStaff(staff1);
		e5.setSupervisor(e1);
		e6.setSupervisor(e1);
		e7.setSupervisor(e1);

		e5.setStaff(staff2);
		e8.setSupervisor(e5);

		e8.setStaff(staff3);
		e9.setSupervisor(e8);
		e10.setSupervisor(e8);

		Employee cloneEmp = null;

		try {
			cloneEmp = (Employee) e1.clone();
			cloneEmp.getSupervisor().setFirstname("Cloned Supervisor");
			for (Employee s : cloneEmp.getStaff()) {
				s.setFirstname("Cloned Staff");
			}
			print(cloneEmp);
			// System.out.println(cloneEmp);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++Orginal Employee+++++++++++++++++");
		print(e1);

	}
}
