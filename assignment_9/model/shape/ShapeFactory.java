package model.shape;

/**
 * This is a shape factory that makes a new IShape object. The specific concrete class generated
 * depends on the parameter, ShapeType.
 */
public class ShapeFactory {
  /**
   * This is a static factory class that makes a shape object.
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
   * @throws IllegalArgumentException - if factory attempts to make a nonexisting IShape
   *                                  implementation class.
   */
  public static IShape makeShape(String id,
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

    IShape newShape = null;
    if (shapeType.getStr().equals("rectangle")) {
      newShape = new Rectangle(id, shapeType, aTime, dTime, x, y, w, h, r, g, b);
    } else if (shapeType.getStr().equals("oval")) {
      newShape = new Oval(id, shapeType, aTime, dTime, x, y, w, h, r, g, b);
    } else {
      throw new IllegalArgumentException("New shape's Type does not exist!");
    }
    return newShape;
  }
}
