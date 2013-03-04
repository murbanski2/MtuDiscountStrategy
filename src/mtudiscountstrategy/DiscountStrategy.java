package mtudiscountstrategy;

/**
 *This abstract class is the basis for Discount classes.
 *<P>
 * @DiscountStrategy.java    03/04/2013
 * @author Mark Urbanski
 */

public interface DiscountStrategy {

    /**
     * Returns the discount amount given a quantity and a price.
     * @param qty
     * @param price
     * @return a double value for discount amount
     */
    public abstract double getDiscount(int qty, double price);
    
    /**
     * A getter for the discount rate
     * @return a double value
     */
    public abstract double getDiscountRate();

    /*
     * Setter for the discount rate.
     */
    public abstract void setDiscountRate(double discountRate);
    
}
