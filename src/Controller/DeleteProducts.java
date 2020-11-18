package Controller;

import Model.Product;
import Model.ShoppingList;
import org.apache.log4j.Logger;

public class DeleteProducts {
  // TODO 09 - DeleteProducts: Make a debug log entry for each item deleted (See GrocerEase.log sample in assignment)
  // Rushi Patel (rfp5221@psu.edu; github:rfp5221)
  private static Logger logger = Logger.getLogger(DeleteProducts.class.getName());

  public static void deleteProducts(ShoppingList shoppingList) {
    while (true) {
      Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
      if (product == null) {
        break;
      }
      shoppingList.removeProduct(product);
    }
  }
}
