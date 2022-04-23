package A001;


import java.io.FileReader;//檔案讀取 io裡面的  / 
import java.io.IOException;//異常處理	
import java.io.Reader;//讀檔
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.csv.CSVFormat;//下載一個模組csv 格式化  A帕契
import org.apache.commons.csv.CSVParser;//csv模組 Parser 解析 csv檔案 相當於read
import org.apache.commons.csv.CSVRecord;//csv 匯出用
import java.sql.*;
public class ReadCsv {
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		String inputFileName = "c:\\java\\股票基本檔.csv";//資料來源檔案
		//Reader reader =new FileReader(inputFileName); 開檔案

		try(Reader reader = new FileReader(inputFileName); //java檔案格式 FileReader 讀文字檔 java文字檔案
				
				//CSVParse解析 csv檔 解碼 這指令只是讀檔案 尚須迴圈
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
		//for each   for(類型 參數 : 原始資料   )
			
			//for(CSVRecord xx : csvParser) xx控制所有檔案 xx.get("欄位")
		//for each用在集合 讀法 類型 參數 素材 類型包括 String int 布林值
			//類型屬於集合型態 有list /map/ json/csv /excel
			for(CSVRecord record : csvParser) {
				String stockno= record.get("證券代號");//解析表頭
				String stockname = record.get("證券名稱");
		
				System.out.println("股票代號 " + stockno + ";" + "股票名稱 " + stockname);				
				
								
//新增語法 list add寫  文字檔用add   json用add  map用put 
				//sql 用set bean用set  get讀出
			}
			
		}	
	}

}