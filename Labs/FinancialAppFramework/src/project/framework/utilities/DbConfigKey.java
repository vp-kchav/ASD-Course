package project.framework.utilities;

public enum DbConfigKey {
	FINCO_DB_URL("finco_dburl"), 
	BANK_DB_URL("bank_dburl"), 
	CREDIT_DB_URL("credit_dburl"),
	MAX_CONNECTIONS("max_connections"),
	DB_USER("dbuser"),
	DB_PASSWORD("dbpassword"),
	DRIVER("driver");
	
	private String val;
	private DbConfigKey(String val) {
		this.val = val;
	}
	public String getVal() {
		return val;
	}
}
