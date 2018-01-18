package mum.asd.prototypeprof; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 985077 HIten Vasnani
 */
public class Employee implements Cloneable, Serializable {

    private int id;
    private String name;
    private Employee supervisor;
    private Employee staff[];

    public Employee(int id, String name, Employee supervisor, Employee[] staff) {
        this.id = id;
        this.name = name;
        this.supervisor = supervisor;
        this.staff = staff == null ? new Employee[0] : staff;
    }

    public void setStaff(Employee[] cloneStaff) {
        this.staff = cloneStaff;
    }

    Employee firstStaff() {
        return staff[0];
    }

    @Override
    protected Object clone() {
        Employee highestClone;
        Employee highest = this;
        while (highest.supervisor != null) {
            highest = highest.supervisor;
        }
        highestClone = new Employee(highest.id, highest.name, null, new Employee[0]);
        HashMap<Employee, Employee> clonesTable = new HashMap<>();
        clonesTable.put(highest, highestClone);
        cloneStaff(clonesTable, highest.staff);
        assignStaff(clonesTable, new ArrayList<Employee>(), highest);
        return clonesTable.get(this);
    }

    private void cloneStaff(HashMap<Employee, Employee> clonesTable, Employee[] emp_staff) {
        for (int i = 0; i < emp_staff.length; i++) {
            if (!clonesTable.containsKey(emp_staff[i])) {
                Employee clone;
                Employee supervisorClone = null;
                if (emp_staff[i].supervisor != null) {
                    supervisorClone = clonesTable.containsKey(emp_staff[i].supervisor) ? clonesTable.get(emp_staff[i].supervisor) : new Employee(emp_staff[i].supervisor.id, emp_staff[i].supervisor.name, null, null);
                }
                clone = new Employee(emp_staff[i].id, emp_staff[i].name, supervisorClone, new Employee[0]);
                clonesTable.put(emp_staff[i], clone);
                cloneStaff(clonesTable, emp_staff[i].staff);
                if (emp_staff[i].supervisor != null && !clonesTable.containsKey(emp_staff[i].supervisor)) {
                    clonesTable.put(emp_staff[i].supervisor, supervisorClone);
                    cloneStaff(clonesTable, emp_staff[i].supervisor.staff);
                }
            }
        }
    }

    private void assignStaff(HashMap<Employee, Employee> clonesTable, List<Employee> completedStaff, Employee employee) {
        if (employee == null || completedStaff.contains(employee)) {
            return;
        }
        Employee cloneStaff[] = new Employee[employee.staff.length];
        for (int i = 0; i < employee.staff.length; i++) {
            cloneStaff[i] = clonesTable.get(employee.staff[i]);
            assignStaff(clonesTable, completedStaff, employee.staff[i]);
        }
        clonesTable.get(employee).setStaff(cloneStaff);
        completedStaff.add(employee);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.name;
    }

}
