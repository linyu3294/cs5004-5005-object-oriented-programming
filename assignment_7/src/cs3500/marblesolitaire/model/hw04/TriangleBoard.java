package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.AbstractBoard;

/**
 * This is a class that represents a Triangle board.
 */
public class TriangleBoard extends AbstractBoard {
  /**
   * This is a constructor for the Class TriangleBoard.
   *
   * @param blankX - blankX coordinate of an empty piece at setup.
   * @param blankY - blankY coordinate of an empty piece at setup.
   * @param scale  - a constant for determining the scale of a game board.
   * @throws IllegalArgumentException when scale is invalid.
   */
  public TriangleBoard(int scale, int blankX, int blankY) {
    if (scale < 2) {
      throw new IllegalArgumentException("The number of rows cannot be less than 2");
    }
    this.scale = scale;
    this.row = scale;
    this.col = scale;
    this.blankX = blankX;
    this.blankY = blankY;
    setUpGame();
  }


  /**
   * Determines if a square is inbound of the game range.
   *
   * @param x - the y coodiante of a square.
   * @param y - the x coordinate of a square.
   * @return - a boolean, returns true if square is in range.
   */
  @Override
  public boolean inBound(int x, int y) {
    return y <= x;
  }

  @Override
  public String boardSnapShot() {
    String snapShot = "";
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        if (j == 0) {
          for (int k = 0; k < (this.row - 1 - i); k++) {
            snapShot = snapShot + " ";
          }
        }
        if (j <= i) {
          snapShot = snapShot + " " + game[i][j];
        }
        if (j == this.col - 1 && i < this.row - 1) {
          snapShot = snapShot + "\n";
        }
      }
    }
    return snapShot;
  }

}
