package Controller;

import Model.Product;
import Model.ShoppingList;
import View.ProductDisplay;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class ChooseProduct {
  public static Product chooseProduct(ShoppingList shoppingList, ProductDisplay productDisplay) {
    Menu menu = new Menu("Choose Product");
    for (Product product : shoppingList.getProducts()) {
      MenuChoice mc = menu.addMenuChoice(productDisplay.display(product));
      mc.setObject(product);
    }

    MenuDisplay menuDisplay = new MenuDisplay(menu);
    MenuChoice menuChoice = menuDisplay.displayAndChoose();
    if (menuChoice == menu.getMenuChoiceQuit()) {
      return null;
    }
    Product product = (Product) menuChoice.getObject();

    return product;
  }
}
