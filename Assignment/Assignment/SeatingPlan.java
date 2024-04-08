import java.util.HashMap; // import the HashMap class

public class SeatingPlan {
    String[] rows = {"a", "b", "c", "d", "e", "f", "g"};
    int[] columns = {1, 2, 3, 4, 5};
    HashMap<String, Seat> seatingPlan = new HashMap<>();

    public SeatingPlan() {
        for (String row : this.rows) {
            for (int column : this.columns) {
                String key = row + "" + column;
                Seat s = new Seat(row, column);
                this.seatingPlan.put(key, s);
            }
        }
    }

    public void viewPlan() {
        System.out.print("  ");
        for (int column : this.columns) {
            System.out.print(column + " ");
        }
        System.out.println();

        for (String row : this.rows) {
            System.out.print(row + " ");
            for (int column : this.columns) {
                String key = row + "" + column;
                Seat seat = this.seatingPlan.get(key);
                System.out.print(seat.checkSeat() + " ");
            }
            System.out.println();
        }
    }
    
    public Seat findSeat(String key){
        Seat chosenSeat = seatingPlan.get(key);
        return chosenSeat;
    }
}