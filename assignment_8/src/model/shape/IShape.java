package model.shape;

/**
 * This is an interface for IShape.
 */
public interface IShape {

  /**
   * Getter for id.
   *
   * @return - a String that represents a id associated with object.
   */
  String getID();

  /**
   * Getter for ShapeType.
   *
   * @return - a Enum object that represents a ShapeType associated with object.
   */
  ShapeType getShapeType();

  /**
   * Getter for appear time.
   *
   * @return - a double that represents a appear time associated with object.
   */
  double getATime();

  /**
   * Getter for disappear time.
   *
   * @return - a double that represents a disappear time associated with object.
   */
  double getDTime();

  /**
   * Getter for x coordinate.
   *
   * @return - a double that represents a x coordinate associated with object.
   */
  double getX();

  /**
   * Getter for y coordinate.
   *
   * @return - a double that represents y coordinate associated with object.
   */
  double getY();

  /**
   * Getter for width.
   *
   * @return - a double that represents width associated with object.
   */
  double getW();

  /**
   * Getter for height.
   *
   * @return - a double that represents height associated with object.
   */
  double getH();

  /**
   * Getter for Red.
   *
   * @return - a double that represents the red component of the color associated with object.
   */
  double getR();

  /**
   * Getter for Green.
   *
   * @return - a double that represents the green component of the color associated with object.
   */
  double getG();

  /**
   * Getter for Blue.
   *
   * @return - a double that represents the blue component of the color associated with object.
   */
  double getB();

  /**
   * Returns a descriptive string of a IShape object.
   *
   * @return - a descriptive string that stores all of its features.
   */
  String getState();
}
