package A001;

import java.sql.Connection;//���U�X�ʫ��O con�N��
import java.sql.DriverManager;//��Ʈw�޲z �ŧi
import java.sql.Statement;//�ŧi �ϥ�sql�y�y st�N�� con.st
import java.sql.ResultSet;//rs �d�� �M�� �����ps
import java.sql.ResultSetMetaData;//���Y
import java.sql.SQLException;//����

public class CreatStock {

	public static void main(String[] args) {

        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  // �s�� MySQL/sqlserver �X�ʵ{��
              Statement st = null;//sql�y�y   //����ѼƳ��]�n�b�W��
              ResultSet rs = null;
              ResultSetMetaData rsmeta = null;
              String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";  
              String user = "sa";  // �b�� root
              String password = "passw0rd";   // root �K�X
             
        try {

            Class.forName(driver);

            Connection  conn = DriverManager.getConnection(url, user, password);

// �s����D�� MySQL �� Bank_db ��Ʈw

            System.out.println("���\�s�� test_db ��Ʈw");
            st = conn.createStatement();  // ���� SQL �ԭz����
     
            
            String sql ="CREATE TABLE ESTOCK("  
	                    + "stockno VARCHAR(46) NOT NULL,"
	                                                        
	                    + "stockname  VARCHAR(46))";
            
       st.executeUpdate(sql);
       System.out.println("Created table in given database...");
          //executeQuery SELECT�y�y 
                  
            
            
            

 conn.close();       // ������Ʈw�s�u

        }

              catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

              catch (SQLException e) {

            e.printStackTrace();

        }

}
}
