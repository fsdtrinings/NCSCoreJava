package p1;

import java.util.Map;
import java.util.Scanner;

public class BookingApp {

    int ticketCount=100;


     public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter choice:\n1. Buy Tickets\n2. Sell Tickets");

            int choice =sc.nextInt();


            switch(choice) {
                case 1:
                    Boolean t=true;
                    while(t){
                    BookingApp a = new BookingApp();
                   
                    System.out.println("How many tickets to buy:");
                    int buy = sc.nextInt();
                    try {
                        try {
                            t=false;
                            a.buyTicket(buy);
                        } 
                        
                        catch (TicketCountException e) {
        
                            System.out.println(e);
                            t=true;
                        }
                    } 
                    
                    catch (OutofTicketException e) {
                        
                        System.out.println(e);
                    }
                }
                    break;
                
                case 2:
                System.out.println("How many tickets to sell:");
                  break;
                default:
                  // code block
              }
        }
        
    }

    public void buyTicket(int buy)throws OutofTicketException,TicketCountException{
        if(ticketCount<1){
             throw new OutofTicketException("SOLD OUT!");
        }
        else {
            if(buy>6){
                throw new TicketCountException("Buying more than 6 tickets!");
            }
            else{
                for (int i = 0; i < buy; i++) {
                    Ticket t = new Ticket();
                    t.setBookingId(bookingId);
                    
                  }
                System.out.println(buy+" tickets bought");
                System.out.println(ticketCount+" TICKETS LEFT!");
                ticketCount=ticketCount-buy;
                
            }
         }
        
    }//end of buy

    public void sellTickets(){
        
    }//end of sell
    
}//end main class
