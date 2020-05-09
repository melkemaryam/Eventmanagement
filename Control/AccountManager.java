/*
-------------------------------------------------

Project: Eventmanagementsystem
Group: Hexterminators

File name: AccountManager.java

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

public class AccountManager {

    private static final Logger LOGGER = Logger.getLogger(DBManager.class.getName() );

	private static final DBManager DATABASE = new DBManager();
    
    public AccountManager(){
		//off
		LOGGER.setLevel(Level.ALL);
    }
    
    // Function name: addUser()
    // Task: adds a new user to the DB
    public static void addUser(Student playerOne) {
        String sql = "INSERT INTO Users(FirstName, LastName, Email, UserType, StudentID, password) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DBManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, playerOne.getFirstName());
            pstmt.setString(2, playerOne.getLastName());
            pstmt.setString(3, playerOne.getEmail());
            pstmt.setString(4, playerOne.getRole());
            pstmt.setInt(5, playerOne.getUniId());
            pstmt.setString(6, playerOne.getPassword());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.print("Something went wrong, User was not added to the DB");
        }
        DBManager.disconnect();
    
    }

    // Function name: logIn()
    // Task: logs a user into the system
    public int logIn(Student playerOne) {
        String sql = "SELECT FirstName, LastName, Email, UserType, StudentID FROM Users WHERE UserID =? AND password=?";
        int logInStatus = 0;
        int studentId = playerOne.getStudentId();    
        String password = playerOne.getPassword();
        try (Connection conn = DBManager.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, studentId);
                pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                System.out.println("Combination of this UniversityID and password does not exist");
            }
            else{
                logInStatus = 1;
            }

        }catch (SQLException e) {
            System.err.print("No DB connection");
        }
        DBManager.disconnect();
        return logInStatus;
    }

    // Function name: retrieveUser()
    // Task: method to retrive user information
    public void retrieveUser(Student playerOne) {
        String sql = "SELECT FirstName, LastName, Email, UserType, StudentID FROM Users WHERE UserID =?";
        int studentId = playerOne.getStudentId();

        try (Connection conn = DBManager.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery(sql);

            while (rs.next()){
                playerOne.setUniId(rs.getInt("StudentID"));
                playerOne.setFirstName(rs.getString("FirstName"));
                playerOne.setLastName(rs.getString("LastName"));
                playerOne.setEmail(rs.getString("Email"));
                playerOne.setRole(rs.getString("UserType")); 
            }
        }catch (SQLException e) {
            System.err.print("No such user");
        }
        DBManager.disconnect();
    }





}