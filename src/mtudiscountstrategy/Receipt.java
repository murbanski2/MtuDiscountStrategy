package mtudiscountstrategy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author murbanski
 */
public class Receipt {
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    
    public Receipt(String custId) {
        if (stringIsValid(custId, "custId")) {
            setCustomer(custId);
        }
    }
    
    public final Customer getCustomer(String customerId) {
        if (!stringIsValid(customerId, "customerId")) {
            //This will already return null if customerId not valid
        }
        FakeDatabase fakeDatabase = new FakeDatabase();
        customer = fakeDatabase.findCustomer(customerId);
        return customer;
    }
    
    public final void setCustomer(String customerId) {
        if (!stringIsValid(customerId, "customerId")) {
            //This one already has a good error
        }
        FakeDatabase fakeDatabase = new FakeDatabase();
        Customer cust = fakeDatabase.findCustomer(customerId);
        if(cust == null) {
            showError("Customer not found");
        }
        else {
            customer = cust;
        }
    }
    

    public final void addItemToSale(String prodId, int qty) {
        //from CodeSamples
        if (stringIsValid(prodId, "prodId") && 
                intIsValid(qty, "qty")) {
            FakeDatabase db =  new FakeDatabase();
            Product product = db.findProduct(prodId);

                    // if found, add the lineItem to the receipt
                    // but it's the receipt's job to do this!
            if(product != null) {
                addLineItem(product, qty);
            }
        }
    }
    
    public final void addLineItem(Product product, int qty) {
        //From CodeSamples
        if (intIsValid(qty, "qty")) {
            LineItem item = new LineItem(product, qty);
            addToArray(item);
        }
    }
    

    private void addToArray(LineItem item) {
        //From CodeSamples
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }


    public final double getTotalBeforeDiscount() {
        //from CodeSamples
        //Loop thru the LineItem array and add the extended prices
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getExtendedPrice();
        }
        return grandTotal;
    }    
    
    public final double getTotalDiscount() {
        //Loop thru the LineItem array and add the discounts
        double totalDiscount = 0.0;
        for(LineItem item : lineItems) {
            totalDiscount += item.getDiscount();
        }
        return  totalDiscount;
    }
    
    public final void getReceipt() {
        DecimalFormat dollar = new DecimalFormat("###,##0.00");
        double subtotal = getTotalBeforeDiscount();
        double discountTotal = getTotalDiscount();
        double grandTotal = subtotal - discountTotal;
        String formatSubtotal = 
                String.format("%10s",dollar.format(subtotal) );
        String formatDiscountTotal = 
                String.format("%10s",dollar.format(discountTotal) );
        String formatGrandTotal = 
                String.format("%10s",dollar.format(grandTotal) ) ;
        
        System.out.println("\n\n\nThank you for shopping at Urb Mart, ");
        System.out.print("\nCustomer ID: ");
        System.out.println(customer.getCustId());
        System.out.print("\nHere are your purchases today, ");
        System.out.println(customer.getCustName());
        System.out.println();
        System.out.print("ID");
        System.out.print("\tPruduct Description");
        System.out.print("\tUnit Cost");
        System.out.print("\tQuantity");
        System.out.print("\tExtended Cost");
        System.out.println("\tDiscount");
        for(LineItem item : lineItems) {
            System.out.println(item.getLineItemString());
        }
        System.out.println("\n");
        System.out.println("\t\t\t             Subtotal: $" + formatSubtotal);
        System.out.println("\t\t\tTotal Discount amount: $" + formatDiscountTotal);
        System.out.println("\t\t\t          Grand Total: $" + formatGrandTotal);        
        System.out.println("\nCome again soon");
        System.out.println("Retain this receipt for your records");
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        String format = "MM/dd/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = c.getTime();
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);
    }
    


    public static void main(String[] args) {
        Receipt receipt = new Receipt("100");
        receipt.addItemToSale("A101", 7);
        receipt.addItemToSale("C222", 4);
        receipt.getReceipt();
        
    }
    
    //Testing code
    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in Receipt");
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


