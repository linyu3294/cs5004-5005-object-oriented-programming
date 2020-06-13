package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.IBoard;

/**
 * This is a class that implements Interface IGameOVer.
 * This class determines the endgame condition.
 */
public class GameOver implements IGameOver {
  private IBoard board;

  public GameOver(IBoard board) {
    this.board = board;
  }

  /**
   * Determines if there are still anymore moves.
   *
   * @return a boolean.
   */
  private boolean noMoreMoves() {
    String[][] game = board.getGame();
    for (int i = 0; i < game.length; i++) {
      for (int j = 0; j < game[0].length; j++) {
        if (game[i][j].equals("O")
                && (board.checkSquareState(i + 1, j).equals("O")
                || board.checkSquareState(i - 1, j).equals("O")
                || board.checkSquareState(i, j + 1).equals("O")
                || board.checkSquareState(i, j - 1).equals("O"))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Determines if the game is over or not.
   *
   * @return True if game is over; false otherwise.
   */
  public boolean gameOver(IBoard board) {
    this.board = board;
    return (noMoreMoves() || board.getScore() == 1);
  }
}
