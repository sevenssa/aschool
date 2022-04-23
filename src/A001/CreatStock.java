package A001;

import java.sql.Connection;//註冊驅動指令 con代替
import java.sql.DriverManager;//資料庫管理 宣告
import java.sql.Statement;//宣告 使用sql語句 st代替 con.st
import java.sql.ResultSet;//rs 查詢 遍歷 執行用ps
import java.sql.ResultSetMetaData;//表頭
import java.sql.SQLException;//除錯

public class CreatStock {

	public static void main(String[] args) {

        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  // 連結 MySQL/sqlserver 驅動程式
              Statement st = null;//sql語句   //先把參數都設好在上面
              ResultSet rs = null;
              ResultSetMetaData rsmeta = null;
              String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";  
              String user = "sa";  // 帳戶 root
              String password = "passw0rd";   // root 密碼
             
        try {

            Class.forName(driver);

            Connection  conn = DriverManager.getConnection(url, user, password);

// 連結到主機 MySQL 內 Bank_db 資料庫

            System.out.println("成功連結 test_db 資料庫");
            st = conn.createStatement();  // 產生 SQL 敘述物件
     
            
            String sql ="CREATE TABLE ESTOCK("  
	                    + "stockno VARCHAR(46) NOT NULL,"
	                                                        
	                    + "stockname  VARCHAR(46))";
            
       st.executeUpdate(sql);
       System.out.println("Created table in given database...");
          //executeQuery SELECT語句 
                  
            
            
            

 conn.close();       // 關閉資料庫連線

        }

              catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

              catch (SQLException e) {

            e.printStackTrace();

        }

}
}
