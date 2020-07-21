package cs5004.turtle.control.commands;

import cs5004.turtle.control.TracingTurtleCommand;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class Square implements TracingTurtleCommand {
  double d;

  public Square(Double d) {
    this.d = d;
  }

  @Override
  public void go(TracingTurtleModel m) {
    for (int i = 0; i < 4; i++) {
      m.trace(this.d);
      m.turn(90);
    }
  }
}
