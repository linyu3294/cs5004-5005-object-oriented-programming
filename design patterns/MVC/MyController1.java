import java.util.Scanner;

/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class MyController1 implements IController {
  private IView view;
  private IModel model;

  public MyController1(IView view, IModel model){
    this.view = view;
    this.model = model;
  }

  @Override
  public void run() {

    //Reads from the keyboard.
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();

    //Update the model with whatever the user entered.
    model.setData(userInput);

    //We get data back from the model.
    String modelData = model.getData();

    //Display the data in the view.
    view.render(modelData);
  }
}
