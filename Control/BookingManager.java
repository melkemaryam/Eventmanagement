/*
-------------------------------------------------

Project: Eventmanagementsystem
Group: Hexterminators

File name: BookingManager.java

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

public class BookingManager {

    // Function name: addBooking()
    // Task: adds a new booking to the DB
    public void addBooking(String EventName, String EventDescription, int EventDate, float StartTime, float EndTime, int UserID, int RoomID, int isNew, int isVisible) {
        String sql = "INSERT INTO Bookings(EventName, EventDescription, EventDate, StartTime, EndTime, UserID, RoomID, isNew, isVisible) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DBManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, EventName);
            pstmt.setString(2, EventDescription);
            pstmt.setInt(3, EventDate);
            pstmt.setFloat(4, StartTime);
            pstmt.setFloat(5, EndTime);
            pstmt.setInt(6, UserID);
            pstmt.setInt(7, RoomID);
            pstmt.setInt(8, isNew);
            pstmt.setInt(9, isVisible);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Something went wrong, Event was not added to the DB");
        }
        DBManager.disconnect();

    }
}