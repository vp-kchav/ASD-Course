
package project.framework.persistence;

import project.framework.interfaces.IDataAccessObject;

public interface IPersistenceSubsystem {
	public void startTransaction() throws DatabaseException;
	public void commit() throws DatabaseException;
	public void rollback() throws DatabaseException;
	public Integer saveWithinTransaction(IDataAccessObject dbClass) throws DatabaseException;
	public Integer deleteWithinTransaction(IDataAccessObject dbClass) throws DatabaseException;
	public void atomicRead(IDataAccessObject dbClass) throws DatabaseException;
	
}
