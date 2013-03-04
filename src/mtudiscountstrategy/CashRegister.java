package mtudiscountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */
public class CashRegister {
    private Receipt receipt;
    
    public final void startSale(String custId) {
        if (stringIsValid(custId, "custId") ) {
            receipt = new Receipt(custId);
        }
    }
    
    public final void scanItem(String prodId, int quantity) {
        if (stringIsValid(prodId, "prodId") && 
                intIsValid(quantity, "quantity") ) {
            receipt.addItemToSale(prodId, quantity);
        }
    }
    
    public final void endSale() {
        receipt.getReceipt();
    }
    
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        cr.startSale("200");
        cr.scanItem("C222", 6);
        cr.scanItem("B205", 4);
        cr.scanItem("A101", 16);
        cr.endSale();
        
    }

    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in CashRegister");
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
