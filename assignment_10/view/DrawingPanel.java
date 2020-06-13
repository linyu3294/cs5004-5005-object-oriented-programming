package view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import model.shape.IShape;

/**
 * A class that implements IDrawingPanel.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {

  List<IShape> shapes = null;

  /**
   * Draws a frame that contains a list of IShapes.
   *
   * @param shapes - list of IShapes.
   */
  @Override
  public void drawShapes(List<IShape> shapes) {
    this.shapes = shapes;
    repaint();
  }


  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shapes != null) {
      for (IShape shape : this.shapes) {
        Color shapeColor = new Color((int) (shape.getR() * 255),
                (int) (shape.getG() * 255), (int) (shape.getB() * 255));
        g.setColor(shapeColor);
        switch (shape.getShapeType()) {
          case RECTANGLE:
            g.fillRect(((int) shape.getX()), (int) shape.getY(),
                    (int) shape.getW(), (int) shape.getH());
            break;
          case OVAL:

            g.fillOval(((int) shape.getX()), (int) shape.getY(),
                    (int) shape.getW(), (int) shape.getH());
            break;
          default:
            break;
        }
      }
    }
  }
}
