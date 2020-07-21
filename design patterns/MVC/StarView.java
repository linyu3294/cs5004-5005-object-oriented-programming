/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class StarView implements IView {
  @Override
  public void render(String data) {
    System.out.println("*************");
    System.out.println(data);
    System.out.println("*************");
  }
}
