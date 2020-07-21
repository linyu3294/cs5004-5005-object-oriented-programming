package view;


import model.shape.IShape;

/**
 * This is a interface for IDrawingPanel.
 */
public interface IDrawingPanel {
  /**
   * This method works to display a list of shapes to draw.
   *
   * @param shapesToDraw - a list of IShapes.
   */
  void drawShapes(java.util.List<IShape> shapesToDraw);
}
