/**
 * This is a class that represents a Rook ChessPiece. This class implements Interface ChessPiece.
 */
public class Rook implements ChessPiece {
  private int row;
  private int column;
  private Color color;

  Rook(int row, int column, Color color) {
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
   * Returns a Rook's current row on the chess board.
   *
   * @return - an integer that represents the current row of a Rook object.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Returns a Rook's current column on the chess board.
   *
   * @return - an integer that represents the current column of a Rook object.
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Returns the color, is either black or white, of a Rook object.
   *
   * @return - an String that represents the color or a Rook object.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Determines if a Rook object can move to a given cell.
   *
   * @return -true if a Rook can move to a position, false otherwise.
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
    Boolean moveHoriz = row == this.row && column != this.column;
    Boolean moveVert = column == this.column && row != this.row;
    return moveHoriz != moveVert;
  }

  /**
   * Determines if a Rook object can kill another ChessPiece object.
   *
   * @return -true if a Rook can kill another ChessPiece, false otherwise.
   */
  @Override
  public Boolean canKill(ChessPiece otherPiece) {
    if (otherPiece.getColor().equals(this.getColor())) {
      return false;
    }
    int otherRow = otherPiece.getRow();
    int otherColumn = otherPiece.getColumn();
    return (canMove(otherPiece.getRow(), otherPiece.getColumn()));
  }
}
