package adapter;

public class Sparrow implements IBird {
  private int x;
  private int y;
  private String name;

  public Sparrow() {
    this.name = "sparrow";
  }

  @Override
  public void fly() {
    this.y = y++;
  }

  @Override
  public void makeSound() {
    System.out.println("chirp chirp");
  }
}
