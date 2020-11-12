package Controller;

import Model.ShoppingList;
import View.IOHelper;

public class CreateList {
  public static ShoppingList createList() {
    ShoppingList shoppingList = new ShoppingList();

    shoppingList.setName(IOHelper.readNonBlankStringFromKeyboard("Name of list"));
    AddProducts.addProducts(shoppingList);

    return shoppingList;
  }
}
