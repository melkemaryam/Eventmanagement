
public class Connection {

    private static Connection c = null;

    int connectionId;
    String hostName;
    String database;
    String username;
    String password;

    //Constructor
    public Connection(int connectionId, String hostname, String database, String username, String password) {

        this.connectionId = connectionId;
        this.hostName = hostname;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public static void main (String [] args) {


    }
}