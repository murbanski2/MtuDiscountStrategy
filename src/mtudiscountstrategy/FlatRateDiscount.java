package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class FlatRateDiscount {
    private double discountRate = .20;
    //private double price = 20.00;
    //private int qty = 3;
    
    public double getDiscount(int qty, double price) {
        return  (price * qty * discountRate);        
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public static void main(String[] args) {
        FlatRateDiscount discount = new FlatRateDiscount();
        double d = discount.getDiscount(3, 20.0);
        discount.setDiscountRate(.10);
        System.out.println(d);
    }
}
