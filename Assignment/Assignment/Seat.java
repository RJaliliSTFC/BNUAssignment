
/**
 * Class for Seat objects which store location details and a boolean booked value
 */
public class Seat
{
    // instance variables
    public char row;
    public int column;
    public boolean booked;
    public boolean premium;

    /**
     * Constructor for objects of class Seat
     */
    public Seat(String row, int column)
    {
        //seat instance variables
        row = row;
        column = column;
        booked = false;
        if (row == "f" || row == "g"){ 
            premium = true;
            } else {
                premium = false;
            }
        }
    
    //method for checking seat availability in SeatPlan
    public String checkSeat() {
        if (this.booked == false) {
            return "O";
        };        
        return "X";
    }
    
    public void bookSeat() {
        this.booked = true;
    }
    
    public void unbookSeat() {
        this.booked = false;
    }
    
    
}
