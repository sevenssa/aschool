package A001;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;//�ϥΨƥ󥲶����Jevent�M��
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class facea   extends JFrame{   //�w�q MyJframe1 �~�Ӧ�JFrame�������O
      private JPanel contentPane; //�ŧi contentPane ��JPanel���O������,�Ψө�mbt1~bt5���s���e��
      double s,s1,s2 ;           
         
      facea (){           //�غc�l(��)
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�]�w������������ 
           setBounds(100,100,850,200); //������� X Y �y�Ц�m(100,100)�P�e����(450,300)
           contentPane = new JPanel();  //�إ�contentPane ��JPanel���O����  
           setContentPane(contentPane);  //�]�wMyFrame�������e����contentPane
	       contentPane.setLayout(null);  //�]�wcontentPane���󤣨ϥΪ����t�m�޲z��  

           String b = new String("��g�Ѳ��N�X");
         
           JLabel jl=new JLabel(b) ;//�إ߼���
           jl.setBounds(10,10,100,23);
           contentPane.add(jl);
           JTextField txtid = new JTextField(); //�إߪ���W�٬� txtid  �Ѳ��N�X  ����r���                       
	       txtid.setColumns(10); //�ϥ�setColumns()��k �]�w  ����r���e�׬�10                
		   txtid.setBounds(80,10, 100, 23);// �ϥ�setBounds()��k�NtxtCity��XY�b�y�г]��(180,80)�μe����100,25
	       contentPane.add(txtid);

           JLabel    j2=new JLabel("�Ѳ�����X") ;//�إ߼���
           j2.setBounds(10,40,100,23);
           contentPane.add(j2);
           JTextField txtname = new JTextField(); //�إߪ���W�٬� txtid ����r���                       
	       txtname.setColumns(10); //�ϥ�setColumns()��k �]�wtxtCity ����r���e�׬�10   	   
           txtname.setBounds(80,40, 100, 23);// �ϥ�setBounds()��k�NtxtCity��XY�b�y�г]��(180,80)�μe����100,25
	       contentPane.add(txtname);   
     
        JButton bot1 = new JButton("�s�W���");
          bot1.setBounds(330,10,100,23);
          contentPane.add(bot1);   
          bot1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          String sid      = txtid.getText() ;
          String sname    = txtname.getText();
           

          System.out.println(sid);
          Connection c = null;
          Statement stmt = null;
          try {
              
        	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	     Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
        	     //Statement stmt = con.createStatement(); 
                      
                String sql = "INSERT INTO ESTOCK (stockno,stockname) values (?,?)";               
         
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, sid);
                ps.setString(2, sname);              
 	            ps.executeUpdate();   
                       
                JOptionPane.showMessageDialog(null, "�B�z�s�W����"); 
              
 
           
          
          con.close();
          } catch ( Exception e1  ) {
            System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
            System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  



  });

          JButton bot2 = new JButton("�d�߸��");
          bot2.setBounds(500,10,100,23);
          contentPane.add(bot2);   
          bot2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {

          Connection c = null;
          Statement stmt = null;
          try {
        	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     	      Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
     	    	  
 
              stmt = con.createStatement();
              String sid  = txtid.getText() ;                       
         
               ResultSet rs = stmt.executeQuery( "select * from ESTOCK where stockno = '" + sid + "'");
          //                                    "select id from table where id = "+id
        

         if (rs.next()){
              String  name = rs.getString("stockname");
               
             // int sa1  = rs.getInt("salary1");
              txtname.setText(name);
             
             // txtsalary1.setText(rs.getString("sa1"));
          
                    }
         else{
           JOptionPane.showMessageDialog(null, "�d�S�����"); 
                     }


     
      rs.close();
      stmt.close();
      con.close();
    } catch ( Exception e2 ) {
      System.err.println( e2.getClass().getName() + ": " + e2.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  
  });
        //****************updata section ***************************       

          JButton bot3 = new JButton("�󥿸��");
          bot3.setBounds(600,10,100,23);
          contentPane.add(bot3);   
          bot3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          String sid      = txtid.getText() ;
          String sname    = txtname.getText();
         
          
          Statement stmt = null;
          try {
        	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     	      Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
 
              stmt = con.createStatement();           
        	         	  
            
               
          String sql = "Update ESTOCK set stockname =? where stockno ='" + sid + "'";
                     
              PreparedStatement ps = con.prepareStatement(sql);               
              ps.setString(1, sname);                    
              ps.executeUpdate();   
              JOptionPane.showMessageDialog(null, "�B�zupdata����"); 
              stmt.close();
              
              con.close();
          } catch ( Exception e1  ) {
            System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
            System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  

  });

//****************delete section ***************************       

//****************delete section ***************************       

          JButton bot4 = new JButton("�R�����");
          bot4.setBounds(710,10,100,23);
          contentPane.add(bot4);   
          bot4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          String sid      = txtid.getText() ;
         
          Statement stmt = null;
          try {
        	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     	      Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc", "sa", "passw0rd");
 
              stmt = con.createStatement();     
              String sql = "delete from  ESTOCK  where stockno ='" + sid + "'";
              PreparedStatement ps = con.prepareStatement(sql);
                         
 	      ps.executeUpdate();   
                      
              JOptionPane.showMessageDialog(null, "�B�z�R������"); 
              
 
          stmt.close();
           
          con.close();
          } catch ( Exception e1  ) {
            System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
            System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  

  });

 
    
 setTitle("my face ����"); //�]�w���������D��"my face  " 
 setVisible(true);           //���JFrame����
           }
}
//�D�{�� 
//�D�{��

public class screen1023{
	public static void main(String[] args){
		facea  frame = new facea (); //�ϥ�MyJFrame1���O�إ�f���� ���ɧY�����غc�l(�� )    facea  �ðƵ{��
	}
}
