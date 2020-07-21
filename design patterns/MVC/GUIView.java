import java.awt.*;

import javax.swing.*;

/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class GUIView extends JFrame implements IView {
  JLabel label;
  public GUIView(){
    setSize( new Dimension(500,500));
    label = new JLabel("This is the data");
    add(label);
    //Displaying the window.
    pack();
    setVisible(true);
  }
  @Override
  public void render(String data) {
    label.setText(data);
  }
}
