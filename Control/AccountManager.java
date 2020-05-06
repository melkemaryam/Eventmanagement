package Control;


import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountManager {

    private static final Logger LOGGER = Logger.getLogger(DBManager.class.getName() );

	private static final DBManager DATABASE = new DBManager();	

    private static int id = 0;
    
    public AccountManager(){
		//off
		LOGGER.setLevel(Level.ALL);
    }
    
    public static int logIn(int id, char[] password) {

        return -1;
    }



}