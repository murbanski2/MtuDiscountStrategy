package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class Receipt {
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    


    public Receipt(String custId) {
        setCustomer(custId);
    }
    
    public Customer getCustomer(String customerId) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        customer = fakeDatabase.findCustomer(customerId);
        return customer;
    }
    
    public void setCustomer(String customerId) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        Customer cust = fakeDatabase.findCustomer(customerId);
        if(cust == null) {
            showError("Customer not found");
        }
        else {
            customer = cust;
        }
    }


    public void addLineItem(Product product, int qty) {
        //From CodeSamples
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    

    private void addToArray(LineItem item) {
        //From CodeSamples
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }


    public double getTotalBeforeDiscount() {
        //from CodeSamples
        //Loop thru the LineItem array and add the extended prices
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getExtendedPrice();
        }
        return grandTotal;
    }    
    
    public double getTotalDiscount() {
        //Loop thru the LineItem array and add the discounts
        double totalDiscount = 0.0;
        for(LineItem item : lineItems) {
            totalDiscount += item.getDiscount();
        }
        return totalDiscount;
    }
    
    private void showError(String error ) {
        //I plan to do this with a popup later
        System.out.println(error + " in Receipt");
    }
            
}


