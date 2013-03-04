 package mtudiscountstrategy;

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
        //intTest
        this.product = product;
        this.quantity = quantity;
    }

    public LineItem(String prodId, int quantity) {
        //stringTest, intTest
        //This will be where I set the product using prodId
        //and the lookup function
        DiscountStrategy ds = new PercentOffDiscount();
        ds.setDiscountRate(.1);
        this.product = new Product("71", "Towel", 30.0, ds);
        this.quantity = quantity;
    }
    
    
    
//    public LineItem getNewLineItem(String prodId, int qty)

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        //Run intTest
        this.quantity = quantity;
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
    
    public static void main(String[] args) {
        //This is where I will do my testing.
        DiscountStrategy ds = new PercentOffDiscount();
        ds.setDiscountRate(.1);
        Product prod = new Product("71", "Towel", 30.0, ds);
        LineItem line = new LineItem(prod, 12);
        System.out.println("Discount rate = .1, 12 items, 30/item");
        System.out.println(line.getLineItemString());
    }
}
