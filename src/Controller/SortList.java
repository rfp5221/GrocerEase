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
    // This line is here just so the code compiles.  You need to set it similarly to how sort-by was set
    ShoppingListSort.ProductSortDirection productSortDirection = ShoppingListSort.ProductSortDirection.ASCENDING;

    /*
     * Do the sort
     */
    ShoppingListSort shoppingListSort = new ShoppingListSort(productSortBy, productSortDirection);

    shoppingList.sortList(shoppingListSort);

  }
}
