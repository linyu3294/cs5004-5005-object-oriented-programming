package cs5004.turtle.control;

import java.util.InputMismatchException;
import java.util.Scanner;

import cs5004.turtle.control.commands.Move;
import cs5004.turtle.control.commands.Square;
import cs5004.turtle.control.commands.Trace;
import cs5004.turtle.control.commands.Turn;
import cs5004.turtle.tracingmodel.Line;
import cs5004.turtle.tracingmodel.SmarterTurtle;
import cs5004.turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class CommandController {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    TracingTurtleModel m = new SmarterTurtle();
    TracingTurtleCommand cmd = null;
    while (s.hasNext()) {
      String in = s.next();
      try {
        switch (in) {
          case "q":
          case "quit":
            return;
          case "show":
            for (Line l : m.getLines()) {
              System.out.println(l);
            }
            break;
          case "move":
            cmd = new Move(s.nextDouble());
            break;
          case "trace":
            cmd = new Trace(s.nextDouble());
            break;
          case "turn":
            cmd = new Turn(s.nextDouble());
            break;
          case "square":
            cmd = new Square(s.nextDouble());
            break;
          default:
            System.out.println(String.format("Unknown command %s", in));
            cmd = null;
            break;
        }
        if (cmd != null) cmd.go(m);
      } catch (InputMismatchException ime) {
        System.out.println("Bad length to " + in);
      }
    }
  }
}
