/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class NewDataModel implements IModel {
  private String data;

  private NewDataModel(){

  }

  @Override
  public void setData(String data) {
    this.data = data.substring(0, data.length()/2);
  }

  @Override
  public String getData() {
    return data;
  }
}
