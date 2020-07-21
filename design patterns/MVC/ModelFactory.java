/**
 * Created by vidojemihajlovikj on 6/19/19.
 */
public class ModelFactory {
  public static IModel makeModel(){
    //ComplicatedModel model = new ComplicatedModel(2,2,2,2,"");
    //ComplicatedModel.Builder builder = new ComplicatedModel.Builder();

    return ComplicatedModel.makeBuilder().setColor("green").setHeight(10).setWidth(5).build();
  }
}
