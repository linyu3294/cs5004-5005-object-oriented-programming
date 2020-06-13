package controller;

import java.io.IOException;

import model.model.IModel;
import view.IView;

/**
 * This is the main controller mechanism for relaying content from model to view. So that the view
 * can display the results.
 */
public class Controller implements IController {
  private Appendable out;
  int speed;

  /**
   * This is a constructor for the Controller.
   *
   * @param speed   - A Double that determines animation speed.
   * @param outType - A String that determines the Readable object type.
   */
  public Controller(String outType, int speed) {
    if (outType.equals("out")) {
      this.out = System.out;
    }
    this.speed = speed;
  }

  /**
   * This is the main controller mechanism for relaying content from model to view. So that the view
   * can display the results.
   *
   * @param model - IModel object that store info about shapes and motions.
   * @param view  - IView object that changes the model into displayble view.
   */
  @Override
  public void animate(IModel model, IView view) throws IOException {
    this.out = out;
    view.appendView(model, out, speed);
  }
}
