package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class FlatRateDiscount implements DiscountStrategy {
    private double discountRate = .20;
    //private double price = 20.00;
    //private int qty = 3;
    
    @Override
    public double getDiscount(int qty, double price) {
        return  (price * qty * discountRate);        
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public static void main(String[] args) {
        //My test class
        FlatRateDiscount discount = new FlatRateDiscount();
        double d = discount.getDiscount(3, 20.0);
        System.out.println("Getting discount for 3 items, $20 each");
        System.out.println("With default discount rate of 20%: " + d);
        discount.setDiscountRate(.10);
        d = discount.getDiscount(3, 20.0);
        System.out.println("With 10% discount rate:" + d);
    }
}
