
public class Promotion extends Event
{
    // instance variables - replace the example below with your own
    public String promotion;
    
    public Promotion(String Name,int base_cost_premium, int base_cost_normal, String dateInfo, String timeInfo)
    {
        super(Name, base_cost_premium, base_cost_normal, dateInfo, timeInfo);
        
    }

    //methods
    public void applyPromotion(String promotion, Event event)
    {
    }
}
