/*

######   #######      #     #  #######  #######      #######  ######   ###  ####### 
#     #  #     #      ##    #  #     #     #         #        #     #   #      #    
#     #  #     #      # #   #  #     #     #         #        #     #   #      #    
#     #  #     #      #  #  #  #     #     #         #####    #     #   #      #    
#     #  #     #      #   # #  #     #     #         #        #     #   #      #    
#     #  #     #      #    ##  #     #     #         #        #     #   #      #    
######   #######      #     #  #######     #         #######  ######   ###     #

                                                                          
              ######   #######  #        #######  #     # 
              #     #  #        #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              ######   #####    #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              #     #  #        #        #     #  #  #  # 
              ######   #######  #######  #######   ## ##  
*/
package TD03.Model;

import Model.Product;
import Model.ShoppingList;
import Model.ShoppingListSort;
import Model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingListTest {
  private static ShoppingList testShoppingList;
  private static Product productBread;
  private static Product productMilk;
  private static Product productWaffles;

  @BeforeAll
  static void init() {
    Controller.Main.printTeamInfo();
  }

  @BeforeEach
  void setUp() {
    testShoppingList = new ShoppingList();
    testShoppingList.setName("My Test List");

    productBread = new Product();
    productBread.setName("Bread");
    productBread.setPrice(1.23);
    productBread.setQuantity(2);
    productBread.setUom(UnitOfMeasure.EA);
    testShoppingList.addProduct(productBread);

    snooze(200); // Ensure time passes; for sorting by creating date/time

    productWaffles = new Product();
    productWaffles.setName("Waffles");
    productWaffles.setPrice(6.50);
    productWaffles.setQuantity(1);
    productWaffles.setUom(UnitOfMeasure.BOX);
    testShoppingList.addProduct(productWaffles);

    snooze(200); // Ensure time passes; for sorting by creating date/time

    productMilk = new Product();
    productMilk.setName("Milk");
    productMilk.setPrice(4.50);
    productMilk.setQuantity(1);
    productMilk.setUom(UnitOfMeasure.GAL);
    testShoppingList.addProduct(productMilk);
  }

  private void testSort(Product[] expected, List<Product> actual, String testInfo) {
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual.get(i), testInfo);
    }
  }

  @Test
  void sortList__sort_by_various_orders__return_sorted_list() {
    // So we don't need to call getProducts() repeatedly
    List<Product> products = testShoppingList.getProducts();

    ShoppingListSort sortByNameAscending = new ShoppingListSort(ShoppingListSort.ProductSortBy.NAME, ShoppingListSort.ProductSortDirection.ASCENDING);
    testShoppingList.sortList(sortByNameAscending);
    testSort(new Product[]{productBread, productMilk, productWaffles}, products, "Sort by name, ascending");

    ShoppingListSort sortByNameDescending = new ShoppingListSort(ShoppingListSort.ProductSortBy.NAME, ShoppingListSort.ProductSortDirection.DESCENDING);
    testShoppingList.sortList(sortByNameDescending);
    testSort(new Product[]{productWaffles, productMilk, productBread}, products, "Sort by name, descending");

    ShoppingListSort sortByCreationAscending = new ShoppingListSort(ShoppingListSort.ProductSortBy.CREATION_DATE, ShoppingListSort.ProductSortDirection.ASCENDING);
    testShoppingList.sortList(sortByCreationAscending);
    testSort(new Product[]{productBread, productWaffles, productMilk}, products, "Sort by creation, ascending");

    ShoppingListSort sortByCreationDescending = new ShoppingListSort(ShoppingListSort.ProductSortBy.CREATION_DATE, ShoppingListSort.ProductSortDirection.DESCENDING);
    testShoppingList.sortList(sortByCreationDescending);
    testSort(new Product[]{productMilk, productWaffles, productBread}, products, "Sort by creation, descending");
  }

  private void snooze(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
