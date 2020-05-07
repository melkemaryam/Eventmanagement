package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Model.*;


public class DBManager {
    
    public Connection connect() {
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
    

    public Connection disconnect() {
        Connection conn = null;
        return conn;
    }

    public void retrieveUser(Student playerOne) {
        String sql = "SELECT FirstName, LastName, Email, UserType, StudentID FROM Users WHERE UserID =?";
        int studentId = playerOne.getStudentId();

        try (Connection conn = this.connect();
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
        disconnect();
    }

    public int logIn(Student playerOne) {
        String sql = "SELECT FirstName, LastName, Email, UserType, StudentID FROM Users WHERE UserID =? AND password=?";
        int logInStatus = 0;
        int studentId = playerOne.getStudentId();    
        String password = playerOne.getPassword();
        try (Connection conn = this.connect();
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
        disconnect();
        return logInStatus;
    }

    public void getRoomList() {
        String sql = "SELECT RoomID, RoomNo, Size FROM Rooms";
        
        try (Connection conn = this.connect();
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
        disconnect();
    }

    public void addUser(Student playerOne) {
        String sql = "INSERT INTO Users(FirstName, LastName, Email, UserType, StudentID, password) VALUES (?,?,?,?,?,?)";

        try (Connection conn = this.connect();
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
        disconnect();
    
    }

    public void addRoom(String Address, int RoomNo, int Size) {
        String sql = "INSERT INTO Users(Address, RoomNo, Size) VALUES (?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, RoomNo);
            pstmt.setInt(2, Size);
            pstmt.setString(3, Address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Something went wrong, Room was not added to the DB");
        }
        disconnect();
    
    }

    public void addBooking(String EventName, String EventDescription, int EventDate, float StartTime, float EndTime, int UserID, int RoomID, int isNew, int isVisible) {
        String sql = "INSERT INTO Bookings(EventName, EventDescription, EventDate, StartTime, EndTime, UserID, RoomID, isNew, isVisible) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = this.connect();
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
        disconnect();

    }
    public static void main(String[] args) {
        Student playerOne = new Student();
        DBManager gameOne = new DBManager();
        gameOne.addUser(playerOne);
    }
}
