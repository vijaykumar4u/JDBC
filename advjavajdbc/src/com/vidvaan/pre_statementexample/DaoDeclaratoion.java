package com.vidvaan.pre_statementexample;

import java.util.List;

public interface DaoDeclaratoion {
	void insert ();
	void update();
	void delete();
	void getAllStudentRecords();
	List<Student> getAllRecords();
	void findById(int id);
	void findByName(String name);
}
