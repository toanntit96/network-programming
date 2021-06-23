/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Cold
 */
public class ClassConnect {
    ConnectDB a ;
    Connection conn;
    public  ClassConnect()
    {}
     public boolean checkuser(String user, String pass)
      {
         
       
          try 
              {
                 
                 a = new ConnectDB();
              try (Connection conn = a.getConnection()) {
                  Statement st = conn.createStatement();
                 
                  ResultSet RS = st.executeQuery("SELECT COUNT(*) AS total FROM nguoidung "
                          + "where taikhoan ='"+user+"' and matkhau ='"+pass+"'");
                  while (RS.next()) {
                      if( RS.getInt("total") > 0 ) 
                        return true;
                    
                      
                  }
                  conn.close();
              }
      }catch(SQLException e)
      {
          
      }    
          return false;
      }
    
     
     public String loadtennd(String c)
     {
         String msg="";;
         try {
              ConnectDB a = new ConnectDB();
            Connection conn= a.getConnection();
            int number;
          
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery("select tennguoidung from nguoidung where taikhoan='"+c+"'");
            ResultSetMetaData metadata= rs.getMetaData();
            number=  metadata.getColumnCount();//tra ve so cot
            
           
            while (rs.next())
            {
               
                for (int i=1;i<=number;i++)
                {   
               
                     msg = msg +rs.getString(i);
                }
                
            }
             
         conn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
     
         return msg;
         
     }
     public String loadtien(String c)
     {
         String msg="";;
         try {
              ConnectDB a = new ConnectDB();
            Connection conn= a.getConnection();
            int number;
          
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery("select sotien1 from nguoidung where taikhoan='"+c+"'");
            ResultSetMetaData metadata= rs.getMetaData();
            number=  metadata.getColumnCount();//tra ve so cot
            
           
            while (rs.next())
            {
               
                for (int i=1;i<=number;i++)
                {   
               
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
     
       public boolean updateDB (String c, String n)
     {
         
      
            int  st= Integer.parseUnsignedInt(c);
    
     try {
            
            ConnectDB a = new ConnectDB();
            Connection conn= a.getConnection();
            PreparedStatement comm = conn.prepareStatement("update nguoidung set sotien1=sotien1-? where taikhoan=? ");
           
            comm.setString(2,n);
            comm.setInt(1,st);
            int j=comm.executeUpdate();
          if(j>0)
         return true;
        } catch (Exception e) {
        }
     return false;
     }
       public boolean chuyentien (String ng, String nn,String st)
     {
          
     
          int sotien=0;
          sotien= Integer.parseUnsignedInt(st);
     try {
            
            ConnectDB a = new ConnectDB();
            Connection conn= a.getConnection();
            //trừ tiền
            PreparedStatement comm = conn.prepareStatement("update nguoidung set sotien1=sotien1-? where taikhoan=? ");
               comm.setString(2,ng);
               comm.setInt(1,sotien);
               comm.executeUpdate();
            //chuyển tiền
               PreparedStatement comm1 = conn.prepareStatement("update nguoidung set sotien1=sotien1+? where taikhoan=? ");
               comm1.setString(2,nn);
               comm1.setInt(1,sotien);
              
               int kt=comm1.executeUpdate();
               if(kt>0)
               return true;
               
             
               
          
           
        } catch (Exception e) {
        }
     return false;
     }
     
     
     
       public static void main(String[] args) {
        
     
      
           
    }
}
