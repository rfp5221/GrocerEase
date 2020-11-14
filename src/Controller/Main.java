package Controller;

import Model.ShoppingList;
import Model.ShoppingListBank;
import Model.ShoppingListMaintenance;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
  private final static Logger logger = LogManager.getRootLogger();
  private static ShoppingListBank shoppingListBank = new ShoppingListBank();
  private static ShoppingList activeShoppingList = null;

  public static void printTeamInfo() {
    // TODO 00 - Put your team info here
    // Nick Guenther (nwg5171@psu.edu; github: nwg5171)
    System.out.println("Team Number: 5");
    System.out.println("Alexander Alekseev (email: aza5975@psu.edu; github: aza5975)");
    System.out.println("Nickolas Guenther (email: nwg5171@psu.edu; github: nwg5171)");
    System.out.println("Yihang Liu (email: yvl5590@psu.edu; github: yihang314)");
    System.out.println("Rush Patel (email: rfp5221@psu.edu; github: rfp5221)");
    System.out.println("Course: IST 261");
    System.out.println("Assignment: TD03");
  }

  public static void main(String[] args) {
    logger.debug("Program started");
    printTeamInfo();

    System.out.println();
    ShoppingListMaintenance.loadListsFromStorage(shoppingListBank);

    Menu mainMenu = new Menu("GrocerEase");
    MenuChoice mcCreateList = mainMenu.addMenuChoice("Create List");
    MenuChoice mcImportList = mainMenu.addMenuChoice("Import List");
    MenuChoice mcChooseList = mainMenu.addMenuChoice("Choose Active List");
    MenuChoice mcExportList = mainMenu.addMenuChoice("Export Active List");
    MenuChoice mcUseList = mainMenu.addMenuChoice("Use Active List");

    MenuDisplay mdMainMenu = new MenuDisplay(mainMenu);
    while (true) {
      if (activeShoppingList != null) {
        String listName = activeShoppingList.getName();
        mainMenu.setTitle("GrocerEase: " + listName);
      }
      MenuChoice choice = mdMainMenu.displayAndChoose();
      if (choice == mainMenu.getMenuChoiceQuit()) {
        break;

      } else if (choice == mcChooseList) {
        activeShoppingList = Controller.ChooseShoppingList.chooseShoppingList(shoppingListBank);

      } else if (choice == mcCreateList) {
        activeShoppingList = CreateList.createList();
        shoppingListBank.addShoppingList(activeShoppingList);

      } else if (choice == mcImportList) {
        activeShoppingList = ImportExport.importList();
        if (activeShoppingList != null) {
          shoppingListBank.addShoppingList(activeShoppingList);
        }

      } else if (choice == mcExportList) {
        if (activeShoppingList == null) {
          System.out.println("Need to set an active shopping list first");
        } else {
          ImportExport.exportList(activeShoppingList);
        }

      } else if (choice == mcUseList) {
        if (activeShoppingList == null) {
          System.out.println("Need to set an active shopping list first");
        } else {
          ListActivity.listActivity(activeShoppingList);
        }

      }
    }

    logger.debug("Program ended");
  }

}
