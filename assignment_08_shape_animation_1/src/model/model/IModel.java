package model.model;

import model.motion.IMotion;
import model.shape.ShapeType;

/**
 * This is an interface for the animation model.
 */
public interface IModel {

  /**
   * This is a method used to store shapes It takes in primitive parameters of basic features that
   * any shape will have. Within its implementation, it will create a shape object by implementor's
   * choice. Currently, I am using IShape to create shapes stored in model, but this implementation
   * can changed and another implementor can create another model implementation that can store
   * BShape objects with additional shape features, without changing the interface.
   */
  void addShape(String id,
                ShapeType shapeType,
                double aTime,
                double dTime,
                double x,
                double y,
                double w,
                double h,
                double r,
                double g,
                double b);

  /**
   * This Method adds a motion to a list of motions.
   *
   * @param motion - an IMotion object.
   */
  void addMotion(IMotion motion);


  /**
   * Gets the state of a model. The state includes all Shapes taking part in a model. Includes all
   * motions taking part in a model.
   *
   * @return - a descriptive string that represents the model.
   */
  String getState();
}
