package view;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import model.model.IModel;
import model.shape.IShape;

/**
 * This class implements ISwingView, and works with SwingController.
 */
public class SwingView extends JFrame implements ISwingView {
  DrawingPanel drawingPanel;
  JButton play;
  JButton pause;

  /**
   * The constructor of the SwingView sets up the layout of new JFrame window.
   */
  public SwingView() {
    drawingPanel = new DrawingPanel();
    drawingPanel.setBackground(Color.white);
    drawingPanel.setPreferredSize(new Dimension(1500, 1500));
    JScrollPane pane = new JScrollPane(drawingPanel);

    play = new JButton("play");
    pause = new JButton("pause");

    setSize(2500, 2500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    add(pane, BorderLayout.CENTER);
    add(play, BorderLayout.SOUTH);
    add(pause, BorderLayout.NORTH);

    setVisible(true);

  }

  /**
   * Appends all shapes stored in a IModel to drawingPanel, at a specific frame.
   *
   * @param model        - IModel object.
   * @param currentFrame - int that represents the current frame.
   * @param speed        - The speed defined by ticks per second.
   * @throws IOException - If the process of appending fails.
   */
  @Override
  public void appendView(IModel model, int currentFrame, int speed) throws IOException {
    List<IShape> shapes = model.getShapesAtFrame(currentFrame);
    drawingPanel.drawShapes(shapes);
  }

  /**
   * This is actually an unnecessary and placeholder methods as a result of ISwingView being an
   * inherited interface of IView. I needed this inheritance pattern so that my ViewFactory can
   * return an IView object even if it's a SWingView implementation.
   *
   * @param model -IModel object.
   * @param out   - An appendable object.
   * @param speed - The speed defined by ticks per second.
   * @throws IOException - If the process of appending fails.
   */
  @Override
  public void appendView(IModel model, Appendable out, int speed) throws IOException {
    this.appendView(model, 0, speed);
  }

  /**
   * Window is visible when value of is true otherwise window is invisible.
   *
   * @param value - controls the visibility of window.
   */
  public void showWindow(boolean value) {
    setVisible(value);
  }

  /**
   * Drawing panel to draw the shapes.
   * USed in SwingController.
   *
   * @param shapes - a list of shapes.
   */
  public void render(List<IShape> shapes) {
    drawingPanel.drawShapes(shapes);
  }
}
