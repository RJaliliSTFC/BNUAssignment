import java.util.ArrayList; // import the ArrayList class

// holds data on list of events
public class EventsList
{
    // instance variables
    private ArrayList<Event> Events;

//constructor

    public EventsList()
    {
        Events = new ArrayList<Event>();
    }

//methods

    public void viewEventList()
    {
        for (Event eventName : Events){
            System.out.println(eventName.name + " " + eventName.date + " " + eventName.time);
        }
    }
    
    public void addEvent(String Name,int base_cost_premium, int base_cost_normal, String dateInfo, String timeInfo){
        Event newEvent = new Event(Name, base_cost_premium, base_cost_normal, dateInfo, timeInfo);
        Events.add(newEvent);
    }
    
    public void deleteEvent(String Name){
        for (Event i : Events) {
            if (i.name.toLowerCase() == Name.toLowerCase()) {
                Events.remove(i);
            }
        }
    }
    
    public void viewEvent(String Name) {
        for (Event i : Events) {
            if (i.name.equalsIgnoreCase(Name)) {
                System.out.println("Event found " + i.name + " showing on " + i.date + " at " + i.time);
            }
        }
    }
    
    public Event selectEvent(String Name, String Date, String Time) {
        for (Event i : Events) {
            if (i.name.equalsIgnoreCase(Name) && i.date.equals(Date) && i.time.equals(Time)){
                return i;
            }
        } 
        return null;
    }

    public boolean checkDate(String date){
        for (Event i : Events) {
            if (i.date.equals(date)){
                return true;
            }
        }
        return false;
    }
    
        public boolean checkTime(String time){
        for (Event i : Events) {
            if (i.time.equals(time)){
                return true;
            }
        }
        return false;
    }
    
    public void addEventsData(){
        Event event1 = new Event("Life of a witch", 50, 30, "03.05.2024", "18:00");
        Event event2 = new Event("IRobot", 50, 30, "10.05.2024", "18:00");
        Event event6 = new Event("IRobot", 50, 30, "11.05.2024", "18:00");
        Event event7 = new Event("IRobot", 50, 30, "12.05.2024", "18:00");
        Event event3 = new Event("Pinocchio", 50, 30, "17.05.2024", "18:00");
        Event event8 = new Event("Pinocchio", 50, 30, "18.05.2024", "18:00");
        Event event9 = new Event("Pinocchio", 50, 30, "19.05.2024", "18:00");
        Event event4 = new Event("Life of a witch", 50, 30, "04.05.2024", "18:00");
        Event event5 = new Event("Life of a witch", 50, 30, "05.05.2024", "18:00");
        Events.add(event1);
        Events.add(event2);
        Events.add(event3);
        Events.add(event4);
        Events.add(event5);
        Events.add(event6);
        Events.add(event7);
        Events.add(event8);
        Events.add(event9);
    }
}
