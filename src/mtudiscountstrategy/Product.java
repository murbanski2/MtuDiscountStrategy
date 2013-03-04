package mtudiscountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */
public class Product {
    private String productId;
    private String productName;
    private double productCost;
    private DiscountStrategy discountStrategy;

    public Product(String productId, String productName, 
            double productCost, DiscountStrategy discountStrategy) {
        if (stringIsValid(productId, "productId") && 
                stringIsValid(productName, "productName") && 
                doubleIsValid(productCost, "productCost") ) {
            this.productId = productId;
            this.productName = productName;
            this.productCost = productCost;
            this.discountStrategy = discountStrategy;
        }
    }
    
    //Tester
    public static void main(String[] args) {
        DiscountStrategy ds = new PercentOffDiscount();
        ds.setDiscountRate(.5);
        Product prod = new Product("71", "Towel", 30.0, ds);
        System.out.println("Product ID: " + prod.getProductId());
        System.out.println("Product Name: " + prod.getProductName());
        System.out.println("Product Cost: " + prod.getProductCost());
        //I don't know if I like the way I am getting the discount.
        //Maybe there should be a method in Product that passes the 
        //quantity and price.
        System.out.println("Discount on 5 items: " + prod.getDiscount(5) );
    }
    
    //Get the discount from the discountStratagy
    public final double getDiscount(int qty) {
        double val = 0.0;
        if (intIsValid(qty, "qty") ) {
            val = discountStrategy.getDiscount(qty, productCost);
        }
        return val;
    }
    
    //Setters and getters
    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        if (stringIsValid(productId, "productId") ) {
            this.productId = productId;
        }
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        if (stringIsValid(productName, "productName") ) {
            this.productName = productName;
        }
    }


    public final double getProductCost() {
        return productCost;
    }

    public final void setProductCost(double productCost) {
        if (doubleIsValid(productCost, "productCost")) {
            this.productCost = productCost;
        }
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    //Testing functions
    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in Product");
    }
	
    private boolean stringIsValid(String st, String variableName) {
        boolean valid = true;
        if (st == null || st.length() == 0) {
            valid = false;
            showError("Invalid string " + variableName);
        }
        return valid;
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
