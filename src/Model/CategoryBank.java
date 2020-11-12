package Model;

import java.util.ArrayList;
import java.util.List;

public class CategoryBank {
  private static final List<Category> allCategories = new ArrayList<Category>();
  private static final Category defaultCategory = new Category("General");

  static {
    allCategories.add(defaultCategory);
    addCategory("Cleaner");
    addCategory("Bathroom");
    addCategory("Dairy");
    addCategory("Kitchen");
  }

  public static Category addCategory(String name) {
    Category newCategory = new Category(name);
    allCategories.add(newCategory);
    return newCategory;
  }

  public static List<Category> getAllCategories() {
    return allCategories;
  }

  public static Category getDefaultCategory() {
    return defaultCategory;
  }
}
