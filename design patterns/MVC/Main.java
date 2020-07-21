import javax.naming.ldap.Control;
import javax.naming.ldap.ControlFactory;

/**
 * Created by vidojemihajlovikj on 6/19/19.
 */

/*
  - MVC
  - Factory
  - Singleton
  - Builder

 */
public class Main {
  public static void main(String [] args){
    IView view = ViewFactory.makeView();
    IModel model = ModelFactory.makeModel();
    IController controller = ControllerFactory.makeController(view, model);
    controller.run();
  }
}
