package view;

import java.io.IOException;
import java.util.ArrayList;

import model.model.IModel;

/**
 * A class used to display IModel info in a svg format.
 */
public class TextView implements IView {

  /**
   * Parses the shapes and motions in a model and appends them to an Appendable object.
   *
   * @param model -IModel object.
   * @param out   - An appendable object.
   * @param speed - The speed defined by ticks per second.
   * @throws IOException when appending the model info fails.
   */
  @Override
  public void appendView(IModel model, Appendable out, int speed)
          throws IOException {
    ArrayList<Character> chars = new ArrayList<Character>();
    for (char c : model.getState().toCharArray()) {
      try {
        out.append(c);
      } catch (IOException e) {
        throw new IllegalStateException("Error Occurred when appending text view.");
      }
    }
  }
}
