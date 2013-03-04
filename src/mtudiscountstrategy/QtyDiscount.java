package mtudiscountstrategy;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */
public class QtyDiscount implements DiscountStrategy {
    private double discountRate;
    private int minimumForDiscount;

    public QtyDiscount(double discountRate, int minimumForDiscount) {
        //testDouble, testInt
        if (doubleIsValid(discountRate, "discountRate") &&
                intIsValid(minimumForDiscount, "minimumForDiscount") ) {
            this.discountRate = discountRate;
            this.minimumForDiscount = minimumForDiscount;
        }
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
        
        //DiscountStrategy bad = new QtyDiscount(-1.0, 2);
        //DiscountStrategy bad2 = new QtyDiscount(.11, -2);
        
        //double a = d.getDiscount(4, -1.1);
        //a = d.getDiscount(-1, 23.95);
        d.setDiscountRate(-2.7);
    }

    public final int getMinimumForDiscount() {
        return minimumForDiscount;
    }

    public final void setMinimumForDiscount(int minimumForDiscount) {
        if (intIsValid(minimumForDiscount, "minimumForDiscount") ) {
            this.minimumForDiscount = minimumForDiscount;
        }
    }
    
    private double roundDouble(double num) {
        BigDecimal bd = new BigDecimal(Double.toString(num));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        double val = bd.doubleValue();
        return val;
    }    
    
    @Override
    public final double getDiscount(int qty, double price) {
        double discount = 0.0;
        if (intIsValid(qty, "qty") && doubleIsValid(price, "price") ) {
            if (qty < minimumForDiscount) {
                discount = 0.0;
            }
            else {
                discount = price * discountRate * qty;
            }
        }
        discount = roundDouble(discount);
        return discount;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        if (doubleIsValid(discountRate, "discountRate") ) {
            this.discountRate = discountRate;
        }
    }
    private void showError(String error ) {
        //I plan to do this with a popup later
        JOptionPane.showMessageDialog(null, error + " in QtyDiscount");
    }

    private boolean doubleIsValid(double d, String variableName) {
        boolean valid = true;
        if (d <= 0.0) {
            valid = false;
            showError("Invalid double " + variableName);
        }
        return valid;
    }

    private boolean intIsValid(int i, String variableName) {
        boolean valid = true;
        if (i < 0) {
            valid = false;
            showError("Invalid integer " + variableName);
        }
        return valid;
    }
    
    
    
    
}
