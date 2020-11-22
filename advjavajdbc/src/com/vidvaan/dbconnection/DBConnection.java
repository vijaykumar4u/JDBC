package com.vidvaan.dbconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	static Connection connection = null;
	static Properties properties = null;
	static {

		try {
			properties = new Properties();
			try {
				properties.load(DBConnection.class.getClassLoader()
						.getResourceAsStream("com/vidvaan/jdbc/properties/database.properties"));
				Class.forName(properties.getProperty("oracleDriver"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(properties
					.getProperty("oracleUrl"),properties.getProperty("oracleUsername"),properties.getProperty("oraclePWD"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void closeStatement(Statement st) {
		if (st != null)
			try {
				st.close();
				closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
