/*

######   #######      #     #  #######  #######      #######  ######   ###  ####### 
#     #  #     #      ##    #  #     #     #         #        #     #   #      #    
#     #  #     #      # #   #  #     #     #         #        #     #   #      #    
#     #  #     #      #  #  #  #     #     #         #####    #     #   #      #    
#     #  #     #      #   # #  #     #     #         #        #     #   #      #    
#     #  #     #      #    ##  #     #     #         #        #     #   #      #    
######   #######      #     #  #######     #         #######  ######   ###     #

                                                                          
              ######   #######  #        #######  #     # 
              #     #  #        #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              ######   #####    #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              ######   #######  #######  #######   ## ##  
*/
                                                                  
package TD03.Model;

import Model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingListMaintenanceTest {
  private static ShoppingList testShoppingList1;
  private static Product product1;
  private static Product product2;

  private static ShoppingList testShoppingList2;
  private static Product product3;
  private static Product product4;


  @BeforeAll
  static void init() {
    Controller.Main.printTeamInfo();
  }

  @BeforeEach
  void setUp() {
    ShoppingListBank shoppingListBank = new ShoppingListBank();

    /*
     * Shopping list 1
     */
    testShoppingList1 = shoppingListBank.createNewShoppingList();
    testShoppingList1.setName("First List");

    product1 = new Product();
    product1.setName("Bread");
    product1.setPrice(1.23);
    product1.setQuantity(2);
    product1.setUom(UnitOfMeasure.EA);
    testShoppingList1.addProduct(product1);

    product2 = new Product();
    product2.setName("Milk");
    product2.setPrice(4.50);
    product2.setQuantity(1);
    product2.setUom(UnitOfMeasure.GAL);
    testShoppingList1.addProduct(product2);

    /*
     * Shopping list 2
     */
    testShoppingList2 = shoppingListBank.createNewShoppingList();
    testShoppingList2.setName("Second List");

    product3 = new Product();
    product3.setName("Cheese");
    product3.setPrice(1.50);
    product3.setQuantity(1);
    product3.setUom(UnitOfMeasure.LB);
    testShoppingList2.addProduct(product3);

    product4 = new Product();
    product4.setName("Eggs");
    product4.setPrice(3.25);
    product4.setQuantity(1);
    product4.setUom(UnitOfMeasure.CARTON);
    testShoppingList2.addProduct(product4);

  }

  /*
   * This one has to break the naming rule, because we have to test two
   * different methods, and the ordering counts.  JUnit does not let you
   * specify the order of tests.  So, we need to create method in which we
   * control the order of the calls to the methods.
   */
  @Test
  void exportThenImportList__run_export_then_export__data_was_persisted_correctly() {
    /*
     * We won't use the full path, because we want to ensure this file is saved
     * under the GrocerEase folder.
     * Comment is intentionally left here for reference, to show what a "full
     * path" is.  Note that some people call that an "absolute path".
     */
    // String fullPath = "C:\\Temp\\testShoppingList1.txt";

    /*
     * Since this is not a full path, it will get written under the
     * GrocerEase/ImportExport folder in the project.  So you'll find it there
     * if you want to take a look.
     */
    for (ShoppingList list : Arrays.asList(testShoppingList1, testShoppingList2)) {
      String fullPath = "ImportExport/" + list.getName() + ".txt";

      /*
       * Delete the target file, in case there's one left over from the last
       * time we did this test.
       */
      try {
        Files.deleteIfExists(Paths.get(fullPath));
      } catch (IOException e) {
        e.printStackTrace();
      }

      // Export the shopping list
      ShoppingListMaintenance.exportList(list, fullPath);

      // Import the shopping list
      ShoppingList imported = ShoppingListMaintenance.importList(fullPath);

      // The content should match between the original and the imported
      String message = String.format("Import of '%s' should match existing '%s'", fullPath, list.getName());
      assertEquals(list, imported, message);
    }

  }
}
