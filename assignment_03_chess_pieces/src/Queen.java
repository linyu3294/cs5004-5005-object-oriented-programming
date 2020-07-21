/**
 * This is a class that represents a Queen ChessPiece. This class implements Interface ChessPiece.
 */
public class Queen implements ChessPiece {
  private int row;
  private int column;
  private Color color;

  Queen(int row, int column, Color color) {
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
   * Returns a Queen's current row on the chess board.
   *
   * @return - an integer that represents the current row of a Queen object.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Returns a Queen's current column on the chess board.
   *
   * @return - an integer that represents the current column of a Queen object.
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Returns the color, is either blacka or white, of a Queen object.
   *
   * @return - an String that represents the color or a Queen object.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Determines if a Queen object can move to a given cell.
   *
   * @return -true if a Queen can move to a position, false otherwise.
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
    Boolean moveStraight = moveHoriz != moveVert;
    Boolean moveDiagonal = Math.abs(row - this.row) == Math.abs(column - this.column);
    return moveStraight != moveDiagonal;
  }

  /**
   * Determines if a Queen object can kill another ChessPiece object.
   *
   * @return -true if a Queen can kill another ChessPiece, false otherwise.
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
