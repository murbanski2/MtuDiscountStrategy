package mtudiscountstrategy;

import javax.swing.JOptionPane;

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
        if (intIsValid(qty, "qty") && doubleIsValid(price, "price") ) {
            //It doesn't matter what the qty and price values are.  Just return 0.
        }
        return 0.0;
    }

    @Override
    public final double getDiscountRate() {
        return 0.0;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        if (doubleIsValid(discountRate, "discountRate") ) {
        //I am not going to set anything.  NoDiscount MEANS no discount!
        }
    }

    private void showError(String error ) {
        //I plan to do this with a popup later
        JOptionPane.showMessageDialog(null, error + " in Receipt");
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
