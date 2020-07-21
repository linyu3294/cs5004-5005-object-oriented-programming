package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw02.CrossBoard;
import cs3500.marblesolitaire.model.hw02.OrthoRules;
import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.GameOver;


/**
 * An English Solitaire model extended from the abstract model.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModelImpl {
  /**
   * This is the first constructor. It takes in no parameters. It initializes the game board.
   */
  public MarbleSolitaireModelImpl() {
    this.board = new CrossBoard(3, 3, 3);
    this.orthoRules = new OrthoRules(board);
    this.gameOver = new GameOver(board);
  }

  /**
   * This is the second constructor. It takes in one parameter, scale. It initializes the game
   * board.
   *
   * @param scale - an integer that determines the size of a board.
   */
  public MarbleSolitaireModelImpl(int scale) {
    this.board = new CrossBoard(scale,
            ((scale * 3) - 3 / 2), ((scale * 3) - 3 / 2));
    this.orthoRules = new OrthoRules(board);
    this.gameOver = new GameOver(board);
  }

  /**
   * This is the second constructor. It takes two parameters, row and column. It initializes the
   * game board.
   *
   * @param sRow - an integer that represents the row.
   * @param sCol - an integer that represents the column.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this.board = new CrossBoard(3, sRow, sCol);
    this.orthoRules = new OrthoRules(board);
    this.gameOver = new GameOver(board);
  }

  /**
   * This is the fourth constructor. It takes in three parameters, scale, row and column. It
   * initializes the game board.
   *
   * @param scale - an integer that determines the size of a board.
   * @param sRow  - an integer that represents the row.
   * @param sCol  - an integer that represents the column.
   */
  public MarbleSolitaireModelImpl(int scale, int sRow, int sCol) {
    this.board = new CrossBoard(scale, sRow, sCol);
    this.orthoRules = new OrthoRules(board);
    this.gameOver = new GameOver(board);
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
    orthoRules.moveAndChangeState(board, fromRow, fromCol, toRow, toCol);
  }
}