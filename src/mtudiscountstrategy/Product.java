package mtudiscountstrategy;

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
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.discountStrategy = discountStrategy;
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
        System.out.println("Discount on 5 items: " 
                + prod.discountStrategy.getDiscount(5, prod.getProductCost()));
    }
    
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


    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
}
