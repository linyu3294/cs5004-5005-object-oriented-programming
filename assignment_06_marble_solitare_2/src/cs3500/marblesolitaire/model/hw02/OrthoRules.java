package cs3500.marblesolitaire.model.hw02;

/**
 * OrthoRules class is used to verify if a move pattern is valid. OrthoRules Implements IRules.
 * OrthoRules dictates that a move direction can only move horizontally or vertically. OrthoRules
 * dictates that the source cannot be out of Bound. OrthoRules dictates that the source cannot be
 * empty. OrthoRules dictates that the destination cannot be out of Bound. OrthoRules dictates that
 * the destination must be empty. OrthoRules dictates that the middle square (between source and
 * destination) must be occupied.
 */
public class OrthoRules implements IRules {
  private IBoard board;
  private int sourceRow;
  private int sourceCol;
  private int destinationRow;
  private int destinationCol;
  private boolean twoSquaresLeft;
  private boolean twoSquaresRight;
  private boolean twoSquaresUp;
  private boolean twoSquaresDown;

  /**
   * This is a constructor method for OrthoRules.
   *
   * @param board - a IBoard object.
   */
  public OrthoRules(IBoard board) {
    this.board = board;
  }

  /**
   * Determines if a move is valid or not.
   *
   * @param sourceRow      - the y coordinate of the marble moving FROM.
   * @param sourceCol      - the x coordinate of the marble moving FROM.
   * @param destinationRow - the y coordinate of the marble moving TO.
   * @param destinationCol - the x coordinate of the marble moving TO.
   * @throws IllegalStateException if move is not allowed.
   */
  private void verifyMovePattern(int sourceRow,
                                 int sourceCol,
                                 int destinationRow,
                                 int destinationCol) {
    boolean notSameSquare =
            !(this.sourceRow == destinationRow && this.sourceCol == destinationCol);
    boolean sourceOccupied =
            this.board.checkSquareState(this.sourceRow, this.sourceCol).equals("O");
    boolean sourceInbound =
            this.board.inBound(this.sourceRow, this.sourceCol);
    boolean destinationEmpty =
            this.board.checkSquareState(this.destinationRow, this.destinationCol).equals("X");
    boolean dest1Inbound =
            this.board.inBound(this.destinationRow, this.destinationCol);

    twoSquaresUp = this.sourceRow - 2 == this.destinationRow
            && this.destinationCol == this.sourceCol
            && (board.checkSquareState(this.sourceRow - 1, this.sourceCol).equals("O"));

    twoSquaresDown = this.sourceRow + 2 == this.destinationRow
            && this.destinationCol == this.sourceCol
            && (board.checkSquareState(this.sourceRow + 1, this.sourceCol).equals("O"));

    twoSquaresLeft = this.sourceCol - 2 == this.destinationCol
            && this.destinationRow == this.sourceRow
            && (board.checkSquareState(this.sourceRow, this.sourceCol - 1).equals("O"));

    twoSquaresRight = this.sourceCol + 2 == destinationCol
            && this.destinationRow == this.sourceRow
            && (board.checkSquareState(this.sourceRow, this.sourceCol + 1).equals("O"));

    boolean moveValid =
            notSameSquare && sourceOccupied
                    && sourceInbound && destinationEmpty && dest1Inbound

                    && ((this.twoSquaresLeft)
                    || (this.twoSquaresRight)
                    || (this.twoSquaresUp)
                    || (this.twoSquaresDown));
    if (!moveValid) {
      throw new IllegalArgumentException(
              "This move is NOT a valid move. Please check coordinates."
      );
    }
  }

  /**
   * Does - Moves a IMarble object from one square to another if possible.
   *
   * @param board          - the current board;
   * @param sourceRow      - the y coordinate of the marble moving FROM.
   * @param sourceCol      - the x coordinate of the marble moving FROM.
   * @param destinationRow - the y coordinate of the marble moving TO.
   * @param destinationCol - the x coordinate of the marble moving TO.
   * @throws IllegalStateException if move is not allowed.
   */
  @Override
  public void moveAndChangeState(IBoard board,
                                 int sourceRow,
                                 int sourceCol,
                                 int destinationRow,
                                 int destinationCol) {
    this.board = board;
    this.sourceRow = sourceRow;
    this.sourceCol = sourceCol;
    this.destinationRow = destinationRow;
    this.destinationCol = destinationCol;
    verifyMovePattern(sourceRow, sourceCol, destinationRow, destinationCol);

    if (this.twoSquaresUp) {
      this.board.removePiece(this.sourceRow, this.sourceCol);
      this.board.removePiece(this.sourceRow - 1, this.sourceCol);
      this.board.setPiece(this.destinationRow, this.destinationCol);
    }
    if (this.twoSquaresDown) {
      this.board.removePiece(this.sourceRow, this.sourceCol);
      this.board.removePiece(this.sourceRow + 1, this.sourceCol);
      this.board.setPiece(this.destinationRow, this.destinationCol);
    }
    if (this.twoSquaresLeft) {
      this.board.removePiece(this.sourceRow, this.sourceCol);
      this.board.removePiece(this.sourceRow, this.sourceCol - 1);
      this.board.setPiece(this.destinationRow, this.destinationCol);
    }
    if (this.twoSquaresRight) {
      this.board.removePiece(this.sourceRow, this.sourceCol);
      this.board.removePiece(this.sourceRow, this.sourceCol + 1);
      this.board.setPiece(this.destinationRow, this.destinationCol);
    }
    board.reviseScore();
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
