package model.shape;

/**
 * A Class that extends AbstractShape. Represents an Rectangle shape.
 */
public class Rectangle extends AbstractShape {
  /**
   * Constructs the shape object.
   *
   * @param id        - id of a shape.
   * @param shapeType - a enum that represents the type of a shape.
   * @param aTime     - a double that represents the time when a shape appears.
   * @param dTime     - a double that represents the time when a shape disappears.
   * @param x         - the x coordinate of a shape represented in 2 d.
   * @param y         - the y coordinate of a shape represented in 2 d.
   * @param w         - the width of a shape.
   * @param h         - the height of a shape.
   * @param r         - the red component of a shape.
   * @param g         - the green component of a shape.
   * @param b         - the blue component of a shape.
   */
  public Rectangle(String id,
                   ShapeType shapeType,
                   double aTime,
                   double dTime,
                   double x,
                   double y,
                   double w,
                   double h,
                   double r,
                   double g,
                   double b) {
    super(id, shapeType, aTime, dTime, x, y, w, h, r, g, b);
  }


  /**
   * A Method returns a descriptive String for the Rectangle Shape.
   *
   * @return - a string that stores all parameters in a string.
   */
  @Override
  public String getState() {
    return "Name: " + this.id + "\n"
            + "Type: " + this.shapeType.getStr() + "\n"
            + "Min corner: (" + this.x + "," + this.y + "), "
            + "Width: " + this.w + "," + "Height: " + this.h + ", "
            + "Color: " + "(" + this.r + ", " + this.g + ", " + this.b + ") " + "\n"
            + "Appears at time t = " + this.aTime + "\n"
            + "Appears at time t = " + this.dTime;
  }

}
