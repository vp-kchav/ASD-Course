package project.framework;

import java.sql.ResultSet;

import project.framework.interfaces.IDataAccessObject;
import project.framework.persistence.DatabaseException;

class DataAccessObject implements IDataAccessObject{

	@Override
	public void buildQuery() throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateEntity(ResultSet resultSet) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDbUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
}