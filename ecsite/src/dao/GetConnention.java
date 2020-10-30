package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnention {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";

	       Connection conn = null;
	       try {

	           Class.forName("com.mysql.jdbc.Driver");
	           conn = DriverManager.getConnection(url, id, pass);

	       } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	       return conn;

	}

}
