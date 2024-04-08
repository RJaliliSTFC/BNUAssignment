/**
 * Parent class for agents/venue managers/customers
 */
public class User
{
    // instance variables
    public String Username;
    private String password;
    public String account_type;

    /**
     * Constructor for objects of class User
     */
    public User(String Name, String Password)
    {
        Username = Name;
        password = Password;
    }
//methods
    public void viewUser(){
        System.out.println("Currently logged in as: " + this.Username);
    }
    
    public void changeName(String name){
        this.Username = name;
    }
    
    public void changePassword(String password){
        this.password = password;
    }
    
    public boolean checkPassword(String password){
        if (this.password.equals(password)){
            return true;
        }
        return false;
    }
    
}
