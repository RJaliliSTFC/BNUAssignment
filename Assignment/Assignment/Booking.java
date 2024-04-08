import java.util.ArrayList;

public class Booking
{
    private Menu menu;
    private Event event;
    private Reader readln;
    private ArrayList<Seat> selectedSeats = new ArrayList<Seat>();
    static User user;
    static Payments payment;
  
    public Booking()
    {
        readln = new Reader();
        user = InterfaceObject.getUser();
    }

    public void seatSelection(Event event)
    {
        event.seatPlan.viewPlan();
        System.out.println("Above is the seatplan for your chosen event");
        System.out.println("Seats marked O are available and seats marked X are booked");
        System.out.println("Type in a seat key (e.g. A1) marked O to add it to your booking selection");
        boolean selection = true;
        while (selection){
            String key = readln.readString();
            if (key.matches("(?i)[a-g][1-5]")){
                Seat seat = event.seatPlan.findSeat(key);
                System.out.println("Seat " + seat.row +seat.column + " has been added to your booking");
                selectedSeats.add(seat);
                System.out.println("Select another seat or finish by typing \"end\"");
            }
            else if (key.equalsIgnoreCase("cancel")){
                selectedSeats.clear();
                selection = false;
                seatSelection(this.event);
            }
            else if(key.equalsIgnoreCase("end")){
                selection = false;
                checkout(selectedSeats);
            }
            else if(key.equalsIgnoreCase("menu")){
                selectedSeats.clear();
                selection = false;
                menu.menuSelector(user);
            }
            else {
                System.out.println("Incorrect key selected, please try again");
                System.out.println("Return to main menu by responding \"menu\"");    
            }
        }
    }
    
    public void checkout(ArrayList<Seat> Seats){
        Payments payments = new Payments();
        int premiumSeats = 0;
        int regularSeats = 0;
        for(Seat i : Seats){
            i.bookSeat();
            if(i.premium){
                premiumSeats ++;
            }
            regularSeats ++;
        }
        int totalCost = menu.chosenEvent.premiumTicket * premiumSeats + menu.chosenEvent.normalTicket * regularSeats;
        
        System.out.println("Your seats have been temporarily booked");
        System.out.println("The total cost will be " + totalCost);
        System.out.println("Would you like to proceed to payment? Reply \"Y/N\"");
        String bookingconfirmation = readln.readString();
        if (bookingconfirmation.equalsIgnoreCase("y")){
            payments.payment(totalCost);
        }
        System.out.println("Do you want to cancel your booking and return to seat selection? Reply \"Y/N\"");
        String bookingcancel = readln.readString();
        if (bookingcancel.equalsIgnoreCase("y")){
            checkout(selectedSeats);
        }
        System.out.println("Reply 1 to return to main menu or reply 2 to return to Seat Selection");
        String finalconfirmation = readln.readString();
        if (finalconfirmation.equals("1")){
            menu.menuSelector(user);
        }
        seatSelection(this.event);
    }
}
