package model.motion;

/**
 * An Abstract class that implements IMotion.
 */
public abstract class AbstractMotion implements IMotion {
  protected String id;
  protected int startTime;
  protected int endTime;

  /**
   * This is constructor that initiates all parameters of the class.
   *
   * @param id        - an identifier string associated with an shape object.
   * @param startTime - the start time of a motion.
   * @param endTime   - the end time of a motion.
   */
  protected AbstractMotion(String id, int startTime, int endTime) {
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * A method used to get the Identifier string of an object to which a IMotion is applied.
   *
   * @return - an identifier string.
   */
  @Override
  public String getID() {
    return this.id;
  }

  /**
   * A method used to get the start time of a IMotion.
   *
   * @return - a int that represents a start time.
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * A method used to get the end time of a IMotion.
   *
   * @return - a int that represents the end time.
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

}
