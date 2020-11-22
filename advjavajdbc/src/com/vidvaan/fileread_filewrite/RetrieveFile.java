package com.vidvaan.fileread_filewrite;
import java.io.*;  
import java.sql.*;  
  import com.vidvaan.dbconnection.*;
public class RetrieveFile {  
public static void main(String[] args) {  
	Connection con = null;
try{  

   con= DBConnection.getConnection();          
PreparedStatement ps=con.prepareStatement("select * from filetable");  
ResultSet rs=ps.executeQuery();  
rs.next();//now on 1st row  
              
Clob c=rs.getClob(2);  
Reader r=c.getCharacterStream();              
              
FileWriter fw=new FileWriter("D:\\retrivefile.txt");  
              
int i;  
while((i=r.read())!=-1)  
fw.write((char)i);  
              
fw.close();  
con.close();  
              
System.out.println("success");  
}catch (Exception e) {e.printStackTrace();  }  
}  
}  