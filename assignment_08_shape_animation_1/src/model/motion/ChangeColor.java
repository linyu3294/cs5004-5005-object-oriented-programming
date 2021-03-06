package model.motion;

/**
 * A class that extends AbstractMotion. This class is used to store the changes in color of a shape.
 * All parameters are immutable.
 */
public class ChangeColor extends AbstractMotion {
  private final double startR;
  private final double startG;
  private final double startB;
  private final double endR;
  private final double endG;
  private final double endB;

  /**
   * A constructor for ChangeColor Class.
   *
   * @param id        - the identifier string associated with the changing shape.
   * @param startTime - the start time of a change.
   * @param endTime   - the end time of a change.
   * @param startR    - the red component of a starting color.
   * @param startG    - the green component of a starting color.
   * @param startB    - the blue component of a starting color.
   * @param endR      - the red component of a ending color.
   * @param endG      - the green component of a ending color.
   * @param endB      - the blue component of a ending color.
   */
  public ChangeColor(
          String id,
          int startTime,
          int endTime,
          double startR,
          double startG,
          double startB,
          double endR,
          double endG,
          double endB
  ) {
    super(id, startTime, endTime);
    this.startR = startR;
    this.startG = startG;
    this.startB = startB;
    this.endR = endR;
    this.endG = endG;
    this.endB = endB;
  }

  /**
   * Prints a string describing what the changes are. Inscribes all parameters and returns them as a
   * String.
   */
  @Override
  public String getState() {
    return "Shape " + this.id + " "
            + "changes color from "
            + "(" + this.startR + ", " + this.startG + ", " + this.startB + ") "
            + "to "
            + "(" + this.endR + ", " + this.endG + ", " + this.endB + ") "
            + "from time t=" + this.startTime + " to t=" + this.endTime;
  }
}
