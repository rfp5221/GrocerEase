package Controller;

import Model.Product;
import Model.ShoppingList;

import View.IOHelper;
import org.apache.log4j.*;

public class AddProducts {
  // TODO 08 - AddProducts: Make a debug log entry for each item added (See GrocerEase.log sample in assignment)
  // Rushi Patel (rfp5221@psu.edu; github:rfp5221)
  private static Logger logger = Logger.getLogger(AddProducts.class.getName());

  public static void addProducts(ShoppingList shoppingList) {
    // TODO 05 - Write Controller.AddProducts.addProducts (Hint: this can be done in 6 lines)
    // Rushi Patel (rfp5221@psu.edu; github:rfp5221)

    while(true){
      Product product = new Product();
      if(product == null){
        break;
      }
      else{
        EditProducts.editOneProduct( product );

      }
      shoppingList.addProduct( product );
      break;
    }

  }
}
