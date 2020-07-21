/**
 * This is a class that represents a Pawn ChessPiece. This class implements Interface ChessPiece.
 */
public class Pawn implements ChessPiece {
  private int row;
  private int column;
  private Color color;

  Pawn(int row, int column, Color color) {
    if (row < 0) {
      throw new IllegalArgumentException();
    }
    if (row > 7) {
      throw new IllegalArgumentException();
    }
    if (column < 0) {
      throw new IllegalArgumentException();
    }
    if (column > 7) {
      throw new IllegalArgumentException();
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Returns a Pawn's current row on the chess board.
   *
   * @return - an integer that represents the current row of a Pawn object.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Returns a Pawn's current column on the chess board.
   *
   * @return - an integer that represents the current column of a Pawn object.
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Returns the color, is either black or white, of a Pawn object.
   *
   * @return - an String that represents the color or a Pawn object.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Determines if a Pawn object can move to a given cell.
   *
   * @return -true if a Pawn can move to a position, false otherwise.
   */
  @Override
  public Boolean canMove(int row, int column) {
    if (row < 0 || row > 7) {
      return false;
    }
    if (column < 0 || column > 7) {
      return false;
    }
    if (row == this.row && column == this.column) {
      return true;
    }
    if (this.color.equals(Color.WHITE)) {
      return column == this.column
              && row == this.row + 1;
    }
    if (this.color.equals(Color.BLACK)) {
      return column == this.column
              && row == this.row - 1;
    }
    return null;
  }

  /**
   * Determines if a Pawn object can kill another ChessPiece object.
   *
   * @return -true if a Pawn can kill another ChessPiece, false otherwise.
   */
  @Override
  public Boolean canKill(ChessPiece otherPiece) {
    if (otherPiece.getColor().equals(this.getColor())) {
      return false;
    }
    if (otherPiece.getRow() < 0 || otherPiece.getColumn() > 7) {
      return false;
    }
    if (otherPiece.getRow() < 0 || otherPiece.getColumn() > 7) {
      return false;
    }
    if (otherPiece.getRow() == this.row && otherPiece.getColumn() == this.column) {
      return true;
    }
    if (this.color.equals(Color.WHITE)) {
      return Math.abs(otherPiece.getColumn() - this.column) == 1
              && otherPiece.getRow() == this.row + 1;
    }
    if (this.color.equals(Color.BLACK)) {
      return Math.abs(otherPiece.getColumn() - this.column) == 1
              && otherPiece.getRow() == this.row - 1;
    }
    return null;
  }
}
