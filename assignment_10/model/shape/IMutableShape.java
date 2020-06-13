package model.shape;

/**
 * A Interface that extends IShape, and can use it's methods. But different from IShape, this
 * interface has setters.
 */
public interface IMutableShape extends IShape {

  /**
   * Setter for appear time.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setATime(Double newATime);

  /**
   * Setter for disappear time.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setDTime(Double newDTime);

  /**
   * Setter for x coordinate.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setX(Double x);

  /**
   * Setter for y coordinate.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setY(Double y);

  /**
   * Setter for width.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setW(Double w);

  /**
   * Setter for height.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setH(Double h);

  /**
   * Setter for Red.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setR(Double r);

  /**
   * Setter for Green.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setG(Double g);

  /**
   * Setter for Blue.
   *
   * @return this - for easy chaining.
   */
  IMutableShape setB(Double b);

}

