package view;

/**
 * This is a class that generates a IView object.
 */
public class ViewFactory {

  /**
   * Generates a IView object based on a key word parameter - viewType.
   *
   * @param viewType - a keyword used to generate a IView object.
   * @return - a IView object.
   */
  public static IView makeView(String viewType) {
    IView view = null;
    if ("text".equals(viewType)) {
      view = new TextView();
    } else if ("svg".equals(viewType)) {
      view = new SVGView();
    } else if ("visual".equals(viewType)) {
      view = new SwingView();
    }
    if (viewType == null) {
      view = new TextView();
    }
    return view;
  }
}
