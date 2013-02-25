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
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
