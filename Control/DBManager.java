/*
-------------------------------------------------

Project: Eventmanagementsystem
Group: Hexterminators

File name: DBManager.java

Created: 1st May 2020

-------------------------------------------------
*/

package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Model.*;
import Control.AccountManager;


public class DBManager {
    
    // Function name: connect()
    // Task: connects to the DB
    public static Connection connect() {
        
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/users/worek/eventmanagement/ribbentrop_molotov.db";
            
            // create a connection to the database via relative address
            conn = DriverManager.getConnection(url);
                    
            } catch (SQLException e ) {
                System.err.print(e.getMessage());
            }
                    
        return conn;      
    }
    
    // Function name: disconnect()
    // Task: disconnects from the DB
    public static Connection disconnect() {
        
        Connection conn = null;
        return conn;
    }

    //main method for DBManager
    public static void main(String[] args) {
        Student playerOne = new Student();
        //DBManager gameOne = new DBManager();
        AccountManager.addUser(playerOne);
    }
}
