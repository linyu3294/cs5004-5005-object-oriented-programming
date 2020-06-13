package model.model;

import java.util.List;

import model.motion.IMotion;
import model.shape.IShape;

/**
 * This is an interface for the animation model.
 */
public interface IModel {

  /**
   * Returns a List of shapes stored in a IModel.
   */
  List<IShape> getShapes();

  /**
   * Returns a List of motions stored in a IModel.
   */
  List<IMotion> getMotions();

  /**
   * Gets the state of a model. The state includes all Shapes taking part in a model. Includes all
   * motions taking part in a model.
   *
   * @return - a descriptive string that represents the model.
   */
  String getState();
}
