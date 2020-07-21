package view;

import java.io.IOException;

import model.model.IModel;

/**
 * This is an interface for IView.
 */
public interface IView {
  /**
   * Appends all info stored in a IModel to an appendable objects,
   * tuned to be viewed with the designated speed.
   *
   * @param model -IModel object.
   * @param out - An appendable object.
   * @param speed - The speed defined by ticks per second.
   * @throws IOException - If the process of appending fails.
   */
  void appendView(IModel model, Appendable out, int speed)
          throws IOException;
}
