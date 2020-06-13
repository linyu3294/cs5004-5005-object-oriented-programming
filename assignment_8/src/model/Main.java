package model;

import model.model.IModel;
import model.model.Model;
import model.motion.ChangeColor;
import model.motion.IMotion;
import model.motion.Scale;
import model.shape.ShapeType;

/**
 * This is a main class.
 */
public class Main {
  /**
   * Main entry point for the program.
   */
  public static void main(String[] args) {
    IModel model = new Model();

    model.addShape("R", ShapeType.RECTANGLE, 1, 39, 1, 1, 1, 1, 20, 20, 20);
    model.addShape("B", ShapeType.OVAL, 3, 45, 2, 2, 2, 2, 5, 5, 5);

    IMotion motion3 = new ChangeColor("R", 13, 16, 30, 30, 30, 40, 40, 40);
    model.addMotion(motion3);

    IMotion motion1 = new ChangeColor("R", 2, 10, 30, 30, 30, 40, 40, 40);
    model.addMotion(motion1);

    IMotion motion4 = new Scale("R", 5, 7, 5, 2, 8, 8);
    model.addMotion(motion4);

    IMotion motion2 = new ChangeColor("R", 10, 13, 30, 30, 30, 40, 40, 40);
    model.addMotion(motion2);

    IMotion motion5 = new ChangeColor("R", 46, 49, 30, 30, 30, 40, 40, 40);
    model.addMotion(motion5);


    System.out.print(model.getState());


  }
}
