/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class MySQL_Model implements IModel {
  String data;

  private MySQL_Model(String data){
    this.data = data;
  }
  @Override
  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String getData() {
    return data;
  }
}
