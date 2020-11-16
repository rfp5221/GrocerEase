package Controller;

import Model.ShoppingList;
import Model.ShoppingListSort;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class SortList {
  public static void sortList(ShoppingList shoppingList) {
    /*
     * Sort by
     */
    Menu menuSortBy = new Menu("Sort By");

    MenuChoice sortByName = menuSortBy.addMenuChoice("Name");
    sortByName.setObject(ShoppingListSort.ProductSortBy.NAME);

    MenuChoice sortByDate = menuSortBy.addMenuChoice("Date Created");
    sortByDate.setObject(ShoppingListSort.ProductSortBy.CREATION_DATE);

    MenuDisplay menuDisplaySortBy = new MenuDisplay(menuSortBy);
    MenuChoice sortByChoice = menuDisplaySortBy.displayAndChoose();
    if (sortByChoice == menuSortBy.getMenuChoiceQuit()) {
      return;
    }

    ShoppingListSort.ProductSortBy productSortBy = (ShoppingListSort.ProductSortBy) sortByChoice.getObject();
    /*
     * Sort direction
     */

    // TODO 07 - Controller.SortList.sortList: Add code for the sort direction (ascending/descending)

    Menu menuSortDirection = new Menu("Sort Direction");

    MenuChoice sortAscending = menuSortDirection.addMenuChoice("Ascending");
    sortAscending.setObject(ShoppingListSort.ProductSortDirection.ASCENDING);

    MenuChoice sortDescending = menuSortDirection.addMenuChoice("Descending");
    sortDescending.setObject(ShoppingListSort.ProductSortDirection.DESCENDING);

    MenuDisplay menuDisplaySortDirection = new MenuDisplay(menuSortDirection);
    MenuChoice sortByDirection = menuDisplaySortDirection.displayAndChoose();


    if (sortByDirection == menuSortDirection.getMenuChoiceQuit()) {
      return;
    }

    ShoppingListSort.ProductSortDirection productSortDirection = (ShoppingListSort.ProductSortDirection) sortByDirection.getObject();


    /*
     * Do the sort
     */

    ShoppingListSort shoppingListSort = new ShoppingListSort(productSortBy, productSortDirection);

    shoppingList.sortList(shoppingListSort);

  }
}
