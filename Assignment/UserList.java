import java.util.ArrayList; // import the ArrayList class
import java.util.Iterator;

public class UserList
{
    // instance variables
    public ArrayList<User> Users;

//constructor

    public UserList()
    {
        Users = new ArrayList<User>();
    }

//methods
//admin access only
    public void add(User user)
    {
    Users.add(user);
    }
    
    public String viewUserList()
    {
        for (User userName : Users){
            System.out.println(userName.Username + "  " + userName.account_type);
        }
        return "test";
    }
    
    public void deleteUser(String name) {
        Iterator<User> iterator = Users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.Username.equalsIgnoreCase(name)) {
                iterator.remove();
            }
        }
    }
    
//registration    
    public void createUser(String name, String password)
    {
        User newUser = new User(name, password);
        Users.add(newUser);
    }
    
    public User findUser(String name){
        for (User userN : Users){
            if (userN.Username.equalsIgnoreCase(name)) {
                System.out.println("User found: " + userN.Username);
                return userN;
            }
        }
        System.out.println("User not found");
        return null;
    }
    
    public boolean checkExists(String name){
        for (User userN : Users){
            if (userN.Username.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkIfManager(String code){
        for (User U : Users){
            if (U instanceof VenueManager) {
                VenueManager VM = (VenueManager) U;
                VM.checkCode(code);
            }
        }
        return false;
    }
    
    public void addUserData(){
        User user1 = new Customer("Adrian Garvel", "mypasswordisntsecure", "adrian.garv@gmail.com");
        User user2 = new VenueManager("Bucks Admin", "BucksAdm1n123", "12345");
        User user3 = new BookingAgent("Bucks Booking Agency", "W3bookS34ts@Here");
        User user4 = new Customer("Test", "Test", "test@gmail.com");
        Users.add(user4);
        Users.add(user1);
        Users.add(user2);
        Users.add(user3);
    }    
}
