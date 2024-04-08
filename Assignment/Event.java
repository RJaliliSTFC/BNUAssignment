import java.time.LocalDate;

//Attributes of a singular event
public class Event
{
    // instance variables 
    public String name;
    public int premiumTicket;
    public int normalTicket;
    public String date;
    public String time;
    private String owner;
    private boolean promotion;
    public SeatingPlan seatPlan;

    /**
     * Constructor for objects of class Event
     */
    public Event(String Name,int base_cost_premium, int base_cost_normal, String dateInfo, String timeInfo)
    {
        // initialise instance variables
        name = Name;
        normalTicket = base_cost_normal;
        premiumTicket = base_cost_premium;
        date = dateInfo;
        time = timeInfo;
        promotion = false;
        seatPlan = new SeatingPlan();
    }

    //set the normal ticket cost method
    public int changeCostNormal(int costNormal)
    {
        // put your code here
        this.normalTicket = costNormal;    
        return normalTicket;
    }
    //set the premium ticket cost method
    public int changeCostPremium(int premiumPrice)
    {
        // put your code here
        this.premiumTicket = premiumPrice;    
        return premiumTicket;
    }
    
    public String checkDateValid(int day, int month, int year){
        LocalDate currentDate = LocalDate.now();
        LocalDate checkDate = LocalDate.of(year, month, day);     
        if (checkDate.isAfter(currentDate)){
            return "" + day + month + year;
        }
        return "Invalid Event Date";
    }
    
    public void changeDate(String newDate){
        this.date = newDate;
    }
    
    public void changeTime(String newTime){
        this.time = newTime;
    }
    
}
