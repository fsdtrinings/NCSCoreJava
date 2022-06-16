package p1;

/* tickets count should not be more than 6 or should not be less than 1*/
public class TicketCountException extends Exception {

    public TicketCountException(String e){
        super(e);
    }

}