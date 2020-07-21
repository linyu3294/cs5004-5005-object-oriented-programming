package view;

import java.io.IOException;
import java.util.List;

import model.model.IModel;
import model.motion.ChangeColor;
import model.motion.IMotion;
import model.motion.Move;
import model.motion.Scale;
import model.shape.IShape;
import model.shape.Oval;
import model.shape.Rectangle;

/**
 * A class used to display IModel info in a svg format.
 */
public class SVGView implements IView {
  private List<IMotion> motions;
  private Appendable out;
  private int windowWidth;
  private int windowHeight;
  private String[] sections;
  private int speed;

  /**
   * Parses the shapes and motions in a model and appends them to an Appendable object.
   *
   * @param model -IModel object.
   * @param out   - An appendable object.
   * @param speed - The speed defined by ticks per second.
   * @throws IOException when appending the model info fails.
   */
  @Override
  public void appendView(IModel model, Appendable out, int speed)
          throws IOException {
    this.motions = model.getMotions();
    this.out = out;
    this.speed = speed;

    try {
      out.append("<svg width=\"1200\" "
              + "height=\"900\" "
              + "version=\"1.1\" " +
              "xmlns= \"http://www.w3.org/2000/svg\">\n\n");
      for (IShape shape : model.getShapes()) {
        appendShape(shape);
      }
      out.append("</svg>");
    } catch (IOException e) {
      throw new IOException("Error when appending the svg view.");
    }
  }


  private void appendShape(IShape shape) throws IOException {
    String shapeType = "";
    String xType = "";
    String yType = "";
    String widthType = "";
    String heightType = "";
    if (shape instanceof Rectangle) {
      shapeType = "rect";
      xType = "x";
      yType = "y";
      widthType = "width";
      heightType = "height";
    }
    if (shape instanceof Oval) {
      shapeType = "ellipse";
      xType = "cx";
      yType = "cy";
      widthType = "rx";
      heightType = "ry";
    }
    try {

      out.append(
              "<" + shapeType + " "
                      + "id=\"" + shape.getID() + "\" "
                      + xType + "=\"" + shape.getX() + "\" "
                      + yType + "=\"" + shape.getY() + "\" "
                      + widthType + "=\"" + shape.getW() + "\" "
                      + heightType + "=\"" + shape.getH() + "\" "
                      + "fill=\"rgb" + "("
                      + (shape.getR() * 255) + ","
                      + (shape.getG() * 255) + ","
                      + (shape.getB() * 255) + ")\" "
                      + "visibility=\"visible\" >\n"
      );
      for (IMotion motion : motions) {
        if (motion.getID().equals(shape.getID())) {
          appendMotion(motion, xType, yType, widthType, heightType);
        }
      }

      out.append("</" + shapeType + ">\n\n");
    } catch (IOException e) {
      throw new IOException("Error when appending the svg view.");
    }
  }


  private void appendMotion(IMotion motion,
                            String xType,
                            String yType,
                            String widthType,
                            String heightType) throws IOException {
    String [] attributeName = null;
    String [] fromAttr = null;
    String [] toAttr = null;


    if (motion instanceof ChangeColor) {
      int steps = 3;
      attributeName = new String[]{"fill"};
      fromAttr = new String[1];
      fromAttr[0] = String.valueOf(
              "rgb(" +

                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[0]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[0]) * 255) + ", "
                      +
                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[0]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[1]) * 255) + ", "
                      +
                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[0]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[2]) * 255)
                      + ")");
      toAttr = new String[1];
      toAttr[0] = String.valueOf(
              "rgb(" +

                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[1]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[0]) * 255) + ", "
                      +
                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[1]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[1]) * 255) + ", "
                      +
                      (Double.parseDouble(
                              motion.getState()
                                      .split("from")[1]
                                      .split("to")[1]
                                      .trim()
                                      .replace("(", "")
                                      .replace(")", "")
                                      .split(",")[2]) * 255)
                      + ")");
    }

    if (motion instanceof Move) {
      attributeName = new String[]{xType, yType};
      fromAttr = new String[2];
      fromAttr[0] = motion.getState().split(",")[0].split("\\(")[1].trim();
      fromAttr[1] = motion.getState().split(",")[1].split("\\)")[0].trim();
      toAttr = new String[2];
      toAttr[0] = motion.getState().split(",")[1].split("\\(")[1].trim();
      toAttr[1] = motion.getState().split(",")[2].split("\\)")[0].trim();
    }
    if (motion instanceof Scale) {
      attributeName = new String[]{"transform\" type=\"scale\" additive=\"sum"};
      String[] orgSize = motion.getState().split("from")[1]
              .replace("Width: ", "")
              .replace("Height: ", "")
              .split("to")[0].split(",");
      String[] scaleSize = motion.getState().split("from")[1]
              .replace("Width: ", "")
              .replace("Height: ", "")
              .split("to")[1].split(",");
      fromAttr = new String[1];
      toAttr = new String[1];
      fromAttr[0] = "1,1";
      toAttr[0] = (Double.parseDouble(orgSize[0]) / Double.parseDouble(scaleSize[0]))
              + "," +
              (Double.parseDouble(orgSize[1]) / Double.parseDouble(scaleSize[1]));
    }
    for (int i = 0; i < attributeName.length; i++) {
      try {
        this.out.append("<animate attributeType = \"xml\" "
                + "begin=\""
                + (motion.getStartTime() * 1000) / speed + "ms\" "
                + "dur=\""
                + ((motion.getEndTime() - motion.getStartTime()) * 1000) / speed + "ms\" "
                + "attributeName=\""
                + attributeName[i]
                + "\" "
                + "from=\""
                + fromAttr[i]
                + "\" "
                + "to=\""
                + toAttr[i]
                + "\" "
                + "fill=\"freeze\" />\n");
      } catch (IOException e) {
        throw new IOException("Error when appending the svg view.");
      }
    }
  }
}
