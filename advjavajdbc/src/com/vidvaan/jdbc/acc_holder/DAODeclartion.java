package com.vidvaan.jdbc.acc_holder;

public interface DAODeclartion {
	void insert(String in_query);
	void update(String update_query);
	void delete(String dele_query);
	void getAllrecords(String sele_query);

}
