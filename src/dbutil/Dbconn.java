package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconn {
	public static Connection getConnection() throws SQLException{
		Connection Conn = null;
		try{    
		       //����636f7079e79fa5e9819331333361303734MySql��������    
		       Class.forName("com.mysql.cj.jdbc.Driver") ; 
		       //jdbc:mysql:localhost:3306/test?useUnicode=true&characterEncoding=gbk ;
		     String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT" ;     
		      String username = "root";    
		      String password = "123456";
		      Conn = null;  
		      try{    
		        Conn = DriverManager.getConnection(url , username , password ) ;
		        Statement stmt = Conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM schooll") ;
		        System.out.println(rs);
		      } catch(SQLException se){
		       System.out.println("���ݿ�����ʧ�ܣ�");    
		       se.printStackTrace() ;    
		      } 
		      }
		   catch(ClassNotFoundException e){    
		    System.out.println("�Ҳ������������� ����������ʧ�ܣ�");    
		    e.printStackTrace() ;   
		   }     
		return Conn;
	}
}
