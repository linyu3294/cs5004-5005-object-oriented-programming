package model.shape;

/**
 * This is a Enum object that's used to store Shape Types.
 */
public enum ShapeType {
  //Represents a Rectangle Object;
  RECTANGLE,

  //Represents an Oval Object;
  OVAL;

  /**
   * Converts an Enum to string and returns it.
   *
   * @return - a string that represents an Enum.
   */
  public String getStr() {
    String postion = "";
    if (this == RECTANGLE) {
      postion = "rectangle";
    }
    if (this == OVAL) {
      postion = "oval";
    }
    return postion;
  }
}
