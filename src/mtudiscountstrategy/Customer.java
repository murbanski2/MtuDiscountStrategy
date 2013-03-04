package mtudiscountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Mark Urbanski
 */
public class Customer {
    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        if (stringIsValid(custId, "custId") && 
                stringIsValid(custName, "custName")) {
            this.custId = custId;
            this.custName = custName;
        }
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId) {
        if (stringIsValid(custId, "custId")) {
            this.custId = custId;
        }
    }

    public final String getCustName() {
        return custName;
    }

    public final void setCustName(String custName) {
        //testString
        this.custName = custName;
    }
    
    private void showError(String error ) {
        JOptionPane.showMessageDialog(null, error + " in Customer");
    }
	
    private boolean stringIsValid(String st, String variableName) {
        boolean valid = true;
        if (st == null || st.length() == 0) {
            valid = false;
            showError("Invalid string " + variableName);
        }
        return valid;
    }
    
}
