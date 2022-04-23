package A001;

	import java.io.FileReader; //讀檔案
	import java.io.IOException;
	import java.io.Reader;
	
	import org.apache.commons.csv.CSVFormat;//格式化
	import org.apache.commons.csv.CSVParser;//解析CSV
	import org.apache.commons.csv.CSVRecord;//讀資料檔案用 for each 類型
	import java.sql.*;
	
	public class CsvtoSql {
	public static void main(String[] args) throws IOException {
	
		try { 
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //jdbc註冊方法
		  Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
		
		  
		  Statement st = con.createStatement();//宣告寫sql 
	//	  ResultSet rs = st.executeQuery("select * from ESTOCK");//查詢 讀取語法
		  //上市公司基本資料 https://data.gov.tw/dataset/18419

		  String inputFileName = "c:\\java\\股票基本檔.csv";//匯入檔案

		  try(Reader reader = new FileReader(inputFileName);//讀取csv 寫入sql 
					CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
				
			  for(CSVRecord record : csvParser) {
					String stockno = record.get("證券代號");				 		
					String stockname = record.get("證券名稱");		
					
					//每讀一筆 csv  insert sql一筆 同時存到sql 批次新增
					//外部資料用批次 
				
					String qryInsert = "INSERT INTO ESTOCK values(?,?)"  ;//動態SQL指令 兩個欄位
					
				 	//一般用Statement 用在查詢    若是要新增更正 用PreparedStatement
				 	PreparedStatement pstmt= con.prepareStatement(qryInsert);//因為是insert所以用PreparedStatement來接
					pstmt.setString(1,stockno);	//放資料1			 
					pstmt.setString(2,stockname);//放資料2		
					pstmt.execute();//執行
								
			    	}//for read csv
			 
		    	}//try csv	exit
	 }//sql try exit
	 catch (ClassNotFoundException e) {
	     e.printStackTrace();
	     }
	  catch (SQLException e) {
			          e.printStackTrace();
	    }  
	}
	}

	 

