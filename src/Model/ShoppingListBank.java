package Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListBank {
  private List<ShoppingList> allShoppingLists = new ArrayList<>();

  public List<ShoppingList> getAllShoppingLists() {
    return allShoppingLists;
  }

  public ShoppingList createNewShoppingList() {
    ShoppingList newShoppingList = new ShoppingList();
    allShoppingLists.add(newShoppingList);
    return newShoppingList;
  }

  public void addShoppingList(ShoppingList list) {
    allShoppingLists.add(list);
  }

  public void removeShoppingList(ShoppingList shoppingList) {
    allShoppingLists.remove(shoppingList);
  }

  public boolean containsShoppingList(ShoppingList shoppingList) {
    return allShoppingLists.contains(shoppingList);
  }
}
