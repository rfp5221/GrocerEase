package Model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class ShoppingListMaintenance {
  private static final Logger logger = LogManager.getRootLogger();

  /*
   * NL is a common abbreviation for New Line.
   * System.lineSeparator works for Windows, Mac, and Linux.
   * Safer than just using "\n"
   */
  private static final String NL = System.lineSeparator();

  public static void moveProducts(List<Product> products, ShoppingList source, ShoppingList target) {
    for (Product p : products) {
      target.addProduct(p);
      source.removeProduct(p);
    }

  }

  public static void copyProducts(List<Product> products, ShoppingList source, ShoppingList target) {
    for (Product p : products) {
      target.addProduct(p.copy());
    }

  }

  public static void removeProductsFromCart(ShoppingList shoppingList) {

  }

  public static boolean exportList(ShoppingList shoppingList, String fullPath) {
    // TODO 02 - Put this in when Phil publishes it

    return true;

  }

  public static ShoppingList importList(String filePath) {
    return importList(Paths.get(filePath));
  }

  public static ShoppingList importList(Path filePath) {
    // TODO 03 - Put this in when Phil publishes it

    ShoppingList newShoppingList = new ShoppingList();

    return newShoppingList;

  }

  public static void loadListsFromStorage(ShoppingListBank bank) {
    try (Stream<Path> paths = Files.walk(Paths.get("ListStorage")).filter(Files::isRegularFile)) {
      paths.forEach(p -> {
        System.out.printf("Restoring list from '%s/%s'%n", p.getParent(), p.getFileName());
        bank.addShoppingList(importList(p));
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
