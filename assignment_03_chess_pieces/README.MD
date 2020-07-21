# Assignment 3: Chess Pieces

# Chess pieces

# Introduction

```
A game of chess has several kinds of pieces: pawns, knights, bishops, rooks, queens and kings.
These pieces are arranged on a chess board as shown in the figure below.
```
```
(Image taken from
http://www.chess-game-strategies.com/images/kqa_chessboard_large-picture_2d.gif)
```
```
A cell on the board is specified by a (row,column) tuple: rows increasing from bottom to top and
columns increasing from left to right. Traditionally the black pieces are arranged in the top two
rows as shown.
```
```
Each chess piece can move in a specific way. In addition to moving, each chess piece can also
kill a chess piece of the opposite color if it moves to its place. The rules for each chess piece are
as follows:
```
```
Bishop: A bishop can only move diagonally, and kill any opponent’s piece if it can move to its
place.
```
```
Knight: A knight can move only in an L pattern: two cells horizontally and one vertically or
vice versa. It can kill any opponent’s piece if it can move to its place.
```
```
Queen: A queen can move horizontally, vertically and diagonally. It can kill any opponent’s
piece if it can move to its place.
```
```
Rook: A rook can move horizontally or vertically. It can kill any opponent’s piece if it can
move to its place.
```
```
Pawn: A pawn is interesting: it can move only “ahead”, not backwards towards where its
color started. It can move only one place forward in its own column. However to kill it must
move one place forward diagonally (it cannot kill by moving straight).
```
# What to do

```
You must design and implement classes that represent the above chess pieces. These classes
should be named exactly as their names above, and all of them should implement the
ChessPiece interface. Each chess piece should be able to (a) return its current position on the
chess board, as methods getRow() and getColumn() (b) return its color (c) determine if it can
move to a given cell, as a method canMove(int row,int col), (d) determine if it can kill a
provided piece starting from where it currently is, as a method canKill(ChessPiece piece).
In addition, each chess piece should have a constructor that takes in an initial position as a row
and column, and a color as an enum Color with values BLACK and WHITE. All rows and columns
begin with 0. Rows decrease in number from top to bottom in the above chessboard.
```
```
Beyond these classes, interface and methods, you are free to design any other interfaces and
classes as you see fit. However they must have good justification, are designed appropriately and
are placed in the appropriate place.
```
```
You must then write tests for each chess piece that tests these operations thoroughly.
```
# How to submit

1. Create a zip file that contains directly your _src_ and _test_ folders. When you unzip the file, you
    should see only these two folders.
2. Log on to the Bottlenose submission server.
3. Navigate to _Assignment 3_ and submit the zip file.
4. Wait for a few minutes for feedback to appear, and take action if needed.


