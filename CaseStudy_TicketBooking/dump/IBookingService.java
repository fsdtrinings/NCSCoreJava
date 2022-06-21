package dump;

import java.util.List;

public interface IBookingService {
	
	
	
	public Ticket doBookTickect(int count)throws TicketCountException;
	public List<Ticket> showAllTickets();
	public Ticket getDetailsById(int bookingId)throws InvalidBookingId;
}

// in implementation class 
// List<Booking> allBookings;
