import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EventsListTest {
    //ommitted tests on methods that print to console
    @Test
    public void testDeleteEvent() {
        EventsList eventsList = new EventsList();
        eventsList.addEvent("Concert", 50, 30, "2024-04-10", "18:00");
        eventsList.addEvent("Theater Show", 40, 25, "2024-04-15", "19:30");
        
        // Delete an event and check if it is removed from the list
        eventsList.deleteEvent("Concert");
        assertFalse(eventsList.checkDate("2024-04-10"));
        assertFalse(eventsList.checkTime("18:00"));
    }

    @Test
    public void testSelectEvent() {
        EventsList eventsList = new EventsList();
        eventsList.addEvent("Concert", 50, 30, "2024-04-10", "18:00");
        
        // Select an event and check if it is returned
        Event selectedEvent = eventsList.selectEvent("Concert", "2024-04-10", "18:00");
        assertNotNull(selectedEvent);
    }

    @Test
    public void testCheckDateAndCheckTime() {
        EventsList eventsList = new EventsList();
        eventsList.addEvent("Concert", 50, 30, "2024-04-10", "18:00");
    }
} 
       


