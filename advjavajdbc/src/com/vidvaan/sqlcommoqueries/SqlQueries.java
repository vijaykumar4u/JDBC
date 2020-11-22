package com.vidvaan.sqlcommoqueries;

public interface SqlQueries {

	public static final String INSERT_QUERY="insert into student values(?,?,?)";
			public static final String UPDATE_QUERY="update student set sname=? where s_id=?";
			public static final String DELETE_QUERY="delete from student where s_id=?";
			public static final String RETRIVE_QUERY="select * from student";
			
}
