package Model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileWriter;
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
    // TODO 02 - Put this in when Phil publishes it. I have done so already. -Nick Guenther
    // Nick Guenther (nwg5171@psu.edu; github: nwg5171)

    try {
      FileWriter outFile = new FileWriter(fullPath);
      outFile.write(shoppingList.getName() + NL);
      for (Product p : shoppingList.getProducts()) {
        outFile.write(String.format(
                "%s,%s,%s,%s%n",
                p.getName(),
                p.getPrice(),
                p.getQuantity(),
                p.getUom()
        ));
      }
      outFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


    return true;

  }

  public static ShoppingList importList(String filePath) {
    return importList(Paths.get(filePath));
  }

  public static ShoppingList importList(Path filePath) {
    // TODO 03 - Put this in when Phil publishes it. I have done so already. -Nick Guenther
    // Nick Guenther (nwg5171@psu.edu; github: nwg5171)

    ShoppingList newShoppingList = new ShoppingList();

    List<String> allLines = null;
    try {
      allLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // First line is the name of the shopping list
    newShoppingList.setName(allLines.get(0));

    // Skip over that first line
    for (String line : allLines.subList(1, allLines.size())) {
      String[] fields = line.split(",");
      Product product = new Product();
      product.setName(fields[0]);
      product.setPrice(Double.parseDouble(fields[1]));
      product.setQuantity(Double.parseDouble(fields[2]));
      product.setUom(UnitOfMeasure.valueOf(fields[3]));
      newShoppingList.addProduct(product);
    }

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
