/*
* Date: 2021-09-07.
* File Name: InvoiceTest.Java
* Author: Rickard Marjanovic
*
*/

/**
 * Class Description: This class is to test out the invoice class.
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */

public class InvoiceTest {
    public static void main(String args[]) {
        Invoice i1 = new Invoice("1", "CarPart", 100, 10);
        i1.getInvoiceAmount(); // 1000.0
        System.out.println(i1.getInvoiceAmount());
        i1.getPartDescription(); // CarPart
        System.out.println(i1.getPartDescription());
        i1.setPartDescription("SomethingElse");
        i1.getPartDescription(); // SomethingElse
        System.out.println(i1.getPartDescription());

        Invoice i2 = new Invoice("2", "CarPart2", -10, -20);
        i2.getQuantity(); // 0
        System.out.println(i2.getQuantity());
        i2.getPricePerItem(); // 0.0
        System.out.println(i2.getPricePerItem());
        i2.getInvoiceAmount(); // 0.0
        System.out.println(i2.getInvoiceAmount());
        i2.setQuantity(10);
        i2.setPricePerItem(10);
        i2.getInvoiceAmount(); // 100.0
        System.out.println(i2.getInvoiceAmount());
    }
}
