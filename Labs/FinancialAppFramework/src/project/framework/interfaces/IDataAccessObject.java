
package project.framework.interfaces;

import java.sql.ResultSet;

import project.framework.persistence.DatabaseException;

public interface IDataAccessObject {
    public void buildQuery() throws DatabaseException ;
    public void populateEntity(ResultSet resultSet) throws DatabaseException ;
    public String getDbUrl();
    public String getQuery();
}
