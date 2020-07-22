import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Nancy Chauhan
 */
public class InventoryNeeded {
    public static final String PATHOFFILETOREAD = "src/inventory.txt";
    public static final String PATHOFFILETOWRITE = "src/inventoryNeeded.txt";

    public static void main(String[] args) {

        Scanner scan = null;
        PrintWriter writer = null;
        try {

            if (PATHOFFILETOREAD.equals(null) || PATHOFFILETOREAD.equals("")) {
                System.out.println("Path of file can not me null or empty.");
                System.exit(0);
            } else {
                scan = new Scanner(new File(PATHOFFILETOREAD));

                writer = new PrintWriter(PATHOFFILETOWRITE);

                while (scan.hasNext()) {
                    String partNumber = scan.next();
                    int quantity = scan.nextInt();
                    int sales = scan.nextInt();
                    int reqSale = scan.nextInt();

                    writer.println("Part Number: " + partNumber);
                    writer.println("Current Balance: " + (quantity - sales));
                    writer.println("Amount Needed: " + (reqSale - (quantity - sales)));
                    writer.println("");

                }
                System.out.println("Inventory written successfully to path : \n" + PATHOFFILETOWRITE);
            }

        } catch (Exception e) { // catching the exception
            System.out.println("ERROR!");
            e.printStackTrace();
        } finally { // The finally block will always execute. Closing opened resources here.
            if (scan != null)
                scan.close();
            if (writer != null)
                writer.close();
        }
    }
}