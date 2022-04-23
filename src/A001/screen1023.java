package A001;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;//使用事件必須載入event套件
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class facea   extends JFrame{   //定義 MyJframe1 繼承自JFrame視窗類別
      private JPanel contentPane; //宣告 contentPane 為JPanel類別之物件,用來放置bt1~bt5按鈕之容器
      double s,s1,s2 ;           
         
      facea (){           //建構子(式)
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //設定視窗的關閉紐 
           setBounds(100,100,850,200); //視窗位於 X Y 座標位置(100,100)與寬高為(450,300)
           contentPane = new JPanel();  //建立contentPane 為JPanel類別物件  
           setContentPane(contentPane);  //設定MyFrame視窗的容器為contentPane
	       contentPane.setLayout(null);  //設定contentPane物件不使用版面配置管理者  

           String b = new String("填寫股票代碼");
         
           JLabel jl=new JLabel(b) ;//建立標籤
           jl.setBounds(10,10,100,23);
           contentPane.add(jl);
           JTextField txtid = new JTextField(); //建立物件名稱為 txtid  股票代碼  的文字欄位                       
	       txtid.setColumns(10); //使用setColumns()方法 設定  的文字欄位寬度為10                
		   txtid.setBounds(80,10, 100, 23);// 使用setBounds()方法將txtCity的XY軸座標設為(180,80)及寬高為100,25
	       contentPane.add(txtid);

           JLabel    j2=new JLabel("股票中文碼") ;//建立標籤
           j2.setBounds(10,40,100,23);
           contentPane.add(j2);
           JTextField txtname = new JTextField(); //建立物件名稱為 txtid 的文字欄位                       
	       txtname.setColumns(10); //使用setColumns()方法 設定txtCity 的文字欄位寬度為10   	   
           txtname.setBounds(80,40, 100, 23);// 使用setBounds()方法將txtCity的XY軸座標設為(180,80)及寬高為100,25
	       contentPane.add(txtname);   
     
        JButton bot1 = new JButton("新增資料");
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
                       
                JOptionPane.showMessageDialog(null, "處理新增完成"); 
              
 
           
          
          con.close();
          } catch ( Exception e1  ) {
            System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
            System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  



  });

          JButton bot2 = new JButton("查詢資料");
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
           JOptionPane.showMessageDialog(null, "查沒有資料"); 
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

          JButton bot3 = new JButton("更正資料");
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
              JOptionPane.showMessageDialog(null, "處理updata完成"); 
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

          JButton bot4 = new JButton("刪除資料");
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
                      
              JOptionPane.showMessageDialog(null, "處理刪除完成"); 
              
 
          stmt.close();
           
          con.close();
          } catch ( Exception e1  ) {
            System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
            System.exit(0);
    }
    System.out.println("Records created successfully");
         
    }  

  });

 
    
 setTitle("my face 視窗"); //設定視窗的標題為"my face  " 
 setVisible(true);           //顯示JFrame視窗
           }
}
//主程式 
//主程式

public class screen1023{
	public static void main(String[] args){
		facea  frame = new facea (); //使用MyJFrame1類別建立f物件 此時即刻執行建構子(式 )    facea  螢副程序
	}
}
