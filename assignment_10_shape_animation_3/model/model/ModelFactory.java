package model.model;

import java.io.FileNotFoundException;

import util.AnimationFileReader;
import util.TweenModelBuilder;

/**
 * This is a class that makes a model given the input file path.
 */
public class ModelFactory {
  /**
   * Creates a model from a input file. Model stores information about the shapes and motions of an
   * animation.
   *
   * @param filePath - The path of an input file.
   * @return IModel - A concrete class of the model.
   * @throws IllegalStateException - when a general Exception is thrown during building a model.
   * @throws FileNotFoundException - when input file path is invalid.
   */
  public static IModel makeModel(String filePath)
          throws IllegalStateException, FileNotFoundException {
    TweenModelBuilder<IModel> modelBuilder = new ModelImpl.Builder();
    AnimationFileReader anima = new AnimationFileReader();
    IModel model;
    try {
      model = anima.readFile(filePath, modelBuilder);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File parameter not Found");
    } catch (Exception e) {
      throw new IllegalStateException("AnimationFileReader failed to convert file to model");
    }
    return model;
  }
}
