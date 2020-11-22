package com.vidvaan.jdbc.acc_holder;

public class Clint {
	public static void main(String[] args) {
		
	
	AccountHolderDetails acdetails = new AccountHolderDetails();
	//acdetails.insert("insert into AccountHolder values(14562587,'Indrani  Reddi',450000)");
	//acdetails.update("update AccountHolder set account_bal=15000 where account_name='Ganesh Raj' ");
	//acdetails.delete("delete from accountholder where account_no=20181069942" );
	acdetails.getAllrecords("select * from accountholder");
	
	}
}
