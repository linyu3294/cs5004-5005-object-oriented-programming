package view;

import java.io.IOException;

import model.model.IModel;

/**
 * This interface implements IView.
 */
public interface ISwingView extends IView {
  /**
   * Appends all shapes stored in a IModel to drawingPanel, at a specific frame.
   *
   * @param model        - IModel object.
   * @param currentFrame - int that represents the current frame.
   * @param speed        - The speed defined by ticks per second.
   * @throws IOException - If the process of appending fails.
   */
  public void appendView(IModel model, int currentFrame, int speed) throws IOException;
}
