
public class EventOrganiser extends Student {

    int studentId;
    int universityId;
    String password;
    String firstName;
    String lastName;
    String email;
    String role; // or int role if every role has a number, e. g. student = 1, etc...


    // Constructor
    public EventOrganiser (int stuId, int uniId, String pass, String first, String last, String mail, String rol) {

        studentId = stuId;
        universityId = uniId;
        password = pass;
        firstName = first;
        lastName = last;
        email = mail;
        role = rol;
        
    }

    public static void main (String [] args) {


    }

}