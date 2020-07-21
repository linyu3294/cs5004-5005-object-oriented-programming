package model.motion;


/**
 * A class that extends AbstractMotion. This class is used to store the changes in position of a
 * shape. All parameters are immutable.
 */
public class Move extends AbstractMotion {
  private final double startX;
  private final double startY;
  private final double endX;
  private final double endY;

  /**
   * A constructor for Move class.
   *
   * @param id        - a identifier string that's associated with the changing shape.
   * @param startTime - the start time of a change in position.
   * @param endTime   - the end time of a change in position.
   * @param startX    - the starting x coordinate of a change in position.
   * @param startY    - the starting y coordinate of a change in position.
   * @param endX      - the ending x coordinate of a change in position.
   * @param endY      - the ending y coordinate of a change in position.
   */
  public Move(
          String id,
          int startTime,
          int endTime,
          double startX,
          double startY,
          double endX,
          double endY
  ) {
    super(id, startTime, endTime);
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  /**
   * Prints a string describing what the changes are. Inscribes all parameters and returns them as a
   * String.
   */
  @Override
  public String getState() {
    return "Shape " + this.id + " "
            + "moves from "
            + "(" + this.startX + ", " + this.startY + ") "
            + "to "
            + "(" + this.endX + ", " + this.endY + ") "
            + "from time t=" + startTime + " to t=" + endTime;
  }
}
