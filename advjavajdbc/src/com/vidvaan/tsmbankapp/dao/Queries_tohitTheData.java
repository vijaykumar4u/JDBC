package com.vidvaan.tsmbankapp.dao;

public interface Queries_tohitTheData {
	public static final String retrive_vijay = "Select * from VijayAccount where account_no=?";
	public static final String retrive_ravi = "Select * from raviAccount where account_no=?";
	public static final String update_vijay = "update  VijayAccount set =? where account_no=?";
	public static final String update_ravi = "update  VijayAccount set =? where account_no=?";

}
