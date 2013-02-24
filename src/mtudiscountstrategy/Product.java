/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public class Product {
    private String productId;
    private String productName;
    private String productDescription; //I don't know 
    private double productCost;
    
    
    //Setters and getters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }
    
}
