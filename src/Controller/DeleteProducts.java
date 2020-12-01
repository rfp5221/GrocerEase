package Controller;

import Model.Product;
import Model.ShoppingList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DeleteProducts {
  // TODO 09 - DeleteProducts: Make a debug log entry for each item deleted (See GrocerEase.log sample in assignment)
  // Yihang Liu (email: yvl5590@psu.edu; github: yihang314)
  private static final Logger logger = LogManager.getRootLogger();

  public static void deleteProducts(ShoppingList shoppingList) {
    while (true) {
      Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
      if (product == null) {
        break;
      }
      shoppingList.removeProduct(product);
      logger.debug("Deleted item '" + product.getName() + "' from list '" + shoppingList.getName() + "'");
    }
  }
}
