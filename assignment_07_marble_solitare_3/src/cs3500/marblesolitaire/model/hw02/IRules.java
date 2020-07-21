package cs3500.marblesolitaire.model.hw02;

/**
 * This is an interface that can be implemented to regulate how marbles can move.
 */
public interface IRules {
  /**
   * Does - Moves a IMarble object from one square to another if possible.
   *
   * @param board     - the current board;
   * @param sourceRow - the y coordinate of the marble moving FROM.
   * @param sourceCol - the x coordinate of the marble moving FROM.
   * @param destinationRow - the y coordinate of the marble moving TO.
   * @param destinationCol - the x coordinate of the marble moving TO.
   * @throws  IllegalStateException if move is not allowed.
   */
  public void moveAndChangeState(IBoard board,
                                 int sourceRow,
                                 int sourceCol,
                                 int destinationRow,
                                 int destinationCol) throws IllegalArgumentException;

}
