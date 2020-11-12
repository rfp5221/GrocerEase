package Model;

public class ShoppingListSort {
  public enum ProductSortBy {
    MANUAL,
    NAME,
    CREATION_DATE
  }

  public enum ProductSortDirection {
    ASCENDING,
    DESCENDING
  }

  private ProductSortBy sortMethod;
  private ProductSortDirection sortDirection;

  public ShoppingListSort(ProductSortBy sortMethod, ProductSortDirection sortDirection) {
    this.sortMethod = sortMethod;
    this.sortDirection = sortDirection;
  }


  public ProductSortBy getSortMethod() {
    return sortMethod;
  }

  public void setSortMethod(ProductSortBy sortMethod) {
    this.sortMethod = sortMethod;
  }

  public ProductSortDirection getSortDirection() {
    return sortDirection;
  }

  public void setSortDirection(ProductSortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }
}
