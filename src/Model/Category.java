package Model;

public class Category implements Comparable<Category> {
  private String name;

  public Category(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Category other) {
    return this.getName().compareTo(other.getName());
  }
}
