package cs5004.turtle.control.commands;

import cs5004.turtle.control.TracingTurtleCommand;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class Move implements TracingTurtleCommand {
  double d;

  public Move(Double d) {
    this.d = d;
  }

  @Override
  public void go(TracingTurtleModel m) {
    m.move(this.d);
  }
}
