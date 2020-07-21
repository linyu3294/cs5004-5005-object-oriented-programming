# Assignment 6: Interface Design & Representation Design

```
Related files:
MarbleSolitaireControllerCode.zip
```
```
Controller Lecture.
```
```
Lecture on overdesigning and review on access specifiers
```
```
The Builder Pattern (same as from previous lecture).
```
# 1 Purpose

```
The goal of this assignment is to practice writing a controller. While the model in a program
represents the game state, the controller “runs” the program, effectively facilitating it through a
sequence of operations. This assignment mimics the style of the previous assignment, in that you
are provided an interface that you must implement and adequately test. The class you implement
will act as the controller and work with the model that you created in Assignment 6: The Model.
This controller will “run” a game of Marble Solitaire, asking for input and printing the game
state. Since the game will still be text-based and the I/O will be limited to the console and
keyboard, the notion of a “view” will be minimal in this assignment.
```
```
The only starter file is a type-checking file. You are expected to use your code from Assignment
6 as the starting point for this assignment. However, please ensure all of your new code is in
the cs5004.marblesolitaire.controller package. Additionally, your code from
Assignment 6 should remain in the cs5004.marblesolitaire.model package.
```
# 2 The Controller interface

```
The interface for the Marble Solitaire controller must support the following functionality (as an
interface MarbleSolitaireController):
```
1. A method void playGame(MarbleSolitaireModel model). This method should play a new
    game of Marble Solitaire using the provided model. It should throw an
    IllegalArgumentException if the provided model is null. It should throw an
    IllegalStateException **only** if the controller is unable to successfully receive input or
    transmit output. The nature of input/output will be an implementation detail (see below).

# 3 The Controller implementation

```
Write a class MarbleSolitaireControllerImpl that implements the
MarbleSolitaireController interface above. You will need to:
```
1. Think about which additional fields and types it needs to implement the promised
    functionality.
2. Write a constructor
    MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException.
    Readable and Appendable are two existing interfaces in Java that abstract input and output
    respectively. It should throw the IllegalArgumentException if and only if the readable or
    appendable objects are null.

```
Your controller should accept and store these objects for doing input and output. In this
implementation, whenever you need to take user input, use the Readable object and
whenever you wish to transmit output, use the Appendable object.
```
```
Look at the Readable and Appendable interfaces to see how to read from and write to them.
Ultimately you must figure out a way to transmit a String to an Appendable and read
suitable data from a Readable object. The Scanner may offer a way out.
```
3. The void playGame(MarbleSolitaireModel model) method should play a game. It should
    “run” the game in the following sequence until the game is over:

```
a. Transmit game state to the Appendable object exactly as the model provides it.
```
```
b. Transmit "Score: x", replacing x with the actual score. The last line should end with a
new line.
```
```
c. If the game is ongoing, wait for user input from the Readable object. A valid user input for
a move is a sequence of four inputs (separated by spaces or newlines), asked one at a time:
```
```
i. The row number of the position from where a marble is to be moved.
```
```
ii. The column number of the position from where a marble is to be moved.
```
```
iii. The row number of the position to where a marble is to be moved.
```
```
iv. The column number of the position to where a marble is to be moved.
```
```
To make the inputs more user-friendly, all row and columns numbers in the input begin
from 1.
```
```
The controller will parse these inputs and pass the information on to the model to make the
move. See below for more detail.
```
```
d. If the game has been won, the method should transmit the following in order, each on a
separate line : Message "Game over!", the final game state, "Score: x" with x replaced by
the final score. The last line should end with a new line. The method should then end.
```
```
For example:
Game over!
    X X X
    X X X
X X X X X X X
X X X O X X X
X X X X X X X
    X X X
    X X X
Score: 1
```
```
Key points:
```
```
Quitting: If at any point, the input is either the letter 'q' or the letter 'Q', the controller
should transmit the following in order, each on a separate line: Message "Game quit!",
"State of game when quit:", the current game state, "Score: x" with x replaced by the final
score. The last line should end with a new line. The method should then end.
```
```
For example:
```
```
Game quit!
State of game when quit:
    O O O
    O X O
O O O X O O O
O O O O O O O
O O O O O O O
    O O O
    O O O
Score: 31
```
```
Bad inputs: If an input is unexpected (i.e. something other than 'q', 'Q' or a positive
number) it should ask the user to input it again. If the user entered the from-row and from-
column correctly but the to-row incorrectly, the controller should ask only for to-row
before moving on to to-column. If the move was invalid as signaled by the model, the
controller should transmit a message to the Appendable object "Invalid move. Play again."
plus any informative message about why the move was invalid (all on one line), and
resume waiting for valid input.
```
```
Error handling: The controller should throw an IllegalArgumentException if a null
model is passed to it. The controller should not propagate any exceptions thrown by
the model to its caller. If the Appendable object is unable to transmit output, this method
should throw an IllegalStateException to its caller. Likewise if it is unable to read
from the Readable object (i.e. it ran out of inputs), it should throw an
IllegalStateException to its caller.
```
4. Write sufficient tests to be confident that your code is correct. **Note:** once the model has been
    tested thoroughly (which you hopefully did in Assignment 6), all that remains to be tested is
    whether the controller works correctly in all cases.

```
Be sure to properly document your code with Javadoc as appropriate. Method implementations
that inherit Javadoc need not provide their own unless their contract differs from the inherited
documentation.
```
# 4 Deliverables

```
At a minimum, we need the following files:
```
```
Your interface (MarbleSolitaireModel.java)
```
```
Implementation of your interface (MarbleSolitaireModelImpl.java)
```
```
Your interface (MarbleSolitaireController.java)
```
```
Implementation of your interface (MarbleSolitaireControllerImpl.java)
```
```
Any additional classes necessary to compile your code
```
```
You are free to refactor your model based on any feedback that you’ve recieved on
Assignment 6
```
```
Tests for all your implementations in one or more JUnit test classes. You should include at
least all your tests from Assignment 6, and add to them...
```
```
As with Assignment 6, please submit a zip containing the src/ and test/ directories with no
surrounding directories , so that the autograder recognizes your package structure.
```
# 5 Grading standards

```
For this assignment, you will be graded on
```
```
Whether your interfaces specify all necessary operations with appropriate method signatures,
```
```
whether your code implements the specifications (functional correctness),
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
# 6 Submission

```
Please submit your homework by the above deadline. Then be sure to complete your self
evaluation by the second deadline.
```




