package adapter;

public class PlasticToyDuck implements IToyDuck {
  private String name;

  public PlasticToyDuck()
  {
    this.name = "toy duck";
  }
  @Override
  public void squeak(){
    System.out.println("squeak squeak");
  }
  @Override
  public String getName() {
    return this.name;
  }
}
