import java.time.LocalDate;


public class Payments
{
    // instance variables 
    private Reader readln;
    private int paymentValue;
    private String cardNumber;
    private String expiryDate;
    private int cvc;
    private Menu menu;
    static User user;

//constructor
    public Payments()
    {
        paymentValue = 0;
        cardNumber = "";
        expiryDate = "";
        cvc = 0;
    }

//methods
    public int updatePaymentValue(int seatCost)
    {
        paymentValue = seatCost;
        return paymentValue;
    }
    
     // Method to validate credit card number - Taken from ChatGPT
    public static boolean validateCreditCardNumber(String creditCardNumber) {
        // Remove any spaces or dashes from the credit card number
        creditCardNumber = creditCardNumber.replaceAll("\\s|-", "");

        // Check if the credit card number contains only digits
        if (!creditCardNumber.matches("[0-9]+")) {
            return false;
        }

        // Check if the credit card number is of valid length
        int length = creditCardNumber.length();
        if (length < 13 || length > 19) {
            return false;
        }

        // Apply Luhn algorithm
        int sum = 0;
        boolean alternate = false;
        for (int i = length - 1; i >= 0; i--) {
            int digit = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }

        // Credit card number is valid if the sum is divisible by 10
        return sum % 10 == 0;
    }
    
    public String checkCardDetails(String card) {
        if (validateCreditCardNumber(card)){
            cardNumber = card;
            return cardNumber;
        }
        return "Card number is invalid";
    }
    
    public String updateCVC(int newCVC){
        if (newCVC >= 000 && newCVC <= 999){
            cvc = newCVC;
            return "Valid CVC input";
        }
        return "Invalid CVC";
    }
    
    //Expiry date validator from ChatGPT 
    public static boolean validateExpiryDate(int expiryMonth, int expiryYear) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Create a LocalDate object for the expiry date
        LocalDate expiryDate = LocalDate.of(expiryYear, expiryMonth, 1).plusMonths(1).minusDays(1);

        // Check if the expiry date is after the current date
        return !expiryDate.isBefore(currentDate);
    }
    
    public String updateExpDate(int month, int year){
        if  (validateExpiryDate(month, year)){
            expiryDate = month + "." + year;
            return expiryDate;
        }
        return "Invalid expiry date";
    }
    
    public void payment(int Cost){
        System.out.println("Card details required, please input the long number of your Card");
        String longCardNumber = readln.readString();
        if (validateCreditCardNumber(longCardNumber)){
            System.out.println("Card number accepted, please provide your card expiry month as numbers");
            String expiryMonth = readln.readString();
            if(expiryMonth.matches("[0-1][0-9]")){
                System.out.println("Please provide your card expiry year as numbers");
                int intExpiryMonth = Integer.parseInt(expiryMonth);
                String expiryYear = readln.readString();
                if (expiryYear.matches("[20][2-3][4-9]")){
                    int intExpiryYear = Integer.parseInt(expiryYear);
                    if(validateExpiryDate(intExpiryMonth, intExpiryYear)){
                        System.out.println("Expiry date validated, lastly please provide your cvc");
                        String cvc = readln.readString();
                        int intCVC = Integer.parseInt(cvc);
                        if(intCVC >= 000 && intCVC <= 999){
                            System.out.println("All criteria met, seats booked");
                            menu.menuSelector(user);
                        }
                    }
                }
            }
        }
                
    }
}
