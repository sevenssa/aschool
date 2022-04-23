package A001;
import java.sql.*;


import java.io.BufferedWriter;//佔存區
import java.io.File;//open檔案
import java.io.FileNotFoundException;//檔案異常
import java.io.FileWriter;//檔案寫入
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqltocsv {

	 public static void main(String[] args)throws FileNotFoundException,IOException {
		 try {          
	           
		     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		     Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
		     Statement st  = con.createStatement();  
		     ResultSet rs = null;
	         ResultSetMetaData rsmeta = null;   //表頭
	         
             File file = new File("c:\\java\\stock0405.csv"); //檔案寫法
	            //FileReader fr = new FileReader("C:\\java\\stockname.csv"); 
	           //   讀功能
	           BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //暫存語法
	          
	           rs = st.executeQuery("select * from ESTOCK");// 下達 SQL 命令

	            while (rs.next()) {       // 擷取下一筆紀錄
	                  //讀SQL寫一筆csv
	             writer.write(rs.getString(1) + ","  + rs.getString(2) + "\n") ;	             
	            }
	            System.out.println("成功 csv ");
	            writer.flush();
	            writer.close();
	            writer = null;
	     
	 con.close();       // 關閉資料庫連線
	        }
	              catch (ClassNotFoundException e) {
	            e.printStackTrace();

	        }
	             catch (SQLException e) {
	            e.printStackTrace();
	        }
}
}

