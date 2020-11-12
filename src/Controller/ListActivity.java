package Controller;

import Model.ShoppingList;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class ListActivity {
  private static MenuChoice mcListProducts = new MenuChoice("List Products");
  private static MenuChoice mcEditProducts = new MenuChoice("Edit Products");
  private static MenuChoice mcCartProducts = new MenuChoice("Cart/Uncart Products");
  private static MenuChoice mcAddProducts = new MenuChoice("Add Products");
  private static MenuChoice mcDeleteProducts = new MenuChoice("Delete Products");
  private static MenuChoice mcSortList = new MenuChoice("Sort List");

  private static Menu menuActivityForList(ShoppingList shoppingList) {
    Menu menuActivity = new Menu(shoppingList.getName());
    menuActivity.addMenuChoice(mcListProducts);
    menuActivity.addMenuChoice(mcEditProducts);
    menuActivity.addMenuChoice(mcCartProducts);
    menuActivity.addMenuChoice(mcAddProducts);
    menuActivity.addMenuChoice(mcDeleteProducts);
    menuActivity.addMenuChoice(mcSortList);
    return menuActivity;
  }
  public static void listActivity(ShoppingList shoppingList) {
    Menu menuActivityForList = menuActivityForList(shoppingList);
    MenuDisplay mdActivityForList = new MenuDisplay(menuActivityForList);
    while (true) {
      MenuChoice activity = mdActivityForList.displayAndChoose();
      if (activity == menuActivityForList.getMenuChoiceQuit()) {
        break;
      } else {
        processActivity(activity, shoppingList);
      }
    }

  }

  private static void processActivity(MenuChoice activity, ShoppingList shoppingList) {
    if (activity == mcListProducts) {
      ListProducts.listProducts(shoppingList);

    } else if (activity == mcCartProducts) {
      CartProducts.cartProducts(shoppingList);

    } else if (activity == mcAddProducts) {
      AddProducts.addProducts(shoppingList);

    } else if (activity == mcEditProducts) {
      EditProducts.editProducts(shoppingList);

    } else if (activity == mcDeleteProducts) {
      DeleteProducts.deleteProducts(shoppingList);

    } else if (activity == mcSortList) {
      SortList.sortList(shoppingList);

    }

  }
}
