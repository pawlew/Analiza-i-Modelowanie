/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author siesiek
 */
public class Database {
    public static Connection getConnection() throws SQLException, IOException{
        String drivers = "com.mysql.jdbc.Driver";
        if(drivers != null){
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = "jdbc:mysql://localhost:3306/poker";
        String username = "root";
        String password = "13luty";
        return DriverManager.getConnection(url, username, password);
    }
}
