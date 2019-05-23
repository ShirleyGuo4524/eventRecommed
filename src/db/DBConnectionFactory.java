package db;

import db.mongodb.MongoDBConnection;
import db.mysql.MySQLConnection;

// factory pattern 
public class DBConnectionFactory {
	// This should change based on the pipeline.
	private static final String DEFAULT_DB = "mysql";
//	private static final String DEFAULT_DB = "mongodb";

	// Create a DBConnection based on given db type.
	public static DBConnection getConnection(String db) {
		switch (db) {
		case "mysql":
			return new MySQLConnection();
		case "mongodb":
			//return MongoDBConnection.getInstance();
			return new MongoDBConnection();
		// You may try other dbs and add them here.
		default:
			throw new IllegalArgumentException("Invalid db " + db);
		}
	}
	
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
	}

}
