
package chatjoinsv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Cold
 */
public class ClassConnect {
    ConnectDB a ;
    Connection conn;
    public  ClassConnect()
    {}
     public String checkuser(String user, String pass)
      {
          String status=null;
       
          try 
              {
                 
                 a = new ConnectDB();
              try (Connection conn = a.getConnection()) {
                  Statement st = conn.createStatement();
                  //  String st1="SELECT COUNT(*) AS total FROM users "
                  //      + "where username ='"+user+"' and password ='"+pass+"'";
                  //    JOptionPane.showMessageDialog(null, st1);
                  ResultSet RS = st.executeQuery("SELECT COUNT(*) AS total FROM users "
                          + "where username ='"+user+"' and password ='"+pass+"'");
                  while (RS.next()) {
                      if( RS.getInt("total") > 0 ) {
                          status="có";
                      } else {
                          status="không";
                      }
                      
                  }
                  conn.close();
              }
      }catch(SQLException e)
      {
          
      }    
          return status;
      }
     public void updateDB (String User,String room,String msg)
     {
          
           
        try {

              a = new ConnectDB();
            Connection conn= a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into RoomPublic1 values(?,?,?,?)");
            ps.setString(1,room);
             ps.setString(2,msg);
              ps.setString(3,User);
              DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
              Calendar cal = Calendar.getInstance();
              String st= "" +dateFormat.format(cal.getTime());
             
               ps.setString(4,st);
          
              int chk=ps.executeUpdate();
                if(chk>0)
                {
                  ///  JOptionPane.showMessageDialog(null,"thêm thành công");
                   
                }
                else ;///JOptionPane.showMessageDialog(null,"thêm thất bại");
                    
                       
        } catch (SQLException e) {
        }
     }
     
     
     public String loadmsg()
     {
         String msg="";;
         try {
              ConnectDB a = new ConnectDB();
            Connection conn= a.getConnection();
            int number;
          
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery("select iduser,textmsg from RoomPublic1");
            ResultSetMetaData metadata= rs.getMetaData();
            number=  metadata.getColumnCount();//tra ve so cot
            
           
            while (rs.next())
            {
               
                for (int i=1;i<=number;i++)
                {   if(i==1)
                {
                    msg = msg +rs.getString(i)+": ";
                }
                else
                     msg = msg +rs.getString(i);
                }
                
            }
             
        // conn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
       //  JOptionPane.showMessageDialog(null, msg);
         return msg;
         
     }
       public static void main(String[] args) {
        
     
      
           
    }
}

