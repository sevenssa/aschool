package A001;


import java.io.FileReader;//�ɮ�Ū�� io�̭���  / 
import java.io.IOException;//���`�B�z	
import java.io.Reader;//Ū��
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.csv.CSVFormat;//�U���@�ӼҲ�csv �榡��  A����
import org.apache.commons.csv.CSVParser;//csv�Ҳ� Parser �ѪR csv�ɮ� �۷��read
import org.apache.commons.csv.CSVRecord;//csv �ץX��
import java.sql.*;
public class ReadCsv {
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		String inputFileName = "c:\\java\\�Ѳ�����.csv";//��ƨӷ��ɮ�
		//Reader reader =new FileReader(inputFileName); �}�ɮ�

		try(Reader reader = new FileReader(inputFileName); //java�ɮ׮榡 FileReader Ū��r�� java��r�ɮ�
				
				//CSVParse�ѪR csv�� �ѽX �o���O�u�OŪ�ɮ� �|���j��
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
		//for each   for(���� �Ѽ� : ��l���   )
			
			//for(CSVRecord xx : csvParser) xx����Ҧ��ɮ� xx.get("���")
		//for each�Φb���X Ū�k ���� �Ѽ� ���� �����]�A String int ���L��
			//�����ݩ󶰦X���A ��list /map/ json/csv /excel
			for(CSVRecord record : csvParser) {
				String stockno= record.get("�Ҩ�N��");//�ѪR���Y
				String stockname = record.get("�Ҩ�W��");
		
				System.out.println("�Ѳ��N�� " + stockno + ";" + "�Ѳ��W�� " + stockname);				
				
								
//�s�W�y�k list add�g  ��r�ɥ�add   json��add  map��put 
				//sql ��set bean��set  getŪ�X
			}
			
		}	
	}

}