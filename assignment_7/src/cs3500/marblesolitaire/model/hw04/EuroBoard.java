package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.AbstractBoard;

/**
 * This is a class that represents a Euro board.
 */

public class EuroBoard extends AbstractBoard {
  /**
   * This is a constructor for the Class EuroBoard.
   *
   * @param blankX - blankX coordinate of an empty piece at setup.
   * @param blankY - blankY coordinate of an empty piece at setup.
   * @param scale  - a constant for determining the scale of a game board.
   */
  public EuroBoard(int scale, int blankX, int blankY) {
    if (scale < 3 || scale % 2 == 0) {
      throw new IllegalArgumentException("The arm width cannot be less than 3 or an even number.");
    }
    this.scale = scale;
    this.row = (scale * 3) - 2;
    this.col = (scale * 3) - 2;
    this.blankX = blankX;
    this.blankY = blankY;
    setUpGame();
  }

  /**
   * Determines if a square is inbound of the game range.
   *
   * @param x - the x coordinate of a square.
   * @param y - the y coodiante of a square.
   * @return - a boolean, returns true if square is in range.
   */
  @Override
  public boolean inBound(int x, int y) {
    boolean withinOctagon = (
            ((Math.abs(x - (this.row - 1) / 2)) + (Math.abs(y - (this.col - 1) / 2)))
    ) < (2 * scale) - 1;
    return withinOctagon;
  }
}
