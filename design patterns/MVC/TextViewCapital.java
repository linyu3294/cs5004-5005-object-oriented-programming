/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class TextViewCapital implements IView {
  @Override
  public void render(String data) {
    System.out.println(data.toUpperCase());
  }
}
