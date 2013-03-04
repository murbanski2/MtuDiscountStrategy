package mtudiscountstrategy;

/**
 *
 * @author Mark Urbanski
 */
public class CashRegister {
    private Receipt receipt;
    
    public final void startSale(String custId) {
        receipt = new Receipt(custId);
    }
    
    public final void scanItem(String prodId, int quantity) {
        receipt.addItemToSale(prodId, quantity);
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
}
