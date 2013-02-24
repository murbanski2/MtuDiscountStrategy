package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public interface DiscountStrategy {

    //getDiscount() returns the discount amount
    public abstract double getDiscount(int qty, double price);
    
    //getDiscountRate() is a regular getter.  Might not be used.
    public abstract double getDiscountRate();

    //setDiscountRate() is a regular setter.
    public abstract void setDiscountRate(double discountRate);
    
}
