package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.IBoard;

/**
 * This is an interface for IGameOVer.
 */
public interface IGameOver {
  /**
   * Determines if the game is over or not.
   *
   * @return True if game is over; false otherwise.
   */
  public boolean gameOver(IBoard board) ;
}
