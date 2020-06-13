import java.io.IOException;

import controller.Controller;
import controller.IController;
import model.model.IModel;
import model.model.ModelFactory;
import view.IView;
import view.ViewFactory;

/**
 * This is the Main class for the animation app.
 */
public class Main {
  /**
   * The main method that serves as an entry point for animation app.
   *
   * @param args - a set of parameters controlling the app behavior.
   */
  public static void main(String[] args) throws IOException {
    String filepath = "";
    String viewType = "";
    String outputType = "out";
    double speed = 1.0;

    IView view;
    IModel model;
    Appendable out = new StringBuffer();

    args = new String[3];
    args[0] = "<-if src/util/toh-8.txt>";
    args[1] = "<-iv svg>";
    args[2] = "<-speed 20>";

    for (int i = 0; i < args.length; i++) {
      String param = args[i]
              .replace("<", "")
              .replace(">", "");
      String paraID = param.split(" ")[0];

      switch (paraID) {
        case "-if":
          filepath = param.replace("-if ", "");
          break;
        case "-iv":
          viewType = param.replace("-iv ", "");
          break;
        case "-o":
          outputType = param.replace("-o ", "");
          break;
        case "-speed":
          speed = Double.parseDouble(param.replace("-speed ", ""));
          break;
        default :
      }
    }

    model = ModelFactory.makeModel(filepath);
    view = ViewFactory.makeView(viewType);

    IController controller = new Controller(outputType, speed);
    controller.animate(model, view);
    System.out.print(out.toString());
  }
}
