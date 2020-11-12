package Controller;

import Model.ShoppingList;
import Model.ShoppingListBank;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class ChooseShoppingList {
  public static ShoppingList chooseShoppingList(ShoppingListBank shoppingListBank) {
    Menu menuChooseList = new Menu("Choose Shopping List");
    for (ShoppingList list : shoppingListBank.getAllShoppingLists()) {
      MenuChoice mc = menuChooseList.addMenuChoice(list.getName());
      mc.setObject(list);
    }

    MenuDisplay menuDisplay = new MenuDisplay(menuChooseList);
    MenuChoice choice = menuDisplay.displayAndChoose();
    if (choice == menuChooseList.getMenuChoiceQuit()) {
      return null;
    }

    return (ShoppingList) choice.getObject();
  }
}
