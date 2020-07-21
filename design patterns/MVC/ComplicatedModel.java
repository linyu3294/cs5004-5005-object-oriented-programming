/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class ComplicatedModel implements IModel {
  private final int width;
  private final int height;
  private final int numPlayers;

  private ComplicatedModel(int width, int height, int numPlayers, int goal, String color) {
    if ( width < 0 )
      this.width = 0;
    else
      this.width = width;


    this.height = height;
    this.numPlayers = numPlayers;
    this.goal = goal;
    this.color = color;
  }



  private final int goal;
  private final String color;




  @Override
  public void setData(String data) {

  }

  @Override
  public String getData() {
    return null;
  }

  public static Builder makeBuilder(){
    return new Builder();
  }

  public static class Builder{
    private int width =10;
    private int height =10;
    private int numPlayers=3;
    private int goal=4;
    private String color = "Orange pink yellow";

    public Builder setWidth(int width) {
      if (width < 0)
        width = 0;
      else
        this.width = width;

      return this;
    }

    public Builder setHeight(int height) {
      this.height = height;

      return this;
    }

    public Builder setNumPlayers(int numPlayers) {
      this.numPlayers = numPlayers;

      return this;
    }

    public Builder setGoal(int goal) {
      this.goal = goal;
      return this;
    }

    public Builder setColor(String color) {
      this.color = color;
      return this;
    }

    public IModel build(){
      return new ComplicatedModel(width, height, numPlayers, goal, color);
    }
  }
}
