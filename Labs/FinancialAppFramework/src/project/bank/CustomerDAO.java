package project.bank;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IDataAccessObject;
import project.framework.persistence.DatabaseException;
import project.framework.persistence.IPersistenceSubsystem;
import project.framework.persistence.PersistenceSubsystemFacade;
import project.framework.utilities.DbConfigKey;
import project.framework.utilities.DbConfigProperties;

public class CustomerDAO implements IDataAccessObject {
	private IPersistenceSubsystem dataAccessSS = new PersistenceSubsystemFacade();
  private ICustomer customer;
  private String queryType;
  private String query;
  
  Integer custId;
  List<ICustomer> customers;
  private final String SAVE = "Save";
  private final String READ = "Read";
  private final String READ_ALL_CUST = "Readcustomers";
  
  public List<ICustomer> getAllCustomerInfo() throws DatabaseException {
      queryType=READ_ALL_CUST;
      dataAccessSS.atomicRead(this);
      return customers;     
  }
  
  public void saveCustomer(ICustomer customer) throws DatabaseException {
      this.customer = customer;
      queryType = SAVE;
      dataAccessSS.saveWithinTransaction(this);
  }
  
  public void buildQuery() throws DatabaseException {
      if(queryType.equals(SAVE)){
          buildSaveNewCustomer();
      }
//      else if(queryType.equals(READ)){
//          buildReadAllAddressesQuery();
//      }
//    
      else if(queryType.equals(READ_ALL_CUST)){
    	  buildReadAllCustomerQuery();
      }
        }
  //el:
  private void buildReadAllCustomerQuery() {
  	  query = "SELECT * FROM customer";        
	}

  void buildReadCustNameQuery() {
//      query = "SELECT fname, lname " +
//      "FROM Customer " +
//      "WHERE custid = " + customer.getCustId();        
  }
	
  void buildSaveNewCustomer() throws DatabaseException {
      query = "INSERT into customer " +
      		"(customerName, type) " +
      		"VALUES('" +
      				  customer.getName() + "', '" +
      				customer.getCustomerType() + "')";
  }
  
  public String getDbUrl() {
  	DbConfigProperties props = new DbConfigProperties();	
  	return props.getProperty(DbConfigKey.BANK_DB_URL.getVal());
      
  }
  public String getQuery() {
      return query;
      
  }
  
 
  public void populateEntity(ResultSet rs) throws DatabaseException {
      if(queryType.equals(READ)){
//          populateAddressList(rs);
      }		        		
      else if(queryType.equals(READ_ALL_CUST)){
    	  populateAllCustomer(rs);
      }
  }

  //el:
	private void populateAllCustomer(ResultSet rs) {

		try {
			if(rs.next()){
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
//				customer = new Customer(custId, fname, lname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
