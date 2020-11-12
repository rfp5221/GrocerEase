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
    System.out.println("Team Number: X");
    System.out.println("Jo Student (email: jxs5123@psu.edu; github: jstu)");
    System.out.println("James Gosling (email: jag5789@psu.edu; github: java_guru)");
    System.out.println("Course: IST 261");
    System.out.println("Assignment: TD0X");
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
