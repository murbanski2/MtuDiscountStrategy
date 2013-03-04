package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public class NoDiscount implements DiscountStrategy {
    //I am just going with the default constructor here.  No more is needed.
    
    public static void main(String[] args) {
        DiscountStrategy d = new NoDiscount();
        System.out.println("The discount amount for 10 items, $85 each is ");
        System.out.println(d.getDiscount(10, 85.0));
    }
    
    @Override
    public final double getDiscount(int qty, double price) {
        //testInt, testDouble
        //It doesn't matter what the qty and price values are.  Just return 0.
        return 0.0;
    }

    @Override
    public final double getDiscountRate() {
        return 0.0;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        //testDouble
        //I am not going to set anything.  NoDiscount MEANS no discount!
    }
    
}
