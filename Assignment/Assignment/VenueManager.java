
public class VenueManager extends User
{
    // instance variables
    private String admin_code;
    private User user;
    /**
     * Constructor for objects of class VenueManager
     */
    public VenueManager(String Name, String Password, String code)
    {
        super(Name, Password);
        account_type = "venue manager";
        admin_code = code;
    }
    
    public boolean checkCode(String code){
        if (this.admin_code == code){
            return true;
        }
        return false;
    }    
}
