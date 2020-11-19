package Controller;

import Model.Obj;
import Model.Product;
import Model.ShoppingList;

import Model.UnitOfMeasure;
import View.IOHelper;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import org.apache.log4j.*;

public class AddProducts {
  // TODO 08 - AddProducts: Make a debug log entry for each item added (See GrocerEase.log sample in assignment)
  // Rushi Patel (rfp5221@psu.edu; github:rfp5221)
  private static Logger logger = Logger.getLogger(AddProducts.class.getName());

  public static void addProducts(ShoppingList shoppingList) {
    // TODO 05 - Write Controller.AddProducts.addProducts (Hint: this can be done in 6 lines)
    // Yihang Liu (email: yvl5590@psu.edu; github: yihang314)
    // Rushi Patel (rfp5221@psu.edu; github:rfp5221)

    String userInput = "Y";

    while(userInput.equals("Y")){
      Product product = new Product();
      if(product == null){
        break;
      }
      else{
        EditProducts.editOneProduct(product);
      }
      shoppingList.addProduct( product );
      userInput = IOHelper.strUserInputYorN("Another product?");
    }
  }
}
