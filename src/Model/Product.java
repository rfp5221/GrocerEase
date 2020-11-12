package Model;

import java.time.LocalDateTime;
import java.util.List;

public class Product {
  private static List<Category> categories;

  private String name;
  private UnitOfMeasure uom;
  private double price;
  private double quantity;
  private boolean isTaxable;
  private String upc = "";
  private String note = "";
  private LocalDateTime created;
  private boolean inCart;
  private boolean hasCoupon;


  public Product() {
    created = LocalDateTime.now();
  }

  public static List<Category> getCategories() {
    return categories;
  }

  public static void setCategories(List<Category> categories) {
    Product.categories = categories;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UnitOfMeasure getUom() {
    return uom;
  }

  public void setUom(UnitOfMeasure uom) {
    this.uom = uom;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public boolean getIsTaxable() {
    return isTaxable;
  }

  public void setIsTaxable(boolean isTaxable) {
    this.isTaxable = isTaxable;
  }

  public LocalDateTime getCreated() {
    System.out.println(created);
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public boolean getInCart() {
    return inCart;
  }

  public void setInCart(boolean inCart) {
    this.inCart = inCart;
  }

  public boolean getHasCoupon() {
    return hasCoupon;
  }

  public void setHasCoupon(boolean hasCoupon) {
    this.hasCoupon = hasCoupon;
  }

  @Override
  public boolean equals(Object object) {
    Product other = (Product) object;
    return
        this.getName().equals(other.getName())
            && this.getUom().equals(other.getUom())
            && (Double.compare(this.getPrice(), other.getPrice()) == 0)
            && (Double.compare(this.getQuantity(), other.getQuantity()) == 0)
            && (this.getIsTaxable() == other.getIsTaxable())
            && this.getUpc().equals(other.getUpc())
            && this.getNote().equals(other.getNote())
            && (this.getInCart() == other.getInCart())
            && (this.getHasCoupon() == other.getHasCoupon())


        /*
         * Don't include this, because when it's a copy, it will be different.
         * So, it will falsely tell us it's not equal.
         */
        // && this.getCreated().equals(other.getCreated())
        ;
  }

  public Product copy() {
    Product newProduct = new Product();

    newProduct.setName(this.name);
    newProduct.setUom(this.uom);
    newProduct.setPrice(this.price);
    newProduct.setQuantity(this.quantity);
    newProduct.setIsTaxable(this.isTaxable);
    newProduct.setUpc(this.upc);
    newProduct.setNote(this.note);
    newProduct.setCreated(this.created);
    newProduct.setInCart(this.inCart);
    newProduct.setHasCoupon(this.hasCoupon);

    return newProduct;
  }
}
