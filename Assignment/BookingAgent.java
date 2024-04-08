
/**
 * Write a description of class BookingAgent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BookingAgent extends User
{
    // instance variables

    /**
     * Constructor for objects of class BookingAgent
     */
    public BookingAgent(String Name, String Password)
    {
        super(Name, Password);
        account_type = "booking agent";
    }
}
