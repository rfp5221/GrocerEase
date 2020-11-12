package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    // TODO 01 Put this in when Phil publishes it
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
