package mtudiscountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */


public class FakeDatabase {
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };

// Notice we assign a default discount strategy component object to each product
    private Product[] products = {
        new Product("A101", "Baseball Hat", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(.10,5)),
        new Product("C222", "Women's Socks", 9.50, new NoDiscount())
    };

// Just call this method to find a customer in the array by its id.
// Returns null if not found.
    public final Customer findCustomer(final String custId) {

        Customer customer = null;
        if (stringIsValid(custId, "custId") ) {
            for(Customer c : customers) {
                if(custId.equals(c.getCustId())) {
                    customer = c;
                    break;
                }
            }
        }
        return customer;
    }

// Just call this method to find a product in the array by its id.
// Returns null if not found.
    public final Product findProduct(final String prodId) {
        Product product = null;
        if (stringIsValid(prodId, "prodId") ) {
            for(Product p : products) {
                if(prodId.equals(p.getProductId())) {
                    product = p;
                    break;
                }
            }
        }
        return product;
    }
    
    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in FakeDatabase");
    }
	
    private boolean stringIsValid(String st, String variableName) {
        boolean valid = true;
        if (st == null || st.length() == 0) {
            valid = false;
            showError("Invalid string " + variableName);
        }
        return valid;
    }

} // end of class

