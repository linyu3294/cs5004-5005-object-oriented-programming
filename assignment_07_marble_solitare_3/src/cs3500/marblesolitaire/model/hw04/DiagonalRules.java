package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.IBoard;
import cs3500.marblesolitaire.model.hw02.IRules;

/**
 * This is a class that represents Diagonal Rules. This class implements methods from IRules.
 */
public class DiagonalRules implements IRules {
  private IBoard board;
  private int sourceRow;
  private int sourceCol;
  private int destinationRow;
  private int destinationCol;

  /**
   * This is a constructor method for Diagonal Rules.
   *
   * @param board - a IBoard object.
   */
  public DiagonalRules(IBoard board) {
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

    boolean validDiagonal = (Math.abs(destinationRow - sourceRow) == 2)
            && (Math.abs(destinationCol - sourceCol) == 2);

    boolean moveValid =
            notSameSquare && sourceOccupied
                    && sourceInbound && destinationEmpty && dest1Inbound
                    && validDiagonal;

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

    this.board.removePiece(this.sourceRow, this.sourceCol);

    this.board.removePiece(
            (this.sourceRow + this.destinationRow) / 2,
            (this.sourceCol + this.destinationCol) / 2
    );
    this.board.setPiece(this.destinationRow, this.destinationCol);
  }
}
