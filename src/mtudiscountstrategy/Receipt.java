package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class Receipt {
    private LineItem[] lineItem = new LineItem[0];
    private Customer customer;
    
    private double totalFullPrice;
    private double totalDiscount;
    
    private void addToTotalFullPrice(double amount) {
        //testDouble
        totalFullPrice += amount;
    }
    
    private void addToTotalDiscount(double amount) {
        //testDouble
        totalDiscount += amount;
    }
    
    
}
