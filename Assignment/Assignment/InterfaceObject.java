//Main interface object to be used

public class InterfaceObject
{
    // initiation variables
    private Reader readln; 
    static Customer customer;
    static UserList Users;
    static Menu menu;
    public static EventsList Events;
    public static boolean mainMenu;
    public static User thisUser;
    
    public InterfaceObject()
    {
        readln = new Reader();
        Users = new UserList();
        Events = new EventsList();
        menu = new Menu();
    }

    public void login()
    {   
        Users.addUserData();
        boolean registration = true;
        User thisUser;
        
        while(registration) {
            boolean loginBool = false;
            while(!loginBool){
                System.out.println("Welcome to the Bucks Centre for Performing arts management software");
                System.out.println("Please enter your username or type 1 to Register");
                
                String login = readln.readString();
                if (Users.checkExists(login)){
                    User currentUser = Users.findUser(login);
                    if (currentUser instanceof User) {
                        System.out.println("Please type your password");
                        String password = readln.readString();
                        if (currentUser.checkPassword(password)){
                            thisUser = currentUser;
                            System.out.println("Login Successful");
                            userInterface(thisUser);
                        }
                        else {
                            System.out.println("Login failed");
                            currentUser = null;
                        }
                    }
                    else {
                        System.out.println("Please try again");
                    }
                }
                else if (login.equals("1")) {
                    loginBool = true;
                    registration = false;               
                }
            }
        }
        
        while(!registration) {
            System.out.println("Welcome to registering an account");
            System.out.println("Please provide a Username to login with");
            
            String username = readln.readString();
            if (Users.checkExists(username)){
                System.out.println("This username is already taken, please try another");
                continue;
            }
            System.out.println("Username available! Please type a password for your account");
            System.out.println("Your password must contain both uppercase and lower case letters, and be at least 8 characters long");
            
            String validpass = "";
            boolean validPassword = false;
            while (!validPassword) {
                String password = readln.readString();
                if (!password.matches("^(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
                    System.out.println("Your password is not strong enough!");
                    System.out.println("Please try again");
                    System.out.println(password);
                    continue;       
                }
                else {
                    System.out.println("Your password is strong enough!");
                    System.out.println("Please provide a Venue manager code or reply 1 to continue as a customer");                    
                    validpass = password;
                    validPassword = true;
                }
            }
            String validManCode = "";
            boolean validManager = false;
            //unable to create manager accounts - intentional
            while(!validManager){
                String reply = readln.readString();
                if (!reply.equals("1")) {
                    if (Users.checkIfManager(reply)){
                        System.out.println("Manager code accepted! New management account created!");
                        VenueManager newManager = new VenueManager(username, validpass, reply);
                        validManCode = reply;
                        registration = true;
                        validManager = true;
                    }
                    System.out.println("Invalid Manager Code");
                    System.out.println("Please try another code or type 1 to continue");
                    continue;
                }
                validManager = true;
            }
            System.out.println("Please provide an email which we will use for communications");
            String validEmail = "";
            boolean validE = false;
            while (!validE){
                String email = readln.readString();
                if (!customer.isValid(email)){
                    System.out.println("Email not valid, please check again");
                    continue;
                }
                System.out.println("Email valid, your account has successfully been created!");
                User newcust = new Customer(username, validpass, email);
                Users.add(newcust);
                System.out.println("Now returning to login");
                validE = true;
                registration = true;
                this.login();
                }
        }
    }
    
    public void userInterface(User user){
        boolean mainMenu = true;
        Events.addEventsData();
        System.out.println("Welcome "+ user.Username + "!");
        System.out.println("");  
        System.out.println("Welcome to the main menu, please read through the following options and select what you would like to do");
        while (mainMenu){
            menu.menuSelector(user);
        }
    }
    
        public static EventsList getEvents() {
        return Events;
    }
    
        public static User getUser() {
        return thisUser;
    }

}