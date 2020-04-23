
public class Bookings {

    int bookingId;
    int dateOfBooking;
    String status; // or int status if every status has a number: e.g. 1 = cancelled, etc...

    //Constructor
    public Bookings(int bookId, int dateBook, String stat){

        bookingId = bookId;
        dateOfBooking = dateBook;
        status = stat;
    }

    public static void main (String[] args){

    }
}