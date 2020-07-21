/**
 * Created by vidojemihajlovikj on 6/19/19.
 */

//MVC pattern - Model View Controller
  //* Introduces modularity which promotes:
//      -testing
//      -plug-and-play
  //    -different teams can work on different modules
public interface IModel {
  void setData(String data);
  String getData();
}
