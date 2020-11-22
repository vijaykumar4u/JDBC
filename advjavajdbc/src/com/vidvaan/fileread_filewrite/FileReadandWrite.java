package com.vidvaan.fileread_filewrite;

import com.vidvaan.dbconnection.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileReadandWrite {
	Connection connection = null;
	PreparedStatement ps = null;
	FileReader fr = null;
	FileWriter fw = null;

	public void insertFile() throws SQLException, IOException {
		connection = DBConnection.getConnection();
		ps = connection.prepareStatement("insert into Filetable values(?,?)");
		ps.setString(1, "Jdbc File Example");
		File file = new File("D:\\jdbcfileEx1.txt");
		FileReader fr = new FileReader(file);

		ps.setCharacterStream(2, fr, (int) file.length());
		int resut = ps.executeUpdate();
		System.out.println(resut + " file is stored in db");

	}

	public void retriveFile() throws SQLException, IOException {
		connection = DBConnection.getConnection();
		ps = connection.prepareStatement("select * from filetable");
		ResultSet rs=ps.executeQuery();  
		rs.next();//now on 1st row  
		              
		Clob c=rs.getClob(2);  
		Reader r=c.getCharacterStream();              
		              
		ileWriter fw=new FileWriter("D:\\jdbc3.txt");  
		              
		int i;  
		while((i=r.read())!=-1)  
		fw.write((char)i);  

		

	}

	@Override
	protected void finalize() throws Throwable {
		fr.close();
		fw.close();
		DBConnection.closeStatement(ps);

	}

	public static void main(String[] args) throws SQLException, IOException {

		FileReadandWrite fread = new FileReadandWrite();
		// fread.insertFile();
		fread.retriveFile();
	}

}
