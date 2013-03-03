package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class Receipt {
    private LineItem[] lineItem = new LineItem[0];
    private Customer customer;
    
    private double totalFullPrice;
    private double totalDiscount;

    public Receipt(String custId, String productId, int qty) {
        boolean errorFound = false;
        FakeDatabase fakeDatabase = new FakeDatabase();
        Customer cust = fakeDatabase.findCustomer(custId);
        Product prod = fakeDatabase.findProduct(productId);
        if(cust == null) {
            errorFound = true;
            showError("Customer not found");
        }
        if(prod == null) {
            errorFound = true;
            showError("Product not found");
        }
        
        if(!errorFound) {
            customer = cust;
            
        }
    }
    


    public void addLineItem(Product product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    
    public void addToArray(LineItem item) {
    
    }
    
    private void addToTotalFullPrice(double amount) {
        //testDouble
        totalFullPrice += amount;
    }
    
    private void addToTotalDiscount(double amount) {
        //testDouble
        totalDiscount += amount;
    }
    
    private void showError(String error ) {
        //I plan to do this with a popup later
        System.out.println(error + " in Receipt");
    }
            
}
