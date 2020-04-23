
public class Events {


    int eventId;
    String eventName;
    String description;
    String category;
    int date;
    int time;
    String location;
    int roomNumber;
    String place;
    boolean bookingRequired;

    //Constructor
    public Events(int eveId, String eveName, String desc, String cat, int dat, int tim, String loc, int roomNo, String pla, boolean bookReq){

        eventId = eveId;
        eventName = eveName;
        description = desc;
        category = cat;
        date = dat;
        time = tim;
        location = loc;
        roomNumber = roomNo;
        place = pla;
        bookingRequired = bookReq;
    }

    public static void main (String[] args){}
    
}