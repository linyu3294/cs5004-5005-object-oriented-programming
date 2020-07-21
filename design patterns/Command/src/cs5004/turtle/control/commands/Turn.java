package cs5004.turtle.control.commands;

import cs5004.turtle.control.TracingTurtleCommand;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class Turn implements TracingTurtleCommand {
  double d;

  public Turn(Double d) {
    this.d = d;
  }

  @Override
  public void go(TracingTurtleModel m) {
    m.turn(this.d);
  }
}
