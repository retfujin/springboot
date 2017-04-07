package com.zkbr.mystudy.jspservletjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	private static Connection connection = null;
	public  static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				String url = "jdbc:mysql://localhost/sanatoriumdb";
				String user = "root";
				String password = "Passw0rd";
				String driver = "org.gjt.mm.mysql.Driver";
				
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				DbInit.initDB(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return connection;
		}
	}
}