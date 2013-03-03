package mtudiscountstrategy;

/**
 *
 * @author murbanski
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Do first cash register
        CashRegister cr1 = new CashRegister();
        cr1.startSale("200");
        cr1.scanItem("C222", 6);
        cr1.scanItem("B205", 4);
        cr1.scanItem("A101", 16);
        cr1.endSale();
        
        //Do second cash register
        CashRegister cr2 = new CashRegister();
        cr2.startSale("300");
        cr2.scanItem("C222", 2);
        cr2.scanItem("B205", 5);
        cr2.scanItem("A101", 5);
        cr2.endSale();
        
        //Do third cash register
        CashRegister cr3 = new CashRegister();
        cr3.startSale("100");
        cr3.scanItem("C222", 1);
        cr3.scanItem("B205", 6);
        cr3.scanItem("A101", 6);
        cr3.endSale();
    }
}
