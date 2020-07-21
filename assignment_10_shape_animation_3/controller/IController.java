package controller;

import java.io.IOException;

import model.model.IModel;
import view.IView;

/**
 * This is an interface for the controller.
 */
public interface IController {
  /**
   * This is the controller mechanism for relaying content from model to view. So that the view
   * can display something understandable to the user.
   */
  void animate(IModel model, IView view) throws IOException;
}
