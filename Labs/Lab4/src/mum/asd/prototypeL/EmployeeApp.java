/**
 * 
 */
package  mum.asd.prototypeL;

/**
 * @author luatnguyen
 *
 */
public class EmployeeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee supervisor = new Employee();
		supervisor.setCity("Toms River");
		supervisor.setLastname("Nguyen");
		supervisor.setFirstname("Tran Gia Han");
		supervisor.setStreetAddress("1102 S Belairc blvd");
		supervisor.setState("NJ");
		supervisor.setZipcode("08753");
		
		Employee staff1 = new Employee();
		staff1.setCity("Toms River");
		staff1.setLastname("Vu");
		staff1.setFirstname("Andy");
		staff1.setStreetAddress("1102 S Belairc blvd");
		staff1.setState("NJ");
		staff1.setZipcode("08753");
		staff1.setSupervisor(supervisor);
		
		Employee staff2 = new Employee();
		staff2.setCity("Toms River");
		staff2.setLastname("Vu");
		staff2.setFirstname("Thinh");
		staff2.setStreetAddress("1102 S Belairc blvd");
		staff2.setState("NJ");
		staff2.setZipcode("08753");
		
		
		
		Employee orgEmp = new Employee();
		orgEmp.setCity("Fairfield");
		orgEmp.setLastname("Nguyen");
		orgEmp.setFirstname("Van Gia Luat");
		orgEmp.setStreetAddress("1302 S Maint st");
		orgEmp.setState("IA");
		orgEmp.setZipcode("52556");
		orgEmp.setSupervisor(supervisor);
		orgEmp.setStaff(new Employee[] {staff1, staff2, supervisor});
		
		supervisor.setSupervisor(orgEmp);
		System.out.println(orgEmp);
		Employee cloneEmp = (Employee)orgEmp.clone();
		System.out.println(cloneEmp);
		
	}

}
