package project.framework.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Logger;

import project.framework.interfaces.IDataAccessObject;
import project.framework.utilities.DbConfigKey;
import project.framework.utilities.DbConfigProperties;

class PersistenceManager {
	private static Logger log = Logger.getLogger(ConnectionPool.class.getPackage().getName());
	
	protected String query;
	protected ResultSet resultSet;
	protected IDataAccessObject objectDAO;
	protected ConnectionPool pool;
	private static final Logger LOG = Logger.getLogger(PersistenceManager.class
			.getName());

	PersistenceManager(IDataAccessObject c) throws DatabaseException {
		objectDAO = c;
		pool = getPool();
	}

	void performRead() throws DatabaseException {
		objectDAO.buildQuery();
		ResultSet resultSet = runQuery(pool, objectDAO.getDbUrl(),
				objectDAO.getQuery());

		objectDAO.populateEntity(resultSet);
	}

	Integer performUpdate() throws DatabaseException {
		objectDAO.buildQuery();
		Integer generatedKey = runUpdate(pool, objectDAO.getDbUrl(),
				objectDAO.getQuery());

		return generatedKey;
	}

	void performDelete() throws DatabaseException {
		objectDAO.buildQuery();
		runUpdate(pool, objectDAO.getDbUrl(), objectDAO.getQuery());
	}

	public static ResultSet runQuery(ConnectionPool pool, String dbUrl,
			String query) throws DatabaseException {
		LOG.info("Executing query: " + query);
		Connection con = pool.getConnection(dbUrl);
		ResultSet rs = ConnectionPool.doQuery(con, query);
		return rs;
	}

	protected static ConnectionPool getPool() throws DatabaseException {
		DbConfigProperties props = new DbConfigProperties();
		return ConnectionPool.getInstance(props.getProperty(DbConfigKey.DB_USER
				.getVal()),
				props.getProperty(DbConfigKey.DB_PASSWORD.getVal()), props
						.getProperty(DbConfigKey.DRIVER.getVal()), Integer
						.parseInt(props.getProperty(DbConfigKey.MAX_CONNECTIONS
								.getVal())));

	}

	public static Integer runUpdate(ConnectionPool pool, String dbUrl,
			String query) throws DatabaseException {
		Connection con = pool.getConnection(dbUrl);
		log.info("Query : " + query);
		Integer generatedKey = ConnectionPool.doUpdate(con, query);
		return generatedKey;
	}

}
