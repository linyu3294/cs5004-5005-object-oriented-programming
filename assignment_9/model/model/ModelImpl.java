

package model.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.motion.ChangeColor;
import model.motion.IMotion;
import model.motion.Move;
import model.motion.Scale;
import model.shape.IShape;
import model.shape.Oval;
import model.shape.Rectangle;
import model.shape.ShapeType;
import util.TweenModelBuilder;

/**
 * This is a concrete model class that implements the IModel interface.
 */
public class ModelImpl implements IModel {
  /**
   * The Shapes.
   */
  List<IShape> shapes;
  /**
   * The Motions.
   */
  List<IMotion> motions;


  private ModelImpl(List<IShape> shapes, List<IMotion> motions) {
    this.shapes = shapes;
    this.motions = motions;
  }

  /**
   * Gets the state of a model. The state includes all Shapes taking part in a model. Includes all
   * motions taking part in a model.
   */
  @Override
  public String getState() {
    final String[] state = {"Shapes:\n"};
    shapes.forEach(a -> state[0] = state[0] + a.getState() + "\n\n");
    motions.forEach(b -> state[0] = state[0] + b.getState() + "\n");
    return state[0];
  }

  /**
   * Returns a copy of List of shapes in the model.
   *
   * @return - A List containing IShape objects.
   */
  @Override
  public List<IShape> getShapes() {
    List<IShape> copy = new ArrayList<IShape>(shapes);
    return copy;
  }

  ;

  /**
   * Returns a copy of List of motions in the model.
   *
   * @return - A List containing IMotion objects.
   */
  @Override
  public List<IMotion> getMotions() {
    List<IMotion> copy = new ArrayList<IMotion>(motions);
    return copy;
  }

  ;


  /**
   * This is a Builder class that implements TweenModelBuilder. This Class takes in a IModel and
   * returns a ModelImp object.
   */
  public static final class Builder implements TweenModelBuilder<IModel> {
    /**
     * The Shapes.
     */
    List<IShape> shapes;
    /**
     * The Motions.
     */
    List<IMotion> motions;


    /**
     * This is a constructor for the Model class. It takes no parameters and only initiates the two
     * lists that will used throughout an animation, a list of IShapes and a list of IMotions.
     */
    Builder() {
      shapes = new ArrayList<>();
      motions = new ArrayList<>();

    }


    /**
     * A private helper method that determines if a new motion will conflict with any exiting motion
     * in the model's repository.
     */
    private boolean causeConflict(IMotion motion) {
      List<IMotion> hasConflict =
              motions.stream()
                      .filter(a -> a.getID().equals(motion.getID()))
                      .filter(a -> a.getClass() == motion.getClass())
                      /**
                       * The only two situations where two intervals DON'T overlap are,
                       * when end time of A <= than beginning time of B,
                       * or when beginning time of A >= end time of B.
                       * I am filtering out every occurrences qualify as
                       * neither of those situations.
                       * I chose to write it this way because of the least code I can think of.
                       *
                       * */
                      .filter(a -> !(motion.getStartTime() >= a.getEndTime())
                              && !(motion.getEndTime() <= a.getStartTime()))
                      .collect(Collectors.toList());
      return hasConflict.size() > 0;
    }

    /**
     * This is a method used to store shapes It takes in primitive parameters of basic features that
     * any shape will have. Within its implementation, it will create a shape object by
     * implementor's choice. Currently, I am using IShape to create shapes stored in model, but this
     * implementation can changed and another implementor can create another model implementation
     * that can store BShape objects with additional shape features, without changing the
     * interface.
     */


    public void addShape(IShape shape) {
      shapes.add(shape);
    }


    /**
     * This Method adds a motion to a list of motions.
     *
     * @param motion - an IMotion object.
     */

    public void addMotion(IMotion motion) {
      if (!causeConflict(motion)) {
        boolean foundASpot = false;
        for (int i = 0; i < motions.size(); i++) {
          if (motion.getStartTime() < motions.get(i).getStartTime()) {
            motions.add(i, motion);
            foundASpot = true;
            break;
          }
        }
        if (!foundASpot) {
          motions.add(motions.size(), motion);
        }
      } else {
        throw new IllegalArgumentException("New motion is overlapping with an existing motion");
      }
    }

