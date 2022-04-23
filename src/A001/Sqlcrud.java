package A001;
import java.sql.*;
import java.util.Scanner;

public class Sqlcrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		String sel ;
		int index;//¿é¤J1~5ªº¥\¯à
		
		System.out.print("¬O§_¶i¤JºÞ²z¨t²Î y/n=");
		sel= key.nextLine();
		
//		System.out.print(sel);
		
		while(true) {

			try {			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
				//jdbc java data base connection:mysql «_¸¹¬°³sªº·N«ä	 ³s¸ê®Æ®w
				////localhost:3306/text¬°ºô°ì url ºô¸ôµù¥Uªººô¯¸ ºô¸ô¶³ºÝ¬°text 
				Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");				
				Statement st =con.createStatement();//file open		
				System.out.println("¿é¤J0°h¥X¨t²Î=");
				System.out.println("¿é¤J1·s¼W=");
				System.out.println("¿é¤J2¬d¸ß=");
				System.out.println("¿é¤J3§R°£=");
				System.out.println("¿é¤J4§ó¥¿=");
				System.out.println("½Ð¿é¤J¥N¸¹");
				index =key.nextInt();
			
				if(index==0) {
					System.out.print("¤w¸g°h¥X¨t²Î");
					break;
				}
				else if(index==1) {
					System.out.println("½Ð¿é¤J±N­n·s¼Wªº¥N¸¹");
					String no =key.next();
		            
					System.out.println("¿é¤JªÑ²¼¤¤¤å¦WºÙ");
		            String name = key.next();

		            PreparedStatement ps =con.prepareStatement("insert into ESTOCK(stockno,stockname)Values (?,?)");
					ps.setString(1,no);
					ps.setString(2, name);
					int i1 =ps.executeUpdate();
					
					if (i1==0) {
						System.out.print("false");
					}
					else {
						System.out.print("¦¨¥\");
					}
					
					
				}
				
				else if(index==2) {
					System.out.println("½Ð¿é¤J±N­n¬d¸ßªº¥N¸¹");
					String no = key.next();
					String sql ="SELECT * FROM ESTOCK WHERE stockno = '"+ no + "';"	;
					ResultSet rs = st.executeQuery(sql);//¬d¸ß»y¥y ¬Û·í©ó¹M¾ú
				
				while(rs.next()){
					String no1 =rs.getString("stockno");
					String name =rs.getString(2);
					
					System.out.println(no1+name);
					}
					
				}
				
				
				
				else if(index==3){
						System.out.println("½Ð¿é¤J­n§R°£ªºªÑ²¼¥N¸¹");
						String no = key.next();
						String del ="DELETE FROM  ESTOCK WHERE stockno= ?";
						PreparedStatement ps = con.prepareStatement(del);
						ps.setString(1,no);
						
						int i = ps.executeUpdate();
						if (i==0) {
							System.out.println("§R°£¥¢±Ñ");
						}
						else {
							System.out.println("¸ê®Æ¤w¸g§R°£");
							
						}		
							
							
						}
				
				else if(index==4){
						System.out.println("½Ð¿é¤J­n§ó§ïªºªÑ²¼¥N¸¹");
						String no =key.next();
						System.out.println("½Ð¿é¤J­n§ó§ïªºªÑ²¼¦WºÙ");
						String name=key.next();
						
						String sql ="Update ESTOCK set stockname=? WHERE stockno=? ";//¥uÅý§ó¥¿¤@­ÓÄæ¦ì
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, no);
						
				int i2 =ps.executeUpdate();
				
				if(i2==0) {
					System.out.println("§ó¥¿¥¢±Ñ");
				}
				else {
					System.out.print("¦¨¥\");
				}
						
						
		}
				else {
					System.out.print("exit");
					break;
	
		}
			
			      key.nextLine();                   // …¥

			      System.out.printf("¬O§_Ä~Äò¿é¤JªÑ²¼¸ê®Æ (yes/no) =>");

			      sel = key.nextLine();

			
			
			} //¤jtryªºµ²§ô
				catch(Exception e) {
					System.out.print(e);
				}
				
			
			
			
		}
		
		
		
		
	}

}
