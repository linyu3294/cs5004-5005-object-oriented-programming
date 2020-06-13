package cs3500.marblesolitaire.model.hw02;

/**
 * This is an interface for a Board object. A board contains the number of rows and columns as
 * attributes. With fixed rows and columns, A board constructs a 2 dimentional String array called
 * 'game' and saves it as a attribute. A board represents the state of each square using a two
 * dimensional array string, called 'game'. A board can look up, change a square that is represented
 * by 'game'.
 */
public interface IBoard {
  /**
   * Determines if a square is inbound of the game range.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   * @return - a boolean, returns true if square is in range.
   */
  public boolean inBound(int row, int col);

  /**
   * Returns a string that represents the current state of a game.
   *
   * @return - a string.
   */
  public String boardSnapShot();

  /**
   * Checks the state of a current square.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   * @return - a String that represents a state (occupied, unoccupied, outofBound, null).
   */
  public String checkSquareState(int row, int col);

  /**
   * Changes the state of a square from unoccupied to occupied.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   */
  public void setPiece(int row, int col);

  /**
   * Changes the state of a square from occupied to unoccupied.
   *
   * @param col - the x coordinate of a square.
   * @param row - the y coodiante of a square.
   */
  public void removePiece(int row, int col);


  /**
   * Minus two points from score each time it's called.
   */
  public void reviseScore();


  /**
   * returns the current Score.
   */
  public int getScore();

  /**
   * Returns the game stats.
   *
   * @return - a 2-D String Array.
   */
  public String[][] getGame();

}