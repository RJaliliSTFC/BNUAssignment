import java.util.ArrayList;
public class Promotion
{
    // instance variables - replace the example below with your own
    public String promotion;
    public static ArrayList<String> Promotions;
    public Event event;
    public static Menu menu;
    
    public Promotion()
    {
        ArrayList<String> Promotions = new ArrayList<String>();
        populatePromotions();
        event = menu.chosenEvent;
    }

    //methods
    public void applyPromotion(String promotion, Event event)
    {
        
    }
    
    public String findPromotion(String promotion){
        for(String i : Promotions){
            if (promotion.equalsIgnoreCase(i)){
                return i;
            }
        }
        return "Not a promotion";
    }        
    
    
    public void populatePromotions(){
        String promotion1 = "2 for 1";
        String promotion2 = "Buy 2 get 1 Free";
        String promotion3 = "Friday Funday";
        Promotions.add(promotion1);
        Promotions.add(promotion2);
        Promotions.add(promotion3);
    }
}

