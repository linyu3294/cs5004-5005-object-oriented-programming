package model.shape;


/**
 * AbstractShape is a Immutable abstract Class that implements IShape. AbstractShape can be extended
 * to create variation classes.
 */
public abstract class AbstractShape implements IShape {
  //My shape currently is immutable!
  //Which is good! I don't have any setters.
  protected final String id;
  protected final ShapeType shapeType;
  protected final double aTime;
  protected final double dTime;
  protected final double x;
  protected final double y;
  protected final double w;
  protected final double h;
  protected final double r;
  protected final double g;
  protected final double b;

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
  protected AbstractShape(String id,
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
    this.id = id;
    this.shapeType = shapeType;
    this.aTime = aTime;
    this.dTime = dTime;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Getter for id.
   *
   * @return - a String that represents a id associated with object.
   */
  @Override
  public String getID() {
    return this.id;
  }

  /**
   * Getter for ShapeType.
   *
   * @return - a Enum object that represents a ShapeType associated with object.
   */
  @Override
  public ShapeType getShapeType() {
    return this.shapeType;
  }

  /**
   * Getter for appear time.
   *
   * @return - a double that represents a appear time associated with object.
   */
  @Override
  public double getATime() {
    return this.aTime;
  }

  /**
   * Getter for disappear time.
   *
   * @return - a double that represents a disappear time associated with object.
   */
  @Override
  public double getDTime() {
    return this.dTime;
  }

  /**
   * Getter for x coordinate.
   *
   * @return - a double that represents a x coordinate associated with object.
   */
  @Override
  public double getX() {
    return this.x;
  }

  /**
   * Getter for y coordinate.
   *
   * @return - a double that represents y coordinate associated with object.
   */
  @Override
  public double getY() {
    return this.y;
  }

  /**
   * Getter for width.
   *
   * @return - a double that represents width associated with object.
   */
  @Override
  public double getW() {
    return this.w;
  }

  /**
   * Getter for height.
   *
   * @return - a double that represents height associated with object.
   */
  @Override
  public double getH() {
    return this.h;
  }

  /**
   * Getter for Red.
   *
   * @return - a double that represents the red component of the color associated with object.
   */
  @Override
  public double getR() {
    return this.r;
  }

  /**
   * Getter for Green.
   *
   * @return - a double that represents the green component of the color associated with object.
   */
  @Override
  public double getG() {
    return this.g;
  }

  /**
   * Getter for Blue.
   *
   * @return - a double that represents the blue component of the color associated with object.
   */
  @Override
  public double getB() {
    return this.b;
  }
}
