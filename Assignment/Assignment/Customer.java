import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import java.util.*; 
  
public class Customer extends User
{
    // instance variables
    public String email;
    public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }     
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String Name, String Password, String Email)
    {
        super(Name, Password);
        account_type = "Customer";
        if (isValid(Email)){
            email = Email;
        }
    }
    
    public void changeEmail(String newEmail){
        if (isValid(newEmail)){
            email = newEmail;
        }
    }
}