    /**
     * Add a new oval to the model with the given specifications.
     *
     * @param name        the unique name given to this shape
     * @param cx          the x-coordinate of the center of the oval
     * @param cy          the y-coordinate of the center of the oval
     * @param xRadius     the x-radius of the oval
     * @param yRadius     the y-radius of the oval
     * @param red         the red component of the color of the oval
     * @param green       the green component of the color of the oval
     * @param blue        the blue component of the color of the oval
     * @param startOfLife the time tick at which this oval appears
     * @param endOfLife   the time tick at which this oval disappears
     * @return the builder object
     */
    @Override
    public TweenModelBuilder<IModel> addOval(String name,
                                             float cx,
                                             float cy,
                                             float xRadius,
                                             float yRadius,
                                             float red,
                                             float green,
                                             float blue,
                                             int startOfLife,
                                             int endOfLife) {
      this.addShape(
              new Oval(name,
                      ShapeType.OVAL,
                      startOfLife,
                      endOfLife,
                      cx,
                      cy,
                      xRadius,
                      yRadius,
                      red,
                      green,
                      blue));
      return this;
    }


    /**
     * Add a new rectangle to the model with the given specifications.
     *
     * @param name        the unique name given to this shape
     * @param lx          the minimum x-coordinate of a corner of the rectangle
     * @param ly          the minimum y-coordinate of a corner of the rectangle
     * @param width       the width of the rectangle
     * @param height      the height of the rectangle
     * @param red         the red component of the color of the rectangle
     * @param green       the green component of the color of the rectangle
     * @param blue        the blue component of the color of the rectangle
     * @param startOfLife the time tick at which this rectangle appears
     * @param endOfLife   the time tick at which this rectangle disappears
     * @return the builder object
     */
    @Override
    public TweenModelBuilder<IModel> addRectangle(String name,
                                                  float lx,
                                                  float ly,
                                                  float width,
                                                  float height,
                                                  float red,
                                                  float green,
                                                  float blue,
                                                  int startOfLife,
                                                  int endOfLife) {

      this.addShape(
              new Rectangle(name,
                      ShapeType.RECTANGLE,
                      startOfLife,
                      endOfLife,
                      lx,
                      ly,
                      width,
                      height,
                      red,
                      green,
                      blue));
      return this;
    }

    /**
     * Move the specified shape to the given position during the given time interval.
     *
     * @param name      the unique name of the shape to be moved
     * @param moveFromX the x-coordinate of the initial position of this shape. What this
     *                  x-coordinate represents depends on the shape.
     * @param moveFromY the y-coordinate of the initial position of this shape. what this
     *                  y-coordinate represents depends on the shape.
     * @param moveToX   the x-coordinate of the final position of this shape. What this x-coordinate
     *                  represents depends on the shape.
     * @param moveToY   the y-coordinate of the final position of this shape. what this y-coordinate
     *                  represents depends on the shape.
     * @param startTime the time tick at which this movement should start
     * @param endTime   the time tick at which this movement should end
     */
    @Override
    public TweenModelBuilder<IModel> addMove(String name,
                                             float moveFromX,
                                             float moveFromY,
                                             float moveToX,
                                             float moveToY,
                                             int startTime,
                                             int endTime) {
      IMotion motion = new Move(name,
              startTime,
              endTime,
              moveFromX,
              moveFromY,
              moveToX,
              moveToY);
      this.addMotion(motion);
      return this;
    }

    /**
     * Change the color of the specified shape to the new specified color in the specified time
     * interval.
     *
     * @param name      the unique name of the shape whose color is to be changed
     * @param oldR      the r-component of the old color
     * @param oldG      the g-component of the old color
     * @param oldB      the b-component of the old color
     * @param newR      the r-component of the new color
     * @param newG      the g-component of the new color
     * @param newB      the b-component of the new color
     * @param startTime the time tick at which this color change should start
     * @param endTime   the time tick at which this color change should end
     */
    @Override
    public TweenModelBuilder<IModel> addColorChange(String name,
                                                    float oldR,
                                                    float oldG,
                                                    float oldB,
                                                    float newR,
                                                    float newG,
                                                    float newB,
                                                    int startTime,
                                                    int endTime) {
      IMotion motion = new ChangeColor(name,
              startTime,
              endTime,
              oldR,
              oldB,
              oldG,
              newR,
              newG,
              newB);
      this.addMotion(motion);
      return this;
    }

    /**
     * Change the x and y extents of this shape from the specified extents to the specified target
     * extents. What these extents actually mean depends on the shape, but these are roughly the
     * extents of the box enclosing the shape
     */
    @Override
    public TweenModelBuilder<IModel> addScaleToChange(String name,
                                                      float fromSx,
                                                      float fromSy,
                                                      float toSx,
                                                      float toSy,
                                                      int startTime,
                                                      int endTime) {
      IMotion motion = new Scale(name,
              startTime,
              endTime,
              fromSx,
              fromSy,
              toSx,
              toSy);
      this.addMotion(motion);
      return this;
    }

    /**
     * Return the model built so far.
     *
     * @return the model that was constructed so far
     */
    @Override
    public IModel build() {
      return new ModelImpl(this.shapes, this.motions);
    }
  }
}
