package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public interface DiscountStrategy {

    double getDiscount(int qty, double price);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
