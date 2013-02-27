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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        //testString
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        //testString
        this.custName = custName;
    }
    
    
    
}
