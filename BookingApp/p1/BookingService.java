package p1;

import java.util.List;

public interface BookingService {
	
	public Ticket doBookTickect(int count)throws TicketCountException;
	public List<Ticket> showAllTickets();
	public Ticket getDetailsById(int bookingId)throws InvalidBookingId;
}

// in implementation class 
// List<Booking> allBookings;