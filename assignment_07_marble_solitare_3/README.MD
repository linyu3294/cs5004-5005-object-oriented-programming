# Assignment 7: The Polymorphic Marble Solitaire

# 1

# 1.1 Purpose

```
The benefits of the model-view-controller architecture shine when we need to add new features,
by isolating relevant parts of our design and changing them independently. In this assignment we
will see those benefits pay off by supporting other forms of Marble Solitaire. The goal of this
assignment is to give you a chance to critically examine your earlier design choices, and either
leverage or revise them to enable adding variations of this game with minimal change and
duplication of code.
```
```
All new classes and interfaces for this homework should be in the
cs5004.marblesolitaire.model.hw08 package. All classes written in previous
assignments, even if improved upon, should remain in their respective packages.
```
# 1.2 Marble Solitaire with other shapes

```
As was observed in class earlier, there is nothing intrinsic about the board shape or size we’re
using, and we can imagine the rules of this game being applied to boards of different sizes and
shapes. The board that you implemented in Assignment 6 is known as English Peg Solitaire. In
this assignment you will consider two more variations:
```
```
A European Peg Solitaire board is similar to an English board, except the corners between the
arms of the cross are filled in to produce an octagon shape. The initial hole will again be in the
center.
```
```
Perhaps a more interesting variant is Triangular Peg Solitaire. As its name suggests, the board
for Triangular Peg Solitaire has pegs arranged in an equilateral triangle. A family of such games
can be created by modifying the dimension of this board, in the form of the number of pegs in its
bottom-most row. The following figure shows a 6-row Triangular Peg Solitaire version.
```
```
What sets this variant apart from the English and European versions is that the pegs are not
arranged in a rectangular grid. We arbitrarily set a coordinate system to align with the board as
shown in the figure above. Specifically, the pegs in row i (starting with row 0) can be indexed as
(i,0) to (i,i). You may think of this as a pair of axes (like the rectangular grid) whose vertical axis
is aligned with the left edge of the triangle (instead of vertical like that in the rectangular grid).
```
```
Like previous versions, this game also starts with a single empty slot whose position can be
customized. Marbles can move by jumping over one marble into an empty slot, as before.
Because the board is not rectilinear, the jump rules change a bit. Each marble can jump to (a)
positions in its own row two columns away left or right; or (b) positions that are two rows above
and below, along the four diagonal directions. For example in the above figure the marble from
(5,3) can move to (5,1), (5,5), (3,1) and (3,3), if those positions were empty and
they could jump over a marble. Similarly, the marble from (3,2) can move to (3,0), (5,2)
and (5,4) and (1,0). As before, the score is the number of marbles on the board. The game
ends when no more marbles can move, and the game must be played to minimize the score.
```
# 1.3 Assignment Requirements and Design Constraints

1. Design classes implementing the European and Triangular variants of Marble Solitaire.
    (These are described in Section 4 and Section 5 below.)
2. Implement a main method to allow you to choose different board shapes from the command
    line, when running your program. (This is described in Section 6 below.)
3. Test everything thoroughly: make sure the new models work properly, and that the controller
    can control them as well as it could the original model. You do not need to test your main
    method, though.

```
You must complete these requirements while respecting the following constraints:
```
```
You are not allowed to change the interface of the model (MarbleSolitaireModel) at all
from Assignment 6.
```
```
You are not allowed to change the controller interface (MarbleSolitaireController) at all
from Assignment 7.
```
```
You must create separate model implementations, without eliminating
MarbleSolitaireModelImpl from Assignment 6. That is, models that represent all
variations of the game must co-exist.
```
```
In this assignment it is important not only to have a correctly working model, but also a design
that uses interfaces and classes appropriately. Make sure you minimize replication of code. You
may refactor your earlier designs to do this. You may also have to change earlier
implementations to remove bugs. This is OK, but must be properly documented and justified.
Again, you are not allowed to change existing interfaces or add new public methods.
```
# 1.4 The EuropeanSolitaireModelImpl class

```
Design a class with the above name that implements the MarbleSolitaireModel interface from
earlier assignments. Besides implementing all required methods, this class should offer the
following constructors:
```
```
A default constructor (no parameters) that creates an octagonal board whose sides have length
3, with the empty slot in the center of the board.
```
```
A constructor with a single parameter (the side length) that creates a game with the specified
side length, and the empty slot in the center of the board.
```
```
A constructor with two parameters (row, col), to specify the initial position of the empty slot,
in a board of default size 3.
```
```
A constructor with three parameters (side length, row, col), to specify the size of the board
and the initial position of the empty slot.
```
```
The getGameState() method should create a string that represents the game board, as before.
Here is an example of the default board:
```
```
    O O O
  O O O O O
O O O O O O O
O O O _ O O O
O O O O O O O
  O O O O O
    O O O
```
```
(As with prior homework, there are no trailing spaces after the last position on each row, and the
game state does not end in a newline character.)
```
```
Strong hint: this model is very, very similar to the one you build in Assignment 6. Your code
should take advantage of that fact. Use an abstract base class to factor out the common code
between these two model implementations. Ideally, the only code that should remain in the
concrete classes are the constructors themselves.
```
# 1.5 The TriangleSolitaireModelImpl class

