package cs3500.marblesolitaire.model.hw02;

/**
 * MarbleSolitaireModelImpl represents an implemented class of MarbleSolitaireModel. The game starts
 * by arranging marbles on the board. Exactly one slot is empty, and is traditionally the center
 * slot.
 * A move is made by making one marble jump over exactly one marble and land in an empty slot
 * exactly two positions away. When such a move is made, the marble that is jumped over is removed.
 * Effectively a single valid move increases the number of empty slots by one. A marble can only
 * jump orthogonally (i.e. horizontally or vertically). The game ends when no more valid moves can
 * be made. At any point in the game, the score is the number of marbles on the board. The objective
 * of the game is to make moves so as to end up with the minimum score when the game ends.
 * MarbleSolitaireModelImpl has the following functions.
 * move(int fromRow,int fromColumn,int toRow,int toColumn) is called to make a move according to the
 * rules of the game. Specifically it will move a marble from the position (fromRow,fromColumn) to
 * the position (toRow,toColumn) if the move is valid. It will throw an IllegalArgumentException if
 * the move cannot be made.
 * String getGameState() returns the current state of the game as a String object. The exact format
 * of this string is dependent on the implementation (see below).
 * isGameOver returns true if the game is over, and false otherwise.
 * int getScore() returns the current score in the game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private IBoard board;

  /**
   * This is the first constructor. It takes no parameters. It initializes the game board.
   */
  public MarbleSolitaireModelImpl() {
    this.board = new CrossBoard();
  }

  /**
   * This is the second constructor. It takes two parameters, column and row. It initializes the
   * game board.
   *
   * @param sRow - an integer that represents the row.
   * @param sCol - an integer that represents the column.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this.board = new CrossBoard(sRow, sCol);
  }


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
    OrthoRules ortho = new OrthoRules(board);
    ortho.moveAndChangeState(board, fromRow, fromCol, toRow, toCol);
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    OrthoRules ortho = new OrthoRules(board);
    return ortho.gameOver(board);
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
