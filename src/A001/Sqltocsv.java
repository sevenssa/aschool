package A001;
import java.sql.*;


import java.io.BufferedWriter;//���s��
import java.io.File;//open�ɮ�
import java.io.FileNotFoundException;//�ɮײ��`
import java.io.FileWriter;//�ɮ׼g�J
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
	         ResultSetMetaData rsmeta = null;   //���Y
	         
             File file = new File("c:\\java\\stock0405.csv"); //�ɮ׼g�k
	            //FileReader fr = new FileReader("C:\\java\\stockname.csv"); 
	           //   Ū�\��
	           BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //�Ȧs�y�k
	          
	           rs = st.executeQuery("select * from ESTOCK");// �U�F SQL �R�O

	            while (rs.next()) {       // �^���U�@������
	                  //ŪSQL�g�@��csv
	             writer.write(rs.getString(1) + ","  + rs.getString(2) + "\n") ;	             
	            }
	            System.out.println("���\ csv ");
	            writer.flush();
	            writer.close();
	            writer = null;
	     
	 con.close();       // ������Ʈw�s�u
	        }
	              catch (ClassNotFoundException e) {
	            e.printStackTrace();

	        }
	             catch (SQLException e) {
	            e.printStackTrace();
	        }
}
}

