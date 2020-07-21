package model.model;

import model.motion.ChangeColor;
import model.motion.IMotion;
import model.motion.Move;
import model.motion.Scale;
import model.shape.IMutableShape;
import model.shape.IShape;
import model.shape.MutableShape;

/**
 * This is a functional class for 'tweening' Shapes, contains a single static function, called
 * tweenShape.
 */
public class TweenShape {

  /**
   * Takes in three parameters, a IMotion, a IShape, and a frame number. It returns a shape that
   * represents the product of change, enacted by all motions at a given frame number. The initial
   * and product shape objects are both immutable, while a 'tween' shape object called
   * mutableShapeObj is used to enact the transformation.
   *
   * @param initialShapeObj - Initial IShape object.
   * @param motion          - A IMotion object that enacts a change on the IShape object.
   * @param frame           - A specific frame.
   * @return - A resulting IShape that's been transformed by a motion.
   */
  public static IShape tweenShape(IShape initialShapeObj, IMotion motion, int frame) {
    IMutableShape mutableShapeObj;
    IShape productShapeObj;
    productShapeObj = null;
    mutableShapeObj = new MutableShape(
            initialShapeObj.getID(),
            initialShapeObj.getShapeType(),
            initialShapeObj.getATime(),
            initialShapeObj.getDTime(),
            initialShapeObj.getX(),
            initialShapeObj.getY(),
            initialShapeObj.getW(),
            initialShapeObj.getH(),
            initialShapeObj.getR(),
            initialShapeObj.getG(),
            initialShapeObj.getB());
    for (int i = 0; i < motion.getInitialAttributes().size(); i++) {
      double start = initialShapeObj.getATime();
      double end = initialShapeObj.getDTime();
      double startM = motion.getStartTime();
      double endM = motion.getEndTime();
      if (frame >= initialShapeObj.getATime() && frame < initialShapeObj.getDTime()) {
        Double initialAttribute = motion.getInitialAttributes().get(i);
        Double endingAttribute = motion.getEndingAttributes().get(i);
        if (frame >= motion.getStartTime() && frame < motion.getEndTime()) {

          Double tweenAttribute = applyTween(
                  motion.getStartTime(),
                  motion.getEndTime(),
                  initialAttribute,
                  endingAttribute,
                  frame
          );
          if (motion instanceof ChangeColor && i == 0) {
            mutableShapeObj.setR(tweenAttribute);
          }
          if (motion instanceof ChangeColor && i == 1) {
            mutableShapeObj.setG(tweenAttribute);
          }
          if (motion instanceof ChangeColor && i == 2) {
            mutableShapeObj.setB(tweenAttribute);
          }
          if (motion instanceof Move && i == 0) {
            mutableShapeObj.setX(tweenAttribute);
          }
          if (motion instanceof Move && i == 1) {
            mutableShapeObj.setY(tweenAttribute);
          }
          if (motion instanceof Scale && i == 0) {
            mutableShapeObj.setW(tweenAttribute);
          }
          if (motion instanceof Scale && i == 0) {
            mutableShapeObj.setH(tweenAttribute);
          }
        }
        productShapeObj = (IShape) mutableShapeObj;
      }
    }
    return productShapeObj;
  }

  private static double applyTween(int motionStart, int motionEnd,
                                   double startAttribute, double endAttribute,
                                   int frame) {
    if (frame < motionStart || frame > motionEnd) {
      throw new IllegalArgumentException("tween frame data error");
    }
    return (((frame - motionStart) * ((endAttribute - startAttribute) / (motionEnd - motionStart)))
            + startAttribute);
  }
}
