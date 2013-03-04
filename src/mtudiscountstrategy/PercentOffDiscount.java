package mtudiscountstrategy;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author murbanski
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate = .20;

    public PercentOffDiscount() {
        //don't do anything
    }

    public PercentOffDiscount(double discountRate) {
        if (doubleIsValid(discountRate, "discountRate") ) {
            this.discountRate = discountRate;
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
        if (intIsValid(qty, "qty") && doubleIsValid(price, "price")) {
            discount = price * qty * discountRate;
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
    
    public static void main(String[] args) {
        //My test class
        PercentOffDiscount discount = new PercentOffDiscount();
        double d = discount.getDiscount(3, 20.0);
        System.out.println("Getting discount for 3 items, $20 each");
        System.out.println("With default discount rate of 20%: " + d);
        discount.setDiscountRate(.10);
        d = discount.getDiscount(3, 20.0);
        System.out.println("With 10% discount rate:" + d);
    }
    
    private void showError(String error ) {
        //I plan to do this with a popup later
        JOptionPane.showMessageDialog(null, error + " in PercentOffDiscount");
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
