 package mtudiscountstrategy;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */
public class LineItem {
    //Pass in product and quantity from Receipt.
    //Receipt will get product from FakeDatabase code in CodeSamples.txt
    private int quantity;
    private Product product;

    public LineItem(Product product, int quantity) {
        if (intIsValid(quantity, "quantity"))
        this.product = product;
        this.quantity = quantity;
    }

//    public LineItem(String prodId, int quantity) {
//        
//        //This will be where I set the product using prodId
//        //and the lookup function
//        if (stringIsValid(prodId, "prodId") && 
//                intIsValid(quantity, "quantity")) {
//            DiscountStrategy ds = new PercentOffDiscount();
//            ds.setDiscountRate(.1);
//            this.product = new Product("71", "Towel", 30.0, ds);
//            this.quantity = quantity;
//        }
//    }
    
    
    
//    public LineItem getNewLineItem(String prodId, int qty)

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if (intIsValid(quantity, "quantity") ) {
            this.quantity = quantity;
        }
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //I think product will already be tested at this point, so no need
        //to test again.
        this.product = product;
    }
    
    public final double getExtendedPrice() {
        double extendedPrice = quantity * product.getProductCost();
        extendedPrice = roundDouble(extendedPrice);        
                
        return extendedPrice;
    }
    
    public final double getDiscount() {
        return product.getDiscount(quantity);
    }
    
    public final String getLineItemString() {
        //This will output a string that will have ID, Name, Unit Price, 
        //quantity, amount, and amount saved
        String outLine = product.getProductId() + "\t" +
                product.getProductName() + "\t" +
                product.getProductCost() + "\t" +
                quantity + "\t" +
                getExtendedPrice() + "\t" + 
                getDiscount()  ;
        return outLine;
    }
    private double roundDouble(double num) {
        BigDecimal bd = new BigDecimal(Double.toString(num));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        double val = bd.doubleValue();
        return val;
    }  
    
    public static void main(String[] args) {
        //This is where I will do my testing.
        DiscountStrategy ds = new PercentOffDiscount();
        ds.setDiscountRate(.1);
        Product prod = new Product("71", "Towel", 30.0, ds);
        LineItem line = new LineItem(prod, 12);
        System.out.println("Discount rate = .1, 12 items, 30/item");
        System.out.println(line.getLineItemString());
    }
    
    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in LineItem");
    }
	
    private boolean stringIsValid(String st, String variableName) {
        boolean valid = true;
        if (st == null || st.length() == 0) {
            valid = false;
            showError("Invalid string " + variableName);
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
