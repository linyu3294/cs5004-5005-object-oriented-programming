package cs3500.marblesolitaire.model.hw02;

/**
 * This is a class that represents a cross board.
 * This is an interface for a Board object.
 * A board contains the number of rows and columns as attributes.
 * With fixed rows and columns,
 * A board constructs a 2 dimentional String array called 'game' and saves it as a attribute.
 * A board represents the state of each square using a two dimensional array string, called 'game'.
 * A board can look up, change a square that is represented by 'game'.
 */
public class CrossBoard implements IBoard {
  private final int row = 7;
  private final int col = 7;
  private int score = 32;
  private String[][] game;


  /**
   * This is a constructor for the Class CrossBoard.
   */
  public CrossBoard() {
    this.game = new String[this.row][this.col];
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        if (!inBound(i, j)
        ) {
          this.game[i][j] = Square.OUTOFBOUND.getStr();
        }
        if (inBound(i, j)) {
          this.game[i][j] = Square.OCCUPIED.getStr();
        }
        if (i == (row - 1) / 2 && j == (col - 1) / 2) {
          this.game[i][j] = Square.UNOCCUPIED.getStr();
        }
      }
    }
  }

  /**
   * This is a constructor for the Class CrossBoard.
   *
   * @param x - x coordinate of an empty piece at setup.
   * @param y - y coordinate of an empty piece at setup.
   */
  public CrossBoard(int x, int y) {
    if (!inBound(x, y)) {
      throw new IllegalArgumentException("Starter empty piece cannot be set Out of Bound!");
    }
    this.game = new String[this.col][this.row];
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        if (inBound(i, j)) {
          this.game[i][j] = Square.OCCUPIED.getStr();
        }
        if (!inBound(i, j)) {
          this.game[i][j] = Square.OUTOFBOUND.getStr();
        }
        if (i == x && j == y) {
          if (!inBound(i, j)) {
            throw new IllegalArgumentException("invalid empty cell square (" + x + "," + y + ")");
          } else {
            this.game[i][j] = Square.UNOCCUPIED.getStr();
          }
        }
      }
    }
  }

  /**
   * Determines if a square is inbound of the game range.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   * @return - a boolean, returns true if square is in range.
   */
  @Override
  public boolean inBound(int row, int col) {
    boolean rowWithinRange = Math.abs(3 - row) <= 1;
    boolean colWithinRange = Math.abs(3 - col) <= 1;
    boolean posValid = (rowWithinRange || colWithinRange)
            && col >= 0 && col <= 6
            && row >= 0 && row <= 6;
    return (posValid);
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
        if ((i == 0 || i == 1 || i == 5) && j == 4) {
          snapShot = snapShot + "\n";
          break;

        } else if ((i == 2 || i == 3 || i == 4) && j == 6) {
          snapShot = snapShot + "\n";
          break;
        }
        if (i == 6 && j == 4) {
          break;
        }
      }
    }
    System.out.println(snapShot);
    return snapShot;
  }

  /**
   * Checks the state of a current square.
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
    this.score = this.score - 1;
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
