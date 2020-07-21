# Assignment 5: The Model

```
Related files:
MarbleSolitaireModelStarter.zip
```
# Assignment 5: The Model

# 1 Marble Solitaire

```
Image credit: Photo by
Gnsin edited by
WolfgangW. (Photo by
Gnsin GFDL or CC-BY-
SA-3.0, via Wikimedia
Commons)
```
```
In the upcoming
assignments, you will
implement a game
called “Peg Solitaire.”
This is a board game
played by a single
player. The game
involves moving pegs
on a game board with
holes. Many modern versions using marbles instead of pegs, giving it the name “Marble
Solitaire.” The image above shows a Marble Solitaire board. It is referred to as a Solitaire-type
game, and is also called Brainvita in some countries. If you have not played this game before, try
it here!
```
# 1.1 Game Play

```
The game starts by arranging marbles on the board. Exactly one slot is empty, and is traditionally
the center slot.
```
```
A move is made by making one marble jump over exactly one marble and land in an empty slot
exactly two positions away. When such a move is made, the marble that is jumped over is
removed. Therefore, each single valid move increases the number of empty slots by one. A
marble can only jump horizontally or vertically. The game ends when no more valid moves can
be made. At any point in the game, the score is the number of marbles on the board. The
objective of the game is to make moves so as to end up with the minimum score when the game
ends.
```
```
In this assignment you will write the model for this game. The model will maintain the state of
the game and allow a client to specify moves. You are not required to make the game playable at
this point.
```
# 2 Building Marble Solitaire

# 2.1 Expected operations

```
In order to play the game, the client would expect the following operations: start a new game,
make a move, get the current state of the game, get the current score and know when the game
has ended. These operations have been specified and documented in the provided
MarbleSolitaireModel interface. You are not allowed to change the interface in any way!
```
```
A short explanation of the methods in the interface follows:
```
```
move(int fromRow, int fromColumn, int toRow, int toColumn) is called to make a
move according to the rules of the game. Specifically it will move a marble from the position
(fromRow, fromColumn) to the position (toRow, toColumn) if the move is valid. It will
throw an IllegalArgumentException if the move cannot be made.
```
```
See below for implementation-specific details of how to refer to positions on the board.
```
```
String getGameState() returns the current state of the game as a String object. The exact
format of this string is dependent on the implementation (see below).
```
```
isGameOver returns true if the game is over, and false otherwise.
```
```
int getScore() returns the current score in the game.
```
# 2.2 Examples

```
You must check that your MarbleSolitaireModelImpl implementation of the
MarbleSolitaireModel interface works as specified. We recommend that you create an empty
implementation, and then proceed to write your tests. This will allow you to understand how
your class will be used, which will help you to implement it. Since you are testing the public-
facing behavior of this interface, you should not place this testing code in the
cs5004.marblesolitaire.model package, but rather place it in the default package.
```
# 2.3 Your Implementation

```
Implement the MarbleSolitaireModel interface in a class called MarbleSolitaireModelImpl:
```
1. Design a suitable representation of this game. Think carefully about what fields and types you
    will need, and how possible values of the fields correspond to game states.
2. Although the traditional game is as shown above, we can generalize the dimensions of this
    board while retaining its shape. We define the **arm thickness** as the number of marbles in the
    top row (or bottom row, or left or right columns). In the traditional game, the arm thickness is
    3, making the length of the largest row/column 7. **In general, a board of arm thickness** **_a_** **is**
    **a board with a single square of size** **_a_** **, with 4 squares of the same size joined at its four**
    **sides to form a plus shape.** In order to keep the “center” unique, the arm thickness must be
    an odd number to be valid. The board scales while keeping the four arms of the plus shape the
    same size.
3. Positioning: A position is specified using a pair (row, column), assuming that the board is
    laid on a rectangular grid. The row and column numbers start at 0 in the top-left corner,
    increasing top to bottom and left to right respectively. For example in the above picture, the
    positions of the three marbles in the top row are ( 0 , 2 ), ( 0 , 3 ) and ( 0 , 4 ) respectively.
    The empty slot is at ( 3 , 3 ).
4. **Instantiating the game:** Your class should support **four** ways to instantiate it:

