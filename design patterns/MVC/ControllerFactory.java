/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class ControllerFactory {
  public static IController makeController(IView view, IModel model){
    return new MyController1(view, model);
  }
}
