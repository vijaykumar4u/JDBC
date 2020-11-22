package com.vidvaan.transactionmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vidvaan.sqlcommoqueries.*;
import com.vidvaan.dbconnection.*;

public class TSMExample {
	Connection connection = null;
	PreparedStatement ps = null;

	void tsmSystem() {
		try {
			connection = DBConnection.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(SqlQueries.INSERT_QUERY);
			ps.setInt(1, 180);
			ps.setString(2, "Krellin");
			ps.setDouble(3, 3000);
			int result = ps.executeUpdate();

			ps = connection.prepareStatement(SqlQueries.UPDATE_QUERY);
			ps.setString(1, "Akashra Reddi");
			ps.setInt(2, 7);
			int re2 = ps.executeUpdate();
			System.out.println(re2);

			ps = connection.prepareStatement("delete from naruto where id_s=220");
			ps.setInt(1, 12);
			int re3 = ps.executeUpdate();
			System.out.println(re3);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("innere");
			}
			System.out.println("exception is occured");
		}
	}
	public static void main(String[] args) {
		
		TSMExample tsm = new TSMExample();
		tsm.tsmSystem();
		
	}
}
