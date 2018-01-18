/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.asd.prototypeprof;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985158
 */
public final class Employee {

    private int id;
//    private String Lastname;
//    private String Firstname;
//    private String streetAddress;
//    private String city;
//    private String state;
//    private String zipcode;
    private Employee supervisor;
    private Employee staff[];

    public void setSupervisor(Employee sv, List<Employee> list){
        supervisor = createEmployee(sv, list);
    }
   
    public void setStaff(Employee[] s, List<Employee> list){
        if(s == null){
            return;
        }
        staff = new Employee[s.length];
        for(int i = 0; i < s.length; i++){
            staff[i] = createEmployee(s[i], list);
        }
    }
    Employee(int id1){
        id = id1;
    }
    Employee isCopiedEmployee(int eid, List<Employee> list){
        for(int i = 0; i < list.size(); i ++){
            Employee e = list.get(i);
            if(e.id == eid){
                return e;
            }
        }
        return null;
    }
    Employee createEmployee(Employee e, List<Employee> list){
        Employee ret = isCopiedEmployee(e.id, list);
        if(ret == null){
            System.out.println("Create employee:"+e.id);
            ret = new Employee(e.id);
            list.add(ret);
            ret.setSupervisor(e.supervisor, list);
            ret.setStaff(e.staff, list);
            return ret;
        }else{
            System.out.println("Already created employee:"+e.id);
            return ret;
        }
    }
    @Override
    protected Employee clone() {
        List<Employee> list = new ArrayList<Employee>();
        Employee ret = createEmployee(this, list); 
        return ret;
    }
    public static void main(String[] args){
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(2);
        Employee e3 = new Employee(3);
        Employee e4 = new Employee(4);
        e1.supervisor = e2;
        e2.supervisor = e3;
        e3.supervisor = e4;
        e4.supervisor = e1;
        e1.staff = new Employee[2];
        e1.staff[0] = e2;
        e1.staff[1] = e3;
        e2.staff = new Employee[2];
        e2.staff[0] = e3;
        e2.staff[1] = e4;
        e3.staff = new Employee[2];
        e3.staff[0] = e2;
        e3.staff[1] = e1;
        
        Employee e5 = e1.clone();
        System.out.println("e5 id:"+e5.id);
        System.out.println("e5 supervisor id:"+e5.supervisor.id);
        System.out.println("e5 staff[0] id:"+e5.staff[0].id);
        System.out.println("e5 staff[1] id:"+e5.staff[1].id);
    }
}
