package cs5004.turtle.control.commands;


import cs5004.turtle.control.TracingTurtleCommand;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by ashesh on 10/26/2016.
 */
public class Koch implements TracingTurtleCommand {

  private double d;
  private int depth;

  public Koch(double distance,int depth) {
    d = distance;
    this.depth = depth;
  }
  @Override
  public void go(TracingTurtleModel m) {
    drawKoch(d,depth,m);
    m.turn(-120);
    drawKoch(d,depth,m);
    m.turn(-120);
    drawKoch(d,depth,m);
    m.turn(-120);
  }

  private void drawKoch(double distance,int depth,TracingTurtleModel model) {
    if (depth>0) {
      drawKoch(distance/3,depth-1,model);
      model.turn(60);
      drawKoch(distance/3,depth-1,model);
      model.turn(-120);
      drawKoch(distance/3,depth-1,model);
      model.turn(60);
      drawKoch(distance/3,depth-1,model);
    }
    else {
      model.trace(distance);
    }
  }
}
