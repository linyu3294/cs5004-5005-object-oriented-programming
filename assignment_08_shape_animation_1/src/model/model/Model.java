

package model.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.motion.IMotion;
import model.shape.IShape;
import model.shape.ShapeFactory;
import model.shape.ShapeType;


/**
 * This is a concrete model class that implements the IModel interface.
 */
public class Model implements IModel {
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
  public Model() {
    shapes = new ArrayList<>();
    motions = new ArrayList<>();
  }

  /**
   * This is a method used to store shapes It takes in primitive parameters of basic features that
   * any shape will have. Within its implementation, it will create a shape object by implementor's
   * choice. Currently, I am using IShape to create shapes stored in model, but this implementation
   * can changed and another implementor can create another model implementation that can store
   * BShape objects with additional shape features, without changing the interface.
   */
  @Override
  public void addShape(
          String id,
          ShapeType shapeType,
          double aTime,
          double dTime,
          double x,
          double y,
          double w,
          double h,
          double r,
          double g,
          double b
  ) {
    IShape shape = ShapeFactory.makeShape(id, shapeType, aTime, dTime, x, y, w, h, r, g, b);
    shapes.add(shape);
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
   * This Method adds a motion to a list of motions.
   *
   * @param motion - an IMotion object.
   */
  @Override
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
                     * I am filtering out every occurrences qualify as neither of those situations.
                     * I chose to write it this way because of the least code I can think of.
                     *
                     * */
                    .filter(a -> !(motion.getStartTime() >= a.getEndTime())
                            && !(motion.getEndTime() <= a.getStartTime()))
                    .collect(Collectors.toList());
    return hasConflict.size() > 0;
  }
}
