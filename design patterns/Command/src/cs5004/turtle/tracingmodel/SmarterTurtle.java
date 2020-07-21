package cs5004.turtle.tracingmodel;

import java.util.ArrayList;
import java.util.List;

import cs5004.turtle.model.Position2D;
import cs5004.turtle.model.SimpleTurtle;

/**
 * Created by blerner on 10/10/16.
 */
public class SmarterTurtle extends SimpleTurtle implements TracingTurtleModel {
  public SmarterTurtle() {
    super();
    lines = new ArrayList<>();
  }


  @Override
  public void trace(double distance) {
    Position2D cur = this.getPosition();
    move(distance);
    lines.add(new Line(cur, this.getPosition()));
  }

  @Override
  public List<Line> getLines() {
    return new ArrayList<>(lines);
  }

  //list of lines traced since this object was created
  List<Line> lines;

}


/*
10/03 : Misc topics (testing, toString, Pile abstractions, Readable/Appendable)

10/05: Encapsulation and invariants

Hw3

10/10: columbus day

10/12: Design problem (Turtles) -- talk through modelling of nouns (get to positions, lines?, turtles, tracing turtles extend simple turtles), get up to Commands as an abstraction, but not undoable ones, set up keyboard map but don't do it yet

HW4 due 10/14

10/17: Inheritance and composition

10/19: Intro to performance, More about performance

Hw5 due

10/24: First exam

10/26: Design discussion of music  models

10/31: Class activity: GUI (bad, basic mvc examples), MIDI

11/02: Adapters

Hw6 due on 11/7

11/07: Commands

11/09: Commands (Class activity: adapters (Turtles))

11/14: Strategy (and decorator?) patterns


11/16: XXX (Command/Observer)

11/21: XXX (Singleton/Iterator/Proxy)

Hw7 due 11/21

11/28: Intro to Javascript

11/30: Javascript inheritance and patterns

12/05: Exam review

12/07: Promises/Android



adapters, strategy - TicTacToe, command - move, turn, ...square, ...fractal, undoable?




Position2D exists
TurtleModel interface exists
SimpleTurtle exists

talk-through SimpleTurtle

motivate tracing

design TracingTurtleModel -- is it a TurtleModel? yes, so extend interface
implement SmarterTurtle -- extend or delegate?  either way will work, but inheritance is simpler

motivate the command-line controller

design the controller with hard-coded switch with hard-coded method calls (move, turn, trace)

have some simple tests

add a new square case

test??? introduce Commands


 */