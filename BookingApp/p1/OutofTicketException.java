package p1;

/*Maximum 100 tickets can be sold*/
public class OutofTicketException extends Exception{

    Ticket t;
    public  OutofTicketException(String errorMsg){
        super(errorMsg);
        
    }

}