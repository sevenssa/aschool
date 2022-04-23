package A001;

	import java.io.FileReader; //Ū�ɮ�
	import java.io.IOException;
	import java.io.Reader;
	
	import org.apache.commons.csv.CSVFormat;//�榡��
	import org.apache.commons.csv.CSVParser;//�ѪRCSV
	import org.apache.commons.csv.CSVRecord;//Ū����ɮץ� for each ����
	import java.sql.*;
	
	public class CsvtoSql {
	public static void main(String[] args) throws IOException {
	
		try { 
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //jdbc���U��k
		  Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
		
		  
		  Statement st = con.createStatement();//�ŧi�gsql 
	//	  ResultSet rs = st.executeQuery("select * from ESTOCK");//�d�� Ū���y�k
		  //�W�����q�򥻸�� https://data.gov.tw/dataset/18419

		  String inputFileName = "c:\\java\\�Ѳ�����.csv";//�פJ�ɮ�

		  try(Reader reader = new FileReader(inputFileName);//Ū��csv �g�Jsql 
					CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
				
			  for(CSVRecord record : csvParser) {
					String stockno = record.get("�Ҩ�N��");				 		
					String stockname = record.get("�Ҩ�W��");		
					
					//�CŪ�@�� csv  insert sql�@�� �P�ɦs��sql �妸�s�W
					//�~����ƥΧ妸 
				
					String qryInsert = "INSERT INTO ESTOCK values(?,?)"  ;//�ʺASQL���O ������
					
				 	//�@���Statement �Φb�d��    �Y�O�n�s�W�� ��PreparedStatement
				 	PreparedStatement pstmt= con.prepareStatement(qryInsert);//�]���Oinsert�ҥH��PreparedStatement�ӱ�
					pstmt.setString(1,stockno);	//����1			 
					pstmt.setString(2,stockname);//����2		
					pstmt.execute();//����
								
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

	 

