package cs3500.marblesolitaire.model.hw02;

/**
 * This is a enum class to define the state of a position on a IBoard.
 */
public enum Square {
  //O stands for a occupied Marble position on a board.
  OCCUPIED,

  //X stands for a unoccupied position on a board.
  UNOCCUPIED,

  // Blank stands for a position outside of the limit of a board.
  OUTOFBOUND,

  // Blank stands for uninitiated state of a postion.
  NULL;

  /**
   * Does - Returns a String that represents the enum value.
   *
   * @return - a string that represents the enum value.
   */
  public String getStr() {
    String postion = "";
    if (this == OCCUPIED) {
      postion = "O";
    }
    if (this == UNOCCUPIED) {
      postion = "X";
    }
    if (this == OUTOFBOUND) {
      postion = " ";
    }
    if (this == NULL) {
      postion = "N";
    }
    return postion;
  }
}
