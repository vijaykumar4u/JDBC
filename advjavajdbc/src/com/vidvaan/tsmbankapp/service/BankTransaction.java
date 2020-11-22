package com.vidvaan.tsmbankapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vidvaan.tsmbankapp.dao.*;
import com.vidvaan.batchprocess.*;
import com.vidvaan.dbconnection.DBConnection;
public class BankTransaction {
	Connection connection = null;
	PreparedStatement ps=null;
	public void amountfrom_VijayToRavi() {
		connection = DBConnection.getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps=connection.prepareStatement(Queries_tohitTheData.retrive_vijay);
		ResultSet vijay_bal=	ps.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
