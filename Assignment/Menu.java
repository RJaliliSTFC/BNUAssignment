
public class Menu
{
    private Reader readln;
    public static EventsList Events;
    static User user;
    static Booking booking;

    public Menu()
    {
        readln = new Reader();
        Events = InterfaceObject.getEvents();
        user = InterfaceObject.getUser();
    }
    
    public void venueManagerMenu()
    {
        System.out.println("Option 1: View all shows");
        System.out.println("Option 2: View all shows with promotions");
        System.out.println("Option 3: Manage Shows");
        System.out.println("Option 4: Manage Promotions");
        String reply = readln.readString();
        if (reply.equals("1")){
            option1();
            
        }
    }
    
    public void bookingAgentMenu()
    {
        System.out.println("Option 1: View all shows");
        System.out.println("Option 2: View all shows with promotions");
        String reply = readln.readString();
        if (reply.equals("1")){
            option1();
            
        }

    }
    
    public void customerMenu()
    {
        System.out.println("Option 1: View all shows");
        System.out.println("Option 2: View all shows with promotions");
        String reply = readln.readString();
        if (reply.equals("1")){
            option1();
        }
        else if (reply.equals("2")){
            option2();
        }
        customerMenu();    
    }
    
    public void option1(){
        Booking booking = new Booking();
        Events.viewEventList();
        System.out.println("View more details of a show by replying with it's name, or return to main menu by replying 1");
        String showReply = readln.readString();
        if (showReply.equals("1")) {
            menuSelector(user);
        }
        Events.viewEvent(showReply);
        System.out.println("If you would like to book one of these shows please reply with 1, otherwise reply with 2 to return to main menu");
        String reply = readln.readString();
        boolean validShow = false;
        if (reply.equals("1")){ //error handling not build in here, if you type in a date/time of a different show 
            while(!validShow){
                System.out.println("Please type in the date of the event as shown");
                String date = readln.readString();
                if (date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
                    if (!Events.checkDate(date)){
                        System.out.println("Incorrect date entered, please check and try again");
                    }
                    System.out.println("Date selected, please choose a showing time");              
                }
                String time = readln.readString();
                if (time.matches("\\d{2}:\\d{2}")){
                    if (!Events.checkTime(time)){
                        System.out.println("Incorrect time entered, please check and try again");
                    }
                    System.out.println("Time Selected, Moving to booking menu");
                    Event chosenEvent = Events.selectEvent(showReply, date, time);
                    booking.seatSelection(chosenEvent);
                    validShow = true;
                }
            }
        }
        menuSelector(user);
    }
    
    public void option2(){
        
    }
    
    public void menuSelector(User user){
        if (user instanceof VenueManager) {
                venueManagerMenu();
            }
            else if (user instanceof BookingAgent){
                bookingAgentMenu();
            }
            else if (user instanceof Customer){
                customerMenu();
            }
    }
}

    