```
Design a class with the above name that implements the MarbleSolitaireModel interface from
earlier assignments. Besides implementing all required methods, this class should offer the
following constructors:
```
```
A default constructor (no parameters) that creates a 5-row game with the empty slot at (0,0).
```
```
A constructor with a single parameter (dimensions) that creates a game with the specified
dimension (number of slots in the bottom-most row) and the empty slot at (0,0). This
constructor should throw the IllegalArgumentException exception if the specified
dimension is invalid (non-positive).
```
```
A constructor with two parameters (row,col) that creates a 5-row game with the empty slot at
the specified position. This constructor should throw the IllegalArgumentException
exception if the specified position is invalid.
```
```
A constructor with three parameters (dimensions,row,col) that creates a game with the
specified dimension and an empty slot at the specified row and column. This constructor
should throw the IllegalArgumentException exception if the specified dimension is invalid
(non-positive) or the specified position is invalid.
```
```
The getGameState() method should create a string that represents the game board, as before.
Here is an illustrative example:
```
```
      O
     O O
    O O _
   O O O O
  O O O O O
 O O O O O O
O O O O O O O
```
```
(As with prior homework, there are no trailing spaces after the last position on each row, and the
game state does not end in a newline character.)
```
```
Hint: this board is somewhat different from the other two, because its coordinate system is not
standard Cartesian coordinates. Moreover, the set of legal moves from a given coordinate is
different (as described earlier). Still, there is much that is similar between these models. You can,
and should try to, successfully have this model extend the abstract base class above.
```
# 1.6 The main() method

```
Add the following class to your project:
```
```
package cs5004.marblesolitaire;
```
```
public final class MarbleSolitaire {
public static void main(String[] args) {
// FILL IN HERE
}
}
```
```
This main() method will be the entry point for your program. Your program needs to take inputs
as command-line arguments (available in your program through the argument args above).
Review the documentation for command-line arguments in a Java program.
```
```
Specifically:
```
```
You must pass one of english, european, or triangular. This argument will decide
which board shape (and hence which model) you should use.
```
```
You may optionally pass the two arguments -size N, where N is a number, to specify the
size of the board. If unspecified, you should use the default size for the chosen board shape.
```
```
You may optionally pass the three arguments -hole R C, where R and C are numbers, to
specify the row and column of the initial hole. If unspecified, you should use the default hole
position for the chosen board shape.
```
```
The following are some examples of valid command lines, and their meanings:
```
```
english -size 6 produces a plus-shaped board (as in homework 5) with arm-width of 6,
and initial hole in the center
```
```
triangular produces a triangle-shaped board (as in this assignment) with side-length 5,
and initial hole at the top
```
```
triangular -size 4 produces a triangle-shaped board (as in this assignment) with
side-length 4, and initial hole at the top
```
```
european -hole 1 4 produces an octagon-shaped board (as in this assignment) with
side-length 3, and the initial hole in the middle of the top edge.
```
```
This is not an exhaustive list; other command lines are possible.
```
```
These arguments will appear in the String[] args parameter to your main method; you can use
them however you need to, to configure your models. For this assignment, you do not need to
explicitly handle invalid command lines (e.g. by producing an informative error message).
```
# 1.6.1 To actually run your program with command line

# arguments in IntelliJ IDEA:

```
Go to Run > Edit configurations
```
```
Click the + button in the upper left, and select Application from the dropdown that
appears.
```
```
Give the new configuration a name that you’ll remember (e.g. "English size 3").
```
```
In the Main class textbox, enter cs5004.marblesolitaire.MarbleSolitaire
```
- the fully-qualified name of the class with your main method.

```
In the Program arguments textbox, enter the command line arguments you want to use
for this configuration, e.g. english -size 3
```
```
Leave everything else at their defaults, and click Ok.
```
```
You can repeat this process as many times as you want, to make as many run configurations as
you need. Then to choose among them, use the dropdown menu next to the run icon in the
toolbar:
```
```
and press Run.
```
# 1.7 Deliverables

```
Your EuropeanSolitaireModelImpl and TriangleSolitaireModelImpl classes, and any
support classes needed
```
```
Your controller and model classes and related interfaces from Assignment 6 and Assignment
7 (with as few changes to the classes as possible, and any changes fully explained in
comments)
```
```
Your class with the main() method.
```
```
Tests for all models in one or more JUnit test classes. It is a good idea to include your earlier
tests as well, for regression testing. We certainly will...
```
```
All new classes and interfaces for this homework should be in the
cs5004.marblesolitaire.model.hw08 package. All classes written in previous
assignments, even if improved upon, should be in their respective packages.
```
# 1.8 Grading standards

```
For this assignment, you will be graded on
```
```
Whether you had to modify any previously written interfaces,
```
```
whether your h implements the specifications (functional correctness),
```
```
how well your code is structured to avoid duplication, improve readability, etc.
```
```
the clarity of your code,
```
```
the comprehensiveness of your test coverage, and
```
```
how well you follow the style guide.
```
```
Please submit your homework to https://handins.ccs.neu.edu/, then be sure to complete your self
evaluation.
```

