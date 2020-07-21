package adapter;

/**
 * Adapts an existing IToyDuck type to a IBird type.
 */
public class BirdAdapter implements IBird {
  private int x;
  private int y;
  private String name;
  private IToyDuck toyDuck;


  public BirdAdapter (IToyDuck toyDuck) {
    this.x = 0;
    this.y = 0;
    this.toyDuck = toyDuck;
    this.name = toyDuck.getName();
  }

  @Override
  public void fly() {
    this.y = y++;
  }

  @Override
  public void makeSound() {
    toyDuck.squeak();
  }
}
