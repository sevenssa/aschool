package A001;
import java.sql.*;
import java.util.Scanner;

public class Sqlcrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		String sel ;
		int index;//輸入1~5的功能
		
		System.out.print("是否進入管理系統 y/n=");
		sel= key.nextLine();
		
//		System.out.print(sel);
		
		while(true) {

			try {			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
				//jdbc java data base connection:mysql 冒號為連的意思	 連資料庫
				////localhost:3306/text為網域 url 網路註冊的網站 網路雲端為text 
				Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");				
				Statement st =con.createStatement();//file open		
				System.out.println("輸入0退出系統=");
				System.out.println("輸入1新增=");
				System.out.println("輸入2查詢=");
				System.out.println("輸入3刪除=");
				System.out.println("輸入4更正=");
				System.out.println("請輸入代號");
				index =key.nextInt();
			
				if(index==0) {
					System.out.print("已經退出系統");
					break;
				}
				else if(index==1) {
					System.out.println("請輸入將要新增的代號");
					String no =key.next();
		            
					System.out.println("輸入股票中文名稱");
		            String name = key.next();

		            PreparedStatement ps =con.prepareStatement("insert into ESTOCK(stockno,stockname)Values (?,?)");
					ps.setString(1,no);
					ps.setString(2, name);
					int i1 =ps.executeUpdate();
					
					if (i1==0) {
						System.out.print("false");
					}
					else {
						System.out.print("成功");
					}
					
					
				}
				
				else if(index==2) {
					System.out.println("請輸入將要查詢的代號");
					String no = key.next();
					String sql ="SELECT * FROM ESTOCK WHERE stockno = '"+ no + "';"	;
					ResultSet rs = st.executeQuery(sql);//查詢語句 相當於遍歷
				
				while(rs.next()){
					String no1 =rs.getString("stockno");
					String name =rs.getString(2);
					
					System.out.println(no1+name);
					}
					
				}
				
				
				
				else if(index==3){
						System.out.println("請輸入要刪除的股票代號");
						String no = key.next();
						String del ="DELETE FROM  ESTOCK WHERE stockno= ?";
						PreparedStatement ps = con.prepareStatement(del);
						ps.setString(1,no);
						
						int i = ps.executeUpdate();
						if (i==0) {
							System.out.println("刪除失敗");
						}
						else {
							System.out.println("資料已經刪除");
							
						}		
							
							
						}
				
				else if(index==4){
						System.out.println("請輸入要更改的股票代號");
						String no =key.next();
						System.out.println("請輸入要更改的股票名稱");
						String name=key.next();
						
						String sql ="Update ESTOCK set stockname=? WHERE stockno=? ";//只讓更正一個欄位
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, no);
						
				int i2 =ps.executeUpdate();
				
				if(i2==0) {
					System.out.println("更正失敗");
				}
				else {
					System.out.print("成功");
				}
						
						
		}
				else {
					System.out.print("exit");
					break;
	
		}
			
			      key.nextLine();                   // ??

			      System.out.printf("是否繼續輸入股票資料 (yes/no) =>");

			      sel = key.nextLine();

			
			
			} //大try的結束
				catch(Exception e) {
					System.out.print(e);
				}
				
			
			
			
		}
		
		
		
		
	}

}
