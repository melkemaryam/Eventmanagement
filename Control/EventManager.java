/*
-------------------------------------------------

Project: Eventmanagementsystem
Group: Hexterminators

File name: EventManager.java

Created: 1st May 2020

-------------------------------------------------
*/

package Control;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Model.*;
import Control.DBManager;

public class EventManager {

    // Function name: getRoomList()
    // Task: returns a list of room information
    public void getRoomList() {
        String sql = "SELECT RoomID, RoomNo, Size FROM Rooms";
        
        try (Connection conn = DBManager.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                System.out.println(rs.getInt("RoomID") + "\t" +
                                    rs.getInt("RoomNo") + "\t" +
                                    rs.getInt("Size"));
            }
        }catch (SQLException e) {
            System.err.print("Problem with DB connection");
        }
        DBManager.disconnect();
    }

    // Function name: addRoom()
    // Task: adds a new room to the DB
    public void addRoom(String Address, int RoomNo, int Size) {
        String sql = "INSERT INTO Users(Address, RoomNo, Size) VALUES (?,?,?)";
        
        try (Connection conn = DBManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, RoomNo);
            pstmt.setInt(2, Size);
            pstmt.setString(3, Address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Something went wrong, Room was not added to the DB");
        }
        DBManager.disconnect();
    
    }

}