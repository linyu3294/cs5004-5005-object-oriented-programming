/**
 * Created by vidojemihajlovikj on 8/7/19.
 */
public class NewModel3 implements IAdvancedModel {
  private java.util.List<IStrategy> strategies;

  public NewModel3(){
    strategies = new java.util.ArrayList<IStrategy>();
    strategies.add(new HorizontalMove());
    strategies.add(new VerticalMove());
  }

  public void addStrategy(IStrategy strategy){
    strategies.add(strategy);
  }

  //horizontal move, verticalmove
  @Override
  public void move(int fromx, int fromy, int tox, int toy) {
    for ( IStrategy strategy : strategies ){
      if ( strategy.canMove(fromx,fromy,tox,toy) ){
        strategy.doMove(fromx,fromy,tox,toy);
        break;
      }
    }
  }
}
