package Controller;

import Model.Product;
import Model.ShoppingList;
import View.IOHelper;

public class ListProducts {
  private static String productInfo(Product product) {
    String format = "%s %s %s (%s per %s) ";
    return String.format(format, product.getQuantity(), product.getUom(), product.getName(), IOHelper.currency(product.getPrice()), product.getUom());
  }
  public static void listProducts(ShoppingList shoppingList) {
    System.out.println();
    System.out.println(String.format("-= %s =-", shoppingList.getName()));
    System.out.println("NOT IN CART:");
    for (Product p : shoppingList.getProductsNotInCart()) {
      System.out.println(productInfo(p));
    }
    System.out.println();
    System.out.println("IN CART:");
    for (Product p : shoppingList.getProductsInCart()) {
      System.out.println(productInfo(p));
    }
    System.out.println();

    System.out.println("Grand Total: " + IOHelper.currency(shoppingList.getTotalNetPrice()));
    System.out.println("Cart Total: " +  IOHelper.currency(shoppingList.getCartNetPrice()));
  }
}
