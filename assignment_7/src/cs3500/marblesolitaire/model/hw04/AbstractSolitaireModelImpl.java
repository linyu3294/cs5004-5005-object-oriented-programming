package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.IBoard;
import cs3500.marblesolitaire.model.hw02.IRules;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is a Abstract class implementation of interface, MarbleSolitaireModel.
 */
public class AbstractSolitaireModelImpl implements MarbleSolitaireModel {
  protected IBoard board;
  protected IGameOver gameOver;
  protected IRules orthoRules;
  protected IRules diagonalRules;


  /**
   * Move a single marble from a given square to another given square. A move is valid only if the
   * from and to squares are valid. Specific implementations may place additional constraints on the
   * validity of a move.
   *
   * @param fromRow the row number of the square to be moved from (starts at 0)
   * @param fromCol the column number of the square to be moved from (starts at 0)
   * @param toRow   the row number of the square to be moved to (starts at 0)
   * @param toCol   the column number of the square to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */


  /**
   * Move a single marble from a given square to another given square. A move is valid only if the
   * from and to squares are valid. Specific implementations may place additional constraints on the
   * validity of a move.
   *
   * @param fromRow the row number of the square to be moved from (starts at 0)
   * @param fromCol the column number of the square to be moved from (starts at 0)
   * @param toRow   the row number of the square to be moved to (starts at 0)
   * @param toCol   the column number of the square to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    // The moves are different different for each implementation that extend this abstract class.
    // But in order to even have a abstract class I to implement directly from the interface.
    // So the interface forces me to have a move method here.
    // I'm creating a empty class a placeholder that will be overridden later in each marble impl.
    int emptyPlaceholder=0;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return gameOver.gameOver(this.board);
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, X or space for
   * a marble, empty and invalid square respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    return board.boardSnapShot();
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return board.getScore();
  }
}
