package Controller;

import Model.Obj;
import Model.Product;
import Model.ShoppingList;
import View.IOHelper;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class EditProducts {
  public static void editProducts(ShoppingList shoppingList) {
    Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
    editOneProduct(product);
  }

  public static void editOneProduct(Product product) {
    Menu menu = new Menu("Edit the Values");
    MenuChoice mcEditName = menu.addMenuChoice("");
    // TODO 06 - Controller.EditProducts.editOneProduct: handle quantity, uom, and price

    MenuDisplay menuDisplay = new MenuDisplay(menu);
    while (true) {
      mcEditName.setText("Name: " + Obj.coalesce(product.getName(), "<not set>"));

      MenuChoice menuChoice = menuDisplay.displayAndChoose();
      if (menuChoice == menu.getMenuChoiceQuit()) {
        return;
      }

      if (menuChoice == mcEditName) {
        product.setName(IOHelper.readNonBlankStringFromKeyboard("Name"));
      }
    }

  }
}
