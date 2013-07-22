package parsem;

import java.sql.*;
import java.util.Properties;
import java.sql.DriverManager;

public class DatabaseCon {
	String dbName;
	String userName;
	String userPassword;

	public Connection getConnection() {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.userPassword);

		System.out.print("Sprawdzanie sterownika:");
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Blad przy ladowaniu sterownika bazy!");
			System.exit(1);
		}
		
		if (this.dbms.equals("mysql")) {
			conn = DriverManager.getConnection("jdbc:" + this.dbms + "://"
					+ this.serverName + ":" + this.portNumber + "/",
					connectionProps);
			
		} else if (this.dbms.equals("derby")) {
			conn = DriverManager.getConnection("jdbc:" + this.dbms + ":"
					+ this.dbName + ";create=true", connectionProps);
		}
		
		System.out.println("Connected to database");
		return conn;
	}

}
