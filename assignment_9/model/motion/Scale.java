package model.motion;

/**
 * A class that extends AbstractMotion. This class is used to store the changes in size of a shape.
 * All parameters are immutable.
 */
public class Scale extends AbstractMotion {
  private final double startWidth;
  private final double startHeight;
  private final double endWidth;
  private final double endHeight;

  /**
   * A constructor for the IMotion Scale class.
   *
   * @param id          - an identifier string that's associated with the changing shape.
   * @param startTime   - the start time of a change in position.
   * @param endTime     - the end time of a change in position.
   * @param startWidth  - the starting width of a shape.
   * @param startHeight - the starting height of a shape.
   * @param endWidth    - the ending width of a shape.
   * @param endHeight   - the ending height of a shape.
   */
  public Scale(
          String id,
          int startTime,
          int endTime,
          double startWidth,
          double startHeight,
          double endWidth,
          double endHeight
  ) {
    super(id, startTime, endTime);
    this.startWidth = startWidth;
    this.startHeight = startHeight;
    this.endWidth = endWidth;
    this.endHeight = endHeight;
  }

  /**
   * Prints a string describing what the changes are. Inscribes all parameters and returns them as a
   * String.
   */
  @Override
  public String getState() {
    return "Shape " + this.id + " "
            + "scales from "
            + "Width: " + this.startWidth + ", "
            + "Height: " + this.startHeight + " "
            + "to "
            + "Width: " + this.endWidth + ", "
            + "Height: " + this.endHeight + " "
            + "from time t=" + this.startTime + " to t=" + this.endTime;
  }

}
