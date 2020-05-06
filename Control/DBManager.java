package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBManager {
    
    public Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/users/worek/eventmanagement/ribbentrop_molotov.db";
            // create a connection to the database via relative address
            conn = DriverManager.getConnection(url);
            
            System.out.println("Good job at connecting mate");
                    
            } catch (SQLException e ) {
                if (conn != null) {
                    System.err.print(e.getMessage());
                    }
                }
                    
        return conn;
           
    }
    

    public void disconnect() {
        Connection conn = null;
        try{
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void retrieveUser() {
        String sql = "SELECT UserID, FirstName, LastName, Email, UserType, PostCode, Address, StudentID FROM Users";
        
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                System.out.println(rs.getInt("UserID") + "\t" +
                                    rs.getString("FirstName") + "\t" +
                                    rs.getString("LastName") + "\t" +
                                    rs.getString("Email") + "\t" +
                                    rs.getInt("UserType") + "\t" +
                                    rs.getString("PostCode") + "\t" +
                                    rs.getString("Address") + "\t" +
                                    rs.getInt("StudentID"));
            }
        }catch (SQLException e) {
            System.err.print("No such user");
        }
    }

    public void addUser(String FirstName, String LastName, String Email, int UserType, String PostCode, String Address, int StudentID) {
        String sql = "INSERT INTO Users(FirstName, LastName, Email, UserType, PostCode, Address, StudentID) VALUES (?,?,?,?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, FirstName);
            pstmt.setString(2, LastName);
            pstmt.setString(3, Email);
            pstmt.setInt(4, UserType);
            pstmt.setString(5, PostCode);
            pstmt.setString(6, Address);
            pstmt.setInt(7, StudentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Something went wrong, user was not added to the DB");
        }
    
    }
    public static void main(String[] args) {
        DBManager run = new DBManager();
        String FirstName = "Piotr";
        String LastName = "Worek";
        String Email = "p.woroszyllo";
        int UserType = 2;
        String PostCode = "LUBIEPLACKI";
        String Address = "Zadupie gorne";
        int StudentID = 123;
        run.addUser(FirstName, LastName, Email, UserType, PostCode, Address, StudentID);
        
    }
}
