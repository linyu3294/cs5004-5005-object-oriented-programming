package model.model;

import java.util.List;

import model.motion.IMotion;
import model.shape.IShape;

/**
 * This is an interface for the animation model.
 */
public interface IModel {

  /**
   * Returns a copied list of shapes stored in a IModel.
   *
   * @return - A List containing IShape objects.
   */
  List<IShape> getShapes();


  /**
   * Returns a copy of list of modified shapes in the model at a particular frame.
   *
   * @param frame - a  frame Number
   * @return - A List containing IShape objects.
   */
  List<IShape> getShapesAtFrame(int frame);

  /**
   * Returns a List of motions stored in a IModel.
   *
   * @return - A List containing IMotion objects.
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
