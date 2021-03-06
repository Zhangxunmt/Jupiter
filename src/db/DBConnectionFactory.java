package db;

import db.mysql.MySQLConnection;

public class DBConnectionFactory {
	// This should change based on the pipeline.
	private static final String DEFAULT_DB = "mysql";
	
	public static DBConnection getConnection(String db) throws IllegalArgumentException {
		switch (db) {
		case "mysql":
			return new MySQLConnection();
		case "mongodb" :
			return null; // new MongoDBConnection();
		case "bigtable":
			return null; // new BigTableConnection();
		default:
			throw new IllegalArgumentException("Invalid db:" + db);
		}
	}
	
	public static DBConnection getConnection() throws IllegalArgumentException {
		return getConnection(DEFAULT_DB);
	}
}
