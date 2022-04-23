package A001; 
import java.sql.*;
public class stocksqlread {

	  public static void main(String[] args) {
	  try {
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
		  
		  Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from ESTOCK");
          
          while (rs.next()) {       // 擷取下一筆紀錄
        	  System.out.printf("%s\t", rs.getString(1)); // no欄位內容
        	  System.out.printf("%s\t", rs.getString(2)); // name欄位內容        	  
	                    
              System.out.printf("\n");
              }//while
	
      }//try 
       catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
          catch (SQLException e) {
          e.printStackTrace();
      } 

   }
  }
  

