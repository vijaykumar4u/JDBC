package com.vidvaan.resultset_metadata;

import java.sql.*;

import oracle.net.aso.r;

public class JdbcExample1 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Vijay_kumar", "seetamma");
			ps = con.prepareStatement("select * from student");
			ResultSet re = ps.executeQuery();
			ResultSetMetaData rmt = re.getMetaData();
			System.out.println(rmt.getColumnCount());
			System.out.println(rmt.getColumnName(1));
			System.out.println(rmt.getColumnTypeName(1));

			System.out.println(rmt.getColumnName(2));
			System.out.println(rmt.getColumnTypeName(2));
			System.out.println(rmt.getColumnName(3));
			System.out.println(rmt.getColumnTypeName(3));

			con.close();
			ps.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
