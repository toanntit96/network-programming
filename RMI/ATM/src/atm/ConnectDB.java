/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;



import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Cold
 */
public class ConnectDB {
    public Connection getConnection()
    {
        Connection conn=null;
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1189;" +  
	         "databaseName=ATM;user=sa;password=14004112");
           if(conn !=null)
           {
               System.err.println("kết nối thành công");
           }
        }catch(Exception ex)
        {
            System.err.println(ex.toString());
        }
        return conn;
    }
}
