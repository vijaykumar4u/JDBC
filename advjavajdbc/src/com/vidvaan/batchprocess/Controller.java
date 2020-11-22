package com.vidvaan.batchprocess;

import com.vidvaan.jdbc.studentapp.StudentDAO;

public class Controller {
	public static void main(String[] args) {
		StudentDAO2 sd1 = new StudentDAO2();
		// sd1.insert();
		// sd.update();
		// sd.delete();
		// sd.getAllStudentRecords();
		BatchProcessWithPreStmt bppr = new BatchProcessWithPreStmt();
		bppr.addBatchQuery();

	}

}
