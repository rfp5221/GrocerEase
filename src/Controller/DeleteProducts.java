package Controller;

import Model.Product;
import Model.ShoppingList;

public class DeleteProducts {
  // TODO 09 - DeleteProducts: Make a debug log entry for each item deleted (See GrocerEase.log sample in assignment)

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
