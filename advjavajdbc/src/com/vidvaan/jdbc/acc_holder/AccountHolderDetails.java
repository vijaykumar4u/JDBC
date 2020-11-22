package com.vidvaan.jdbc.acc_holder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountHolderDetails implements DAODeclartion{
 Connection con= null;
 Statement st=null;
	@Override
	public void insert(String in_query) {
		
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate(in_query);
			System.out.println(result+" row is inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(String update_query) {
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate(update_query);
			System.out.println(result+" row is updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String dele_query) {
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate(dele_query);
			System.out.println(result+" row is deleted");
				
			}
			
			
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	

	@Override
	public void getAllrecords(String sele_query) {
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			ResultSet resultset=st.executeQuery(sele_query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getFloat(3));
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
