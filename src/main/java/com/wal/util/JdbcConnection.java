package com.wal.util;

import java.sql.DriverManager;

import com.mongodb.connection.Connection;

public class JdbcConnection {

	public void accessDatabase() {
		
		String dbUrl = "jdbc:oracle://10.120.100.70:1521/PITQADB1";
		String username = "ebtva_128578_DZ1";
		String password = "ebtva_128578_DZ1";
		//String dbName ="PITQADB1";
		
		//Load jdbc driver		
   	    Class.forName("oracle.jdbc.driver.OracleDriver");
   	    
		// connect to dB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
	}

}
