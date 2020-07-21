package controller;

import java.io.IOException;

import model.model.IModel;
import view.IView;

/**
 * This is an interface for the controller.
 */
public interface IController {
  /**
   * This is the main controller mechanism for relaying content from model to view. So that the view
   * can display the results.
   */
  void animate(IModel model, IView view) throws IOException;
}
