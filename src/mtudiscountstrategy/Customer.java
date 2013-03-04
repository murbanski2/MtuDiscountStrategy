package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public class Customer {
    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        //testString, testString
        this.custId = custId;
        this.custName = custName;
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId) {
        //testString
        this.custId = custId;
    }

    public final String getCustName() {
        return custName;
    }

    public final void setCustName(String custName) {
        //testString
        this.custName = custName;
    }
    
    
    
}
