
package project.framework.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import project.framework.interfaces.IDataAccessObject;

public class PersistenceSubsystemFacade implements IPersistenceSubsystem {
    
	private static final Logger LOG = Logger.getLogger(PersistenceSubsystemFacade.class.getPackage().getName());
	PersistenceManager action;
	Connection con;
	
	public void createConnection(IDataAccessObject dbClass) throws DatabaseException {
		if(dbClass != null) {
			action = new PersistenceManager(dbClass);
			con = action.pool.getConnection(dbClass.getDbUrl());
		}
	}
	
	
	public void releaseConnection(IDataAccessObject dbClass) {
		action.pool.returnToPool(con, dbClass.getDbUrl());
	}
	
	public void startTransaction() throws DatabaseException {
		try {
			con.setAutoCommit(false);			
		} catch(SQLException e) {
			throw new DatabaseException("DataAccessSubsystemFacade.startTransaction() " + 
				"encountered a SQLException " + e.getMessage());		
		}
	}
	
	
	public void commit() throws DatabaseException {
		try {
			con.commit();
		} catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	public void rollback() throws DatabaseException {
		try {
			con.rollback();		
		} catch(SQLException e) {
			throw new DatabaseException("rollback encountered a SQLException " + e.getMessage());		
		}
	}
	
    public void read() throws DatabaseException {
        action.performRead();
    }
	
    public Integer save() throws DatabaseException  {     
        return action.performUpdate();
    }

   
    public Integer delete() throws DatabaseException  {
        return action.performUpdate();
    }
    
    
	public Integer saveWithinTransaction(IDataAccessObject dbClass) 
			throws DatabaseException {
		createConnection(dbClass);
		startTransaction();
        try {
        	int result = save();
        	commit();
        	return result;
        } catch(DatabaseException e) {
        	LOG.warning("Attempting to rollback...");
        	rollback();
        	throw (e);
        }  finally {
        	releaseConnection(dbClass);
        }
	}
	
	public Integer deleteWithinTransaction(IDataAccessObject dbClass) 
			throws DatabaseException {
		createConnection(dbClass);
		startTransaction();
		int numRows = 0;
        try {
        	numRows = delete();
        	commit();  
        	return numRows;
        } catch(DatabaseException e) {
        	LOG.warning("Attempting to rollback...");
        	rollback();
        	throw (e);
        }  finally {
        	releaseConnection(dbClass);
        }
	}
	

	public void atomicRead(IDataAccessObject dbClass) 
			throws DatabaseException {
		createConnection(dbClass);
		read();
		releaseConnection(dbClass);
	}
	
	}
