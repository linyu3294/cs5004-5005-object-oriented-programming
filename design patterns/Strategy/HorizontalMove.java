/**
 * Created by vidojemihajlovikj on 8/7/19.
 */
public class HorizontalMove implements IStrategy {
  @Override
  public boolean canMove(int fromx, int fromy, int tox, int toy) {
    if ( fromx == fromy ){
      //figure out if we can move.
    }
    return false;
  }

  @Override
  public boolean doMove(int fromx, int fromy, int tox, int toy) {
    return false;
  }
}