```
The first constructor should take no parameters, and initialize the game board as shown
above (arm thickness 3 with the empty slot at the center).
```
```
A second constructor should take two parameters: sRow and sCol. It should initialize the
game board so that the arm thickness is 3 and the empty slot is at the position
(sRow, sCol). If this specified position is invalid, it should throw an
IllegalArgumentException with a message "Invalid empty cell position (r,c)"
with and replaced with the row and column passed to it.
```
```
The third constructor should take the arm thickness as its only parameter and initialize a
game board with the empty slot at the center. It should throw an
IllegalArgumentException if the arm thickness is not a positive odd number.
```
```
Finally a fourth constructor should take the arm thickness, row and column of the empty
slot in that order. It should throw an IllegalArgumentException if the arm thickness is
not a positive odd number, or the empty cell position is invalid.
```
```
Carefully think about the shape of the board and our positioning scheme to infer which
positions are invalid.
```
5. **The game state:** The getGameState method may be used to print the game state in the
    format illustrated below. Specifically each slot should be one character (' ', 'O' or '_') and
    there should be one space between the positions. There should be no spaces after the last slot
    in a row. The following shows the output corresponding to the screenshot above:
       O O O
       O O O
       O O O O O O O
       O O O _ O O O
       O O O O O O O
       O O O
       O O O

```
NOTE: The string you return should not have a newline at the end of the last line.
```
6. **Move:** The move method should make the move and change the game state appropriately. A
    move is valid if all these conditions are true: (a) the “from” and “to” positions are valid (b)
    there is a marble at the specified “from” position (c) the “to” position is empty (d) the “to”
    and “from” positions are exactly two positions away (horizontally or vertically) (e) there is a
    marble in the slot between the “to” and “from” positions. Any invalid move should result in
    an IllegalArgumentException exception with an appropriate message on a single line. The
    text of the message is up to you.

```
For example, the only valid moves on the board shown above start from ( 5 , 3 ), ( 1 , 3 ),
( 3 , 1 ) or ( 3 , 5 ), and all move to ( 3 , 3 ).
```
```
Be sure to properly document your code with Javadoc as appropriate. Method implementations
that inherit Javadoc need not provide their own unless they implement something different or in
addition to what is specified in the inherited documentation.
```
```
File TypeChecks.java contains a small class designed to help you detect when your code may
not compile against the grading tests. In particular, if your project cannot compile while
TypeChecks.java—unmodified!—is a part of it, then it won’t compile for the course staff
either.
```
# 3 Package Management

```
To make sure that your packages are in the correct layout, you should tell IntelliJ to do the
following. Do this early, before you’ve written much code, to ensure that your files wind up in
the right locations automatically, instead of having to fix it afterward:
```
```
When you create a new project, you should see something like this:
```
```
Notice that the src directory is marked blue, which means IntelliJ believes that this directory
contains the source files of your project. To create a new package, right-click on the src
directory, select New -> Package. In the dialog box that pops up, enter the new package name
```
```
To create new files within a particular package, right-click on the package folder and select
New -> Java Class. If you want to create a new file in the default package, then select the src
directory itself.
```
```
To create a test directory, right-click on the project itself, and select New -> Directory. In the
dialog box that pops up, enter “test” as the name. Right-click on the directory, select Mark
Directory As -> Test Sources root. Henceforth, you should add any test classes in this folder.
See the tutorial video for a demo of this.
```
# 4 List of Deliverables

```
The interface (MarbleSolitaireModel.java)
```
```
Implementation of the interface(MarbleSolitaireModelImpl.java)
```
```
Any additional classes you saw fit to write
```
```
Tests in one or more JUnit test classes
```
```
Again, please ensure all of your project’s source is in the cs5004.marblesolitaire.model
package. The autograder will give you an automatic 0 if it cannot compile your code! Place
your tests in the default package.
```
# 5 Grading Standards

```
For this assignment, you will be graded on
```
```
whether your code implements the specification (functional correctness),
```
```
the appropriateness of your chosen representation,
```
```
the clarity of your code,
```
```
the comprehensiveness of your test coverage
```
```
how well you have documented your code
```
```
how well you follow the style guide.
```
# 6 Submission

```
Please submit your assignment to https://handins.ccs.neu.edu/ by the above deadline. Then be
sure to complete your self evaluation by the second deadline.
```


