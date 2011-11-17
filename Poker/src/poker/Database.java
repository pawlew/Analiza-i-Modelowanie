/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siesiek
 */
public class Database {
    private static Connection connection;
    
    public static void connect() throws SQLException, IOException{
        String drivers = "com.mysql.jdbc.Driver";
        if(drivers != null){
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = "jdbc:mysql://localhost:3306/poker";
        String username = "root";
        String password = "13luty";
        connection = DriverManager.getConnection(url, username, password);
//        return DriverManager.getConnection(url, username, password);
    }
    
    public static Connection getConnection(){
        if(connection == null){
            try {
                connect();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
    
}
