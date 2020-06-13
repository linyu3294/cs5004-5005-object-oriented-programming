package cs3500.marblesolitaire.model.hw02;

/**
 * This is a class that represents a cross board.
 */
public class CrossBoard extends AbstractBoard {
  /**
   * This is a constructor for the Class CrossBoard.
   *
   * @param blankX - blankX coordinate of an empty piece at setup.
   * @param blankY - blankY coordinate of an empty piece at setup.
   * @param scale  - a constant for determining the scale of a game board.
   */
  public CrossBoard(int scale, int blankX, int blankY) {
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
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   * @return - a boo lean, returns true if square is in range.
   */
  @Override
  public boolean inBound(int row, int col) {
    int quotient = (this.scale - 1) / 2;
    boolean rowWithinRange = Math.abs((this.row - 1) / 2 - row) <= quotient;
    boolean colWithinRange = Math.abs((this.col - 1) / 2 - col) <= quotient;
    boolean posValid = (rowWithinRange || colWithinRange)
            && col >= 0 && col <= this.col - 1
            && row >= 0 && row <= this.row - 1;
    return (posValid);
  }


}
