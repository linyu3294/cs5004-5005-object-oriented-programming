package controller;

/**
 * This is a Controller Factory that produces a concrete controller object. SwingController or
 * regular contoller, depending on the viewType.
 */
public class ControllerFactory {
  /**
   * The only method in the Controller Factory. It makes a Concrete Controller Object, the Type of
   * Controller depends on viewType.
   *
   * @param viewType - type of viewtype that decides the controller type.
   * @param outType  - the output Type that is defined.
   * @param speed    - speed of the animation.
   * @return - a IController object, the type depends on the viewType.
   */
  public static IController makeController(String viewType, String outType, int speed) {
    IController controller = null;
    if ("text".equals(viewType)) {
      controller = new Controller(outType, speed);
    } else if ("svg".equals(viewType)) {
      controller = new Controller(outType, speed);
    } else if ("visual".equals(viewType)) {
      controller = (IController) new SwingController(outType, speed);
    } else if (viewType == null) {
      throw new IllegalStateException("The specified viewType is not valid!");
    }
    return controller;
  }
}
