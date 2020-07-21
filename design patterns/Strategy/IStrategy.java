/**
 * Created by vidojemihajlovikj on 8/7/19.
 */
public interface IStrategy {
  boolean canMove(int fromx, int fromy, int tox, int toy);
  boolean doMove(int fromx, int fromy, int tox, int toy);
}
