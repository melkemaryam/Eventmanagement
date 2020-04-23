
public class Connection {


    int connectionId;
    String hostName;
    String database;
    String username;
    String password;

    //Constructor
    public Connection(int conId, String host, String db, String user, String pass) {

        connectionId = conId;
        hostName = host;
        database = db;
        username = user;
        password = pass;
    }

    public static void main (String [] args) {


    }
}