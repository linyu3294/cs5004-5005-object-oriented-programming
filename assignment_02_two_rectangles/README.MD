# Assignment 2: Designing methods for data

```
Goals: Learn to design methods for a class, think of exceptional conditions and test them.
```
# 1 Instructions

```
This homework should be done individually.
```
```
Please adhere to names of classes and signatures of methods.
```
# Google Map Tiles

# 1 Introduction

```
If you have used Google maps (or any other map application) you have seen how it draws the
map using rectangular tiles. As you zoom or pan the map, it loads tiles interactively. It does so
smartly so that it is not using the data connection more than it needs to.
```
```
In order to do this, it always maintains the current part of the map you are looking at as a
rectangle. This rectangle has only horizontal and vertical sides. The rectangle is represented by
its lower-left corner (x,y), its width and its height. All of them are assumed to be integral data,
for simplicity. When you move the map in any way it determines whether it must load additional
map tiles, and if so, which ones. For example:
```
```
When you pan the map, it determines if the rectangle for the current screen overlaps with the
rectangle for the previous screen.
```
```
Given two screen regions represented as rectangles, it wishes to determine which regions are
common to both, so that it does not reload those tiles.
```
```
When you zoom out, it determines the smallest rectangle that covers both the previous
regions and the current regions. It then loads in this as a single tile, which is faster than
loading in several smaller tiles.
```
```
Although implementing any part of Google Maps seems daunting, all these operations can be
implemented on rectangles. The above list corresponds to checking if two rectangles overlap,
determine the intersection of two rectangles and the union of two rectangles. The figure below
illustrates these operations. Note that the union of two rectangles is always a rectangle. Also the
intersection of two rectangles is always a rectangle, if it exists.
```
# 2 What to do

```
For this assignment, you must write a class Rectangle and a tester RectangleTest. The
Rectangle class should have only the following public methods (you can add other non-public
methods):
```
```
Write a constructor that creates a rectangle using the x, y coordinates of its lower left corner,
its width and its height in that order. Creating a rectangle with non-positive width or height
should not be allowed, although x and y are allowed to be negative.
```
```
Write a method overlap(Rectangle other). This method should return true if this
rectangle overlaps with other, false otherwise. Rectangles that touch each other are not
considered to be overlapping.
```
```
Write a method intersect(Rectangle other). This method should return a Rectangle
object that represents the overlap of the two rectangles. If no intersection exists, it should
throw a NoSuchElementException with a helpful message.
```
```
Write a method union(Rectangle other). This method returns a Rectangle object that
represents the union of this rectangle and the other rectangle. The union is the smallest
rectangle that contains both rectangles. Note that unlike the intersection, the union always
exists.
```
```
Write a method toString that returns a String. The string should be formatted exactly as:
“x: 2 , y: 3 , w: 4 , h: 5 ” without the quotation marks and replacing the numbers with the
actual attributes of the object.
```
```
There exists a class called Rectangle in Java already. You are not allowed to use this class
in any way! Make sure that you are not accidentally importing it!
```
```
A few suggestions about tests:
```
```
You need more than one tests for overlap, because there can be several kinds of overlap.
Think about it!
```
```
Write as many tests as you can think of. But you do not need to conflate many tests into one
method: for example, you can write several different methods to test just overlap provided
you isolate the objective of each test.
```
# Hints

```
None of the methods for the Rectangle class need to be large and complicated, if you think
about them carefully. Drawing out several cases and reasoning out these methods on paper may
help!
```
# Criteria for grading

```
You will be graded on:
```
1. The correctness of your methods.
2. Whether your code looks well-structured and clean (i.e. not unnecessarily complicating
    things, or using unwieldy logic).
3. How well you have tested your methods.
4. Whether you have written enough comments for your classes and methods, and whether they
    are in proper Javadoc style.
5. Whether you have used access modifiers correctly: public and private.
6. Whether your code is formatted correctly (according to the style grader).

# How to submit

1. Create a zip file that contains directly your _src_ and _test_ folders. When you unzip the file, you
    should see only these two folders.
2. Log on to the Bottlenose submission server.
3. Navigate to _Assignment 2_ and submit the zip file.
4. Wait for a few minutes for feedback to appear, and take action if needed.


