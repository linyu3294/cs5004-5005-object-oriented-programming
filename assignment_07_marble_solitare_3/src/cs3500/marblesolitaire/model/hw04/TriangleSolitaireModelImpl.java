package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.OrthoRules;

/**
 * A Triangle Solitaire model extended from the abstract model.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {
  /**
   * This is the first constructor. It takes no parameters. It initializes the game board.
   */
  public TriangleSolitaireModelImpl() {
    this.board = new TriangleBoard(5,0,0);
    this.gameOver = new GameOver(board);
    orthoRules = new OrthoRules(board);
    diagonalRules = new DiagonalRules(board);
  }

  /**
   * This is the second constructor. It takes in one parameter, scale. It initializes the game
   * board.
   *
   * @param scale - an integer that determines the size of the board.
   */
  public TriangleSolitaireModelImpl(int scale) {
    this.board = new TriangleBoard(scale,0,0);
    this.gameOver = new GameOver(board);
    orthoRules = new OrthoRules(board);
    diagonalRules = new DiagonalRules(board);
  }


  /**
   * This is the third constructor. It takes in two parameters, column and row. It initializes the
   * game board.
   *
   * @param sRow - an integer that represents the row.
   * @param sCol - an integer that represents the column.
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    this.board = new TriangleBoard(5, sRow, sCol);
    this.gameOver = new GameOver(board);
    orthoRules = new OrthoRules(board);
    diagonalRules = new DiagonalRules(board);
  }


  /**
   * This is the fourth constructor. It takes in three parameters, scale, row and column. It
   * initializes the game board.
   *
   * @param scale - an integer that determines the size of the board.
   * @param sRow  - an integer that represents the row.
   * @param sCol  - an integer that represents the column.
   */
  public TriangleSolitaireModelImpl(int scale, int sRow, int sCol) {
    this.board = new TriangleBoard(scale, sRow, sCol);
    this.gameOver = new GameOver(board);
    orthoRules = new OrthoRules(board);
    diagonalRules = new DiagonalRules(board);
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
    try {
      orthoRules.moveAndChangeState(board, fromRow, fromCol, toRow, toCol);
    } catch (Exception e) {
      diagonalRules.moveAndChangeState(board, fromRow, fromCol, toRow, toCol);
    }
  }
}