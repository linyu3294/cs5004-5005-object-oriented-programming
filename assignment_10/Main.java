import java.io.IOException;

import controller.ControllerFactory;
import controller.IController;
import controller.SwingController;
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
    String viewType = "text";
    String outputType = "out";
    int speed = 1;

    IModel model;
    IView view;
    IController controller;
    Appendable out = new StringBuffer();

    String parsedArgs;
    int i = 0;
    if (args.length > 0) {
      while (i < args.length) {
        parsedArgs = args[i];

        if (parsedArgs.equals("-if")) {
          filepath = args[i + 1];
        }
        if (parsedArgs.equals("-iv")) {
          viewType = args[i + 1];
        }
        if (parsedArgs.equals("-o")) {
          outputType = args[i + 1];
        }
        if (parsedArgs.equals("-speed")) {
          speed = Integer.parseInt(args[i + 1]);
        }
        i++;
      }
    }

    model = ModelFactory.makeModel(filepath);
    view = ViewFactory.makeView(viewType);
    controller = ControllerFactory.makeController(viewType, outputType, speed);
    controller.animate(model, view);
    if (controller instanceof SwingController) {
      System.out.println("yes");
    }
    System.out.print(out.toString());
  }
}
