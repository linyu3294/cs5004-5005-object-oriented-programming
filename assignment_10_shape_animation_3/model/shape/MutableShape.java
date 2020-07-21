package model.shape;

/**
 * A Class implementation of IMutableShape.
 */
public class MutableShape extends AbstractShape implements IMutableShape {


  /**
   * This is a constructor for Abstract Shape. All parameters in this class are immutable. All
   * parameters are protected.
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
  public MutableShape(String id,
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
   * Setter for appear time.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setATime(Double newATime) {
    this.aTime = newATime;
    return this;
  }

  /**
   * Setter for disappear time.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setDTime(Double newDTime) {
    this.dTime = newDTime;
    return this;
  }

  /**
   * Setter for x coordinate.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setX(Double x) {
    this.x = x;
    return this;
  }

  /**
   * Setter for y coordinate.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setY(Double y) {
    this.y = y;
    return this;
  }

  /**
   * Setter for width.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setW(Double w) {
    this.w = w;
    return this;
  }

  /**
   * Setter for height.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setH(Double h) {
    this.h = h;
    return this;
  }

  /**
   * Setter for Red.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setR(Double r) {
    this.r = r;
    return this;
  }

  /**
   * Setter for Green.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setG(Double g) {
    this.g = g;
    return this;
  }

  /**
   * Setter for Blue.
   *
   * @return this - for easy chaining.
   */
  @Override
  public IMutableShape setB(Double b) {
    this.b = b;
    return this;
  }


  /**
   * Returns a descriptive string of a IShape object.
   *
   * @return - a descriptive string that stores all of its features.
   */
  @Override
  public String getState() {
    IShape tempShape = ShapeFactory.makeShape(
            "tempShape",
            this.shapeType,
            this.aTime,
            this.dTime,
            this.x,
            this.y,
            this.w,
            this.h,
            this.r,
            this.g,
            this.b);
    return tempShape.getState();
  }
}
