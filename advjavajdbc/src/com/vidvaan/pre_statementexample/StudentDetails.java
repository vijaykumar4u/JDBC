package com.vidvaan.pre_statementexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vidvaan.jdbc.studentapp.*;

public class StudentDetails extends DBConnection implements DaoDeclaratoion {
	Connection connection = null;
	PreparedStatement ps = null;

	@Override
	public void insert() {

		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SqlQueries.INSERT_QUERY);
			ps.setInt(1, 7);
			ps.setString(2, "Akshara");
			ps.setDouble(3, 5500);
			int result = ps.executeUpdate();
			System.out.println(result + " row is inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update() {
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SqlQueries.UPDATE_QUERY);

			ps.setString(1, "Raju A");
			ps.setInt(2, 5);

			int result = ps.executeUpdate();
			System.out.println(result + " row is updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SqlQueries.DELETE_QUERY);

			ps.setInt(2, 5);

			int result = ps.executeUpdate();
			System.out.println(result + " row is updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getAllStudentRecords() {
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("select * from student");

			ResultSet rset = ps.executeQuery();
			while (rset.next())
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getDouble(3));

			int result = ps.executeUpdate();
			System.out.println(result + " row is updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllRecords() {
List< Student> listofstudents = new ArrayList<Student>();
		try {
			String sel_Query = SqlQueries.RETRIVE_QUERY;
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(sel_Query);
			ResultSet rset = ps.executeQuery();
			while (rset.next()) {
				Student student = new Student();
				student.setSid(rset.getInt(1));
				student.setsName(rset.getString(2));
				student.setFee(rset.getDouble(3));
				listofstudents.add(student);
			}
			for (Student student : listofstudents) {
				System.out.println(student);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listofstudents;
		

	}

	@Override
	public void findById(int id) {
		
		try {
			String sele_query="select* from student where s_id=?";
			connection = DBConnection.getConnection();
			ps=connection.prepareStatement(sele_query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void findByName(String name) {
		try {
			String sele_query="select* from student where sname=?";
			connection = DBConnection.getConnection();
			ps=connection.prepareStatement(sele_query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
