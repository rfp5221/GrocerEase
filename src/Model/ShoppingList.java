package Model;

import java.util.*;

import static java.util.Comparator.comparing;

public class ShoppingList {
  private String name;

  private List<Product> products = new ArrayList<>();

  public void addProduct(Product product) {
    products.add(product);
  }

  public void removeProduct(Product product) {
    products.remove(product);
  }

  public boolean containsProduct(Product product) {
    return products.contains(product);
  }

  public boolean productNameInUse(String productName) {
    for (Product p : products) {
      if (p.getName().equalsIgnoreCase(productName)) {
        return true;
      }
    }
    return false;
  }

  public void putInCart(Product product) {
    product.setInCart(true);
  }

  public void removeFromCart(Product product) {
    product.setInCart(false);
  }

  public double getTotalNetPrice() {
    return getTotalNetPrice(products);
  }

  public double getCartNetPrice() {
    return getTotalNetPrice(getProductsInCart());
  }

  private double getTotalNetPrice(List<Product> products) {
    double totalNetPrice = 0;

    for (Product p : products) {
      totalNetPrice += p.getPrice() * p.getQuantity();
    }

    return totalNetPrice;

  }

  public int getProductCount() {
    return products.size();
  }

  public void sortList(ShoppingListSort sortMethod) {
    // TODO 01 Put this in when Phil publishes. I have done so already. -Nick Guenther
    // Nick Guenther (nwg5171@psu.edu; github: nwg5171)
    Comparator<Product> comparator = null;

    switch (sortMethod.getSortMethod()) {
      case NAME:
        comparator = comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);
        break;
      case CREATION_DATE:
        comparator = comparing(Product::getCreated);
        break;
    }

    if (sortMethod.getSortDirection() == ShoppingListSort.ProductSortDirection.DESCENDING) {
      comparator = comparator.reversed();
    }

    Collections.sort(this.products, comparator);

  }

  @Override
  public boolean equals(Object other) {
    ShoppingList otherList = (ShoppingList) other;

    boolean namesMatch = Objects.equals(otherList.getName(), this.getName());
    boolean listsMatch = Objects.equals(otherList.getProducts(), this.getProducts());

    return (namesMatch && listsMatch);
  }

  /* * * * * * * * * * * * * *  GETTERS AND SETTERS * * * * * * * * * * * * * */

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Product> getProducts() {
    return products;
  }

  public List<Product> getProductsInCart() {
    return filterProductsByCart(true);
  }

  public List<Product> getProductsNotInCart() {
    return filterProductsByCart(false);
  }

  public List<Product> filterProductsByCart(boolean wantInCart) {
    List<Product> filteredProducts = new ArrayList<>();
    for (Product p : products) {
      if (p.getInCart() == wantInCart) {
        filteredProducts.add(p);
      }
    }
    return filteredProducts;
  }

}
