package p1;

import java.util.Map;

public class Ticket {
	private int bookingId;
	private int seatBooked; // number of seats to be booked
	Map<Integer,String> audianceName; // <seatNumber,AudianceName>

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public int getSeatBooked() {
        return seatBooked;
    }
    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }
    public Map<Integer, String> getAudianceName() {
        return audianceName;
    }
    public void setAuidanceName(Map<Integer, String> auidanceName) {
        this.audianceName = auidanceName;
    }

    
	
}