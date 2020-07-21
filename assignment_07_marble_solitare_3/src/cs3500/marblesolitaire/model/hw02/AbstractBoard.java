package cs3500.marblesolitaire.model.hw02;

/**
 * This is a abstract class implementation of IBoard. Contains code that will be shared by
 * extensions, EuroBoard and CrossBoard.
 */
public abstract class AbstractBoard implements IBoard {
  protected int row;
  protected int col;
  protected String[][] game;
  protected int score;
  protected int scale;
  protected int blankX;
  protected int blankY;


  /**
   * Used to set the initial board schema in a new game.
   */
  protected void setUpGame() {
    score = -1;
    if (!inBound(this.blankX, this.blankY)) {
      throw new IllegalArgumentException("Starter empty piece cannot be set Out of Bound!");
    }
    this.game = new String[this.col][this.row];
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        if (inBound(i, j)) {
          this.game[i][j] = Square.OCCUPIED.getStr();
          score = score + 1;
        }
        if (!inBound(i, j)) {
          this.game[i][j] = Square.OUTOFBOUND.getStr();
        }
        if (i == blankX && j == blankY) {
          if (!inBound(i, j)) {
            throw new IllegalArgumentException(
                    "invalid empty cell square (" + blankX + "," + blankY + ")"
            );
          } else {
            this.game[i][j] = Square.UNOCCUPIED.getStr();
          }
        }
      }
    }
  }


  /**
   * Returns a string that represents the current state of a game.
   *
   * @return - a string.
   */
  @Override
  public String boardSnapShot() {
    String snapShot = "";
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        String space = " ";
        if (j > 0) {
          snapShot = snapShot + space;
        }
        snapShot = snapShot + this.game[i][j];
        if ((j > this.col / 2
                && !inBound(i, j))
                || j == this.col - 1
        ) {
          if (i != this.row - 1) {
            snapShot = snapShot + "\n";
          }
          break;
        }
      }
    }
    snapShot = snapShot
            .substring(0, snapShot.length() - 2)
            .replaceAll("  \n", "\n");
    return snapShot;
  }


  /**
   * Checks the state of a single square square.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   * @return - a String that represents a state (occupied, unoccupied, outofBound, null).
   */
  @Override
  public String checkSquareState(int row, int col) {
    try {
      return this.game[row][col];
    } catch (ArrayIndexOutOfBoundsException e) {
      return Square.NULL.getStr();
    }
  }

  /**
   * Changes the state of a square from unoccupied to occupied.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   */
  @Override
  public void setPiece(int row, int col) {
    this.game[row][col] = Square.OCCUPIED.getStr();
  }

  /**
   * Changes the state of a square from occupied to unoccupied.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coordinate of a square.
   */
  @Override
  public void removePiece(int row, int col) {
    this.game[row][col] = Square.UNOCCUPIED.getStr();
  }

  /**
   * Minus two points from score each time it's called.
   */
  @Override
  public void reviseScore() {
    this.score = score - 1;
  }

  /**
   * returns the current Score.
   */
  @Override
  public int getScore() {
    return this.score;
  }

  /**
   * Returns the game stats.
   *
   * @return - a 2-D String Array.
   */
  public String[][] getGame() {
    return this.game;
  }

}
