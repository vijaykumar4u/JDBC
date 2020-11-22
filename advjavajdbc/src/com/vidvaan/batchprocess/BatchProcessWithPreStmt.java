package com.vidvaan.batchprocess;

import com.vidvaan.sqlcommoqueries.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.vidvaan.dbconnection.DBConnection;

public class BatchProcessWithPreStmt {

	Connection connection = null;
	PreparedStatement insert_ps = null;
	PreparedStatement update_ps = null;
	PreparedStatement delete_ps = null;

	void addBatchQuery() {
		try {
			connection = DBConnection.getConnection();
			insert_ps = connection.prepareStatement(SqlQueries.INSERT_QUERY);
			update_ps = connection.prepareStatement(SqlQueries.UPDATE_QUERY);
			delete_ps = connection.prepareStatement(SqlQueries.DELETE_QUERY);

			insert_ps.setInt(1, 110);
			insert_ps.setString(2, "Srinivasarao");
			insert_ps.setDouble(3, 25000);
			insert_ps.addBatch();

			insert_ps.setInt(1, 111);
			insert_ps.setString(2, "Goku");
			insert_ps.setDouble(3, 1200);
			insert_ps.addBatch();

			insert_ps.setInt(1, 112);
			insert_ps.setString(2, "Vegita");
			insert_ps.setDouble(3, 500);
			insert_ps.addBatch();
			int[] inarr = insert_ps.executeBatch();

			System.out.println(Arrays.toString(inarr));

			update_ps.setString(1, "AksharaTejaSri");
			update_ps.setInt(2, 7);
			update_ps.addBatch();

			update_ps.setString(1, "KumarSastri P");
			update_ps.setInt(2, 12);
			update_ps.addBatch();
			int[] upin = update_ps.executeBatch();

			System.out.println(Arrays.toString(upin));
			delete_ps.setInt(1, 9);
			delete_ps.addBatch();

			delete_ps.setInt(1, 11);
			delete_ps.addBatch();
			int[] deArr = delete_ps.executeBatch();
			System.out.println(Arrays.toString(deArr));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
