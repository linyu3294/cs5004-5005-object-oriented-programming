package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.model.IModel;
import model.shape.IShape;
import view.IView;
import view.SwingView;

/**
 * This is a Class for the Swing Controller. SWingController implements IController and works with
 * SWingView.
 */
public class SwingController implements IController {
  SwingView view;
  IModel model;
  Timer timer;
  int currentFrame;
  int speed;
  Appendable out;

  /**
   * This is a constructor for the SwingController.
   *
   * @param speed   - A Double that determines animation speed.
   * @param outType - A String that determines the Readable object type.
   */
  public SwingController(String outType, int speed) {
    if (outType.equals("out")) {
      this.out = System.out;
    }
    this.speed = speed;
  }


  /**
   * This is the main controller mechanism for relaying content from model to view. So that the view
   * can display the results. A timer that starts off to increment currentFrame.
   * model.getShapesAtFrame(currentFrame) gets a list of updated shapes at a given frame.
   * SwingView.render() draws the shapes.
   *
   * @param model - IModel object.
   * @param view - a IView object (takes in IView but then casted to SwingView)
   */
  @Override
  public void animate(IModel model, IView view) throws IOException {

    this.model = model;
    this.currentFrame = 1;

    timer = new Timer(speed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<IShape> viewShapes = new ArrayList<IShape>();
        SwingView swView = (SwingView) view;
        List<IShape> shapes = model.getShapesAtFrame(currentFrame);
        swView.render(shapes);
        currentFrame++;
      }
    });

    timer.start();
  }
}