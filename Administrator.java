public class Administrator {

    int adminId;
    int universityId; // not sure if needed
    String password;
    String firstName;
    String lastName;
    String email;

    //Constructor
    public Administrator (int adId, int uniId, String pass, String first, String last, String mail) {

        adminId = adId;
        universityId = uniId;
        password = pass;
        firstName = first;
        lastName = last;
        email = mail;
    }

    public static void main (String [] args) {


    }
}