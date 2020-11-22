package com.vidvaan.batchprocess;

import com.vidvaan.dbconnection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO2 implements StudentInterface {

	Connection connection = null;
	Statement statement = null;

	@Override
	public void insert() {

		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			// statement.addBatch("delete from student where s_id =6");
			statement.addBatch("insert into student values(9,'vinay',14500)");
			statement.addBatch("insert into student values(11,'dheeraj',4500)");
			statement.addBatch("insert into student values(12,'Sastri',6500)");
			int[] result = statement.executeBatch();
			
			System.out.println(result + " is inserted");
			DBConnection.closeStatement(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update() {

		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate("update student set sname='Sai Krishna' where s_id=4");
			System.out.println(result + " is updated");
			DBConnection.closeStatement(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate("delete from student where s_id=2");
			System.out.println(result + " is deleted");
			DBConnection.closeStatement(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getAllStudentRecords() {
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("select* from student");
			while (rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getDouble(3));
			}
			DBConnection.closeStatement(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
