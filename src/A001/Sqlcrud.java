package A001;
import java.sql.*;
import java.util.Scanner;

public class Sqlcrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		String sel ;
		int index;//��J1~5���\��
		
		System.out.print("�O�_�i�J�޲z�t�� y/n=");
		sel= key.nextLine();
		
//		System.out.print(sel);
		
		while(true) {

			try {			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
				//jdbc java data base connection:mysql �_�����s���N��	 �s��Ʈw
				////localhost:3306/text������ url �������U������ �������ݬ�text 
				Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");				
				Statement st =con.createStatement();//file open		
				System.out.println("��J0�h�X�t��=");
				System.out.println("��J1�s�W=");
				System.out.println("��J2�d��=");
				System.out.println("��J3�R��=");
				System.out.println("��J4��=");
				System.out.println("�п�J�N��");
				index =key.nextInt();
			
				if(index==0) {
					System.out.print("�w�g�h�X�t��");
					break;
				}
				else if(index==1) {
					System.out.println("�п�J�N�n�s�W���N��");
					String no =key.next();
		            
					System.out.println("��J�Ѳ�����W��");
		            String name = key.next();

		            PreparedStatement ps =con.prepareStatement("insert into ESTOCK(stockno,stockname)Values (?,?)");
					ps.setString(1,no);
					ps.setString(2, name);
					int i1 =ps.executeUpdate();
					
					if (i1==0) {
						System.out.print("false");
					}
					else {
						System.out.print("���\");
					}
					
					
				}
				
				else if(index==2) {
					System.out.println("�п�J�N�n�d�ߪ��N��");
					String no = key.next();
					String sql ="SELECT * FROM ESTOCK WHERE stockno = '"+ no + "';"	;
					ResultSet rs = st.executeQuery(sql);//�d�߻y�y �۷��M��
				
				while(rs.next()){
					String no1 =rs.getString("stockno");
					String name =rs.getString(2);
					
					System.out.println(no1+name);
					}
					
				}
				
				
				
				else if(index==3){
						System.out.println("�п�J�n�R�����Ѳ��N��");
						String no = key.next();
						String del ="DELETE FROM  ESTOCK WHERE stockno= ?";
						PreparedStatement ps = con.prepareStatement(del);
						ps.setString(1,no);
						
						int i = ps.executeUpdate();
						if (i==0) {
							System.out.println("�R������");
						}
						else {
							System.out.println("��Ƥw�g�R��");
							
						}		
							
							
						}
				
				else if(index==4){
						System.out.println("�п�J�n��諸�Ѳ��N��");
						String no =key.next();
						System.out.println("�п�J�n��諸�Ѳ��W��");
						String name=key.next();
						
						String sql ="Update ESTOCK set stockname=? WHERE stockno=? ";//�u���󥿤@�����
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, no);
						
				int i2 =ps.executeUpdate();
				
				if(i2==0) {
					System.out.println("�󥿥���");
				}
				else {
					System.out.print("���\");
				}
						
						
		}
				else {
					System.out.print("exit");
					break;
	
		}
			
			      key.nextLine();                   // ��

			      System.out.printf("�O�_�~���J�Ѳ���� (yes/no) =>");

			      sel = key.nextLine();

			
			
			} //�jtry������
				catch(Exception e) {
					System.out.print(e);
				}
				
			
			
			
		}
		
		
		
		
	}

}
