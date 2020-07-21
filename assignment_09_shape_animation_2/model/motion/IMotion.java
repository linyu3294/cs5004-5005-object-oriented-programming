package model.motion;

/**
 * This is an interface that represents a IMotion interface. A class that implements this interface
 * will store information about motions acting on a shape.
 */
public interface IMotion {
  /**
   * A method used to get a string that's descriptive of what an IMotion is doing.
   *
   * @return - a descriptive string.
   */
  String getState();

  /**
   * A method used to get the Identifier string of an object to which a IMotion is applied.
   *
   * @return - an identifier string.
   */
  String getID();

  /**
   * A method used to get the start time of a IMotion.
   *
   * @return - a int that represents a start time.
   */
  int getStartTime();

  /**
   * A method used to get the end time of a IMotion.
   *
   * @return - a int that represents the end time.
   */
  int getEndTime();
}
