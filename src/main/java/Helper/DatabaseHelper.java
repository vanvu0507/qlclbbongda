/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String connectionUrl = "jdbc:sqlserver://localhost;database=QLclbbongda";
       String dbusername = "sa";
       String password = "nguyenvanvu2002";
       Connection con = DriverManager.getConnection(connectionUrl, dbusername, password);
       return con;
    }
}
