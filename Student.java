public class Student {

    int studentId;
    int universityId;
    String password;
    String firstName;
    String lastName;
    String email;
    String role; // same as in EventOrganiser

    //Constructor
    public Student (int stuId, int uniId, String pass, String first, String last, String mail, String rol) {

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