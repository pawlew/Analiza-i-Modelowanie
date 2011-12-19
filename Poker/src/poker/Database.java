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

    private static Connection connection;
    private static String username = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/poker";

    public static void connect() throws SQLException, IOException {
        String drivers = "com.mysql.jdbc.Driver";
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        connection = DriverManager.getConnection(url, username, password);
//        return DriverManager.getConnection(url, username, password);
    }

    public static Connection getConnection() {
        try{
            if (connection == null) {
                    connect();
            }
            if(!connection.isValid(0)){
                connect();
            }
        }
        catch (Exception e){}
        return connection;
    }
}
