package cs5004.turtle.control.commands;

import cs5004.turtle.control.TracingTurtleCommand;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by ashesh on 10/28/2016.
 */
public class Retrieve implements TracingTurtleCommand {
  @Override
  public void go(TracingTurtleModel m) {
    m.retrieve();
  }
}
