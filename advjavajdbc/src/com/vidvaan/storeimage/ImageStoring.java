package com.vidvaan.storeimage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vidvaan.dbconnection.*;

public class ImageStoring {
	Connection connection = null;
	PreparedStatement ps = null;

	public void insertImage() throws SQLException, IOException {
		connection = DBConnection.getConnection();

		ps = connection.prepareStatement("insert into image values(?,?)");
		ps.setString(1, "Elon Musk");
		FileInputStream finput = new FileInputStream("D:\\elon.jpg");
		ps.setBinaryStream(2, finput, finput.available());
		int result = ps.executeUpdate();
		System.out.println(result + " image is stored to db");

	}

	public void retriveImage() throws SQLException, IOException {
		connection = DBConnection.getConnection();
		ps = connection.prepareStatement("select * from image");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Blob b = rs.getBlob(2);
			byte[] barray = b.getBytes(1, (int) b.length());
			FileOutputStream fout = new FileOutputStream("D:\\elon2.jpg");
			fout.write(barray);
			fout.close();
			DBConnection.closeStatement(ps);
			System.out.println("image retrived");
		}

	}

	public static void main(String[] args) throws SQLException, IOException {

		ImageStoring ist = new ImageStoring();
		// ist.insertImage();
		ist.retriveImage();

	}

}
