package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public class QtyDiscount implements DiscountStrategy {
    private double discountRate;
    private int minimumForDiscount;

    public QtyDiscount(double discountRate, int minimumForDiscount) {
        this.discountRate = discountRate;
        this.minimumForDiscount = minimumForDiscount;
    }
    
    public static void main(String[] args) {
        DiscountStrategy d = new QtyDiscount(.10, 5);
        System.out.println("The discount amount for a minimum of 5, 10%");
        System.out.println("where 10 are purchased for $85 each is ");
        System.out.println(d.getDiscount(10, 85.0));
        System.out.println("If only 4 are purchased, the discount is ");
        System.out.println(d.getDiscount(4, 85.0));
        //Test the edge case, or you may have trouble
        System.out.println("If 5 are purchased, the discount is ");
        System.out.println(d.getDiscount(5, 85.0));
    }
    
    
    
    @Override
    public double getDiscount(int qty, double price) {
        double discount;
        if (qty < minimumForDiscount) {
            discount = 0.0;
        }
        else {
            discount = price * discountRate * qty;
        }
        return discount;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    
    
    
}
