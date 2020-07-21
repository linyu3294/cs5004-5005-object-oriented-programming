/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class Mango_Model implements IModel {
  String data;
  static IModel singleton = null;

  private Mango_Model(){

  }
  //Singleton.
  public static IModel makeModel(){
    if ( singleton == null ){
      singleton = new Mango_Model();
    }
    return singleton;
  }

  @Override
  public void setData(String data) {
    this.data = data.toUpperCase();
  }

  @Override
  public String getData() {
    return data;
  }
}
