# Assignment 1: Writing a simple class and testing it

```
Goals: Practice designing the representation of data, writing getter methods and testing them.
```
# 1 Instructions

```
This homework should be done individually.
Pay attention to naming! Our test files expect your submissions to be named a certain way.
Therefore, whenever the assignment specifies:
the names of classes,
the names and types of the fields within classes,
the names, types and order of the arguments to the constructor, or
filenames
...be sure that your submission uses exactly those names.
Due Date: Check the deadline on the handins server.
```
# 2 Vectors

# 2.1 Introduction

```
Vectors are commonly used in Math and physics. A vector (in 3D) is signified by a direction and
a length (magnitude). It is commonly represented as three components: x, y and z. Some
operations on vectors include:
Magnitude: for a vector this is denoted as =
Normalizing a vector: this is a vector that is obtained by dividing each component of a vector
by its magnitude.
Addition of two vectors: a vector sum is a vector that is obtained by adding respective
components of the two vectors.
Multiplying a vector by a constant: this produces a vector obtained by multiplying each
component of the current vector by the provided constant.
Dot product: The dot product of two vectors v= and w= is defined as a
number.
Angle between two vectors: This is defined as. Technically given two
vectors, there are two angles between them. This returns the shorter of the two angles.
For example, if the two vectors align with the clock hands at 3pm, this would return 90
degrees.
```
# 2.2 What to do

```
Write a class Vector3D that represents a 3D vector. This class should contain the following:
```
1. A constructor that takes in x, y, z components of the vector.
2. Methods to get the values of individual components (e.g. getX ,etc.).
3. A toString method that returns a string that describes this vector. This string should be of
    the form “(x,y,z)” replacing the letters with their values. Each component should be formatted
    to round to exactly two decimal places (look at the String.format method to see how to do
    this).
4. A method getMagnitude that returns its magnitude.
5. A method normalize that returns a normalized version of this vector.It should throw an
    IllegalStateException object if this operation cannot be completed.
6. A method add that returns the result of adding this vector to another vector. It should not
    change the vectors that are being added.
7. A method multiply that returns the result of multiplying this vector by a constant. It should
    not change the vector that is being multiplied.
8. A method dotProduct that returns the dot product of this vector and another vector. It should
    not change the two vectors.
9. A method angleBetween that returns the angle between two vectors in degrees. It should not
    change the two vectors. It should throw an IllegalStateException if this operation cannot
    be completed.
For each method:
Design the signature of the method.
Write Javadoc-style comments for that method.
Write the body for the method.
Write one or more tests that check that the method works _as specified_ in all cases.
You may find the Math class useful for this assignment. Look at the documentation for the Math
class and try to understand how to use it.

# How to submit

1. Create a zip file that contains directly your _src_ and _test_ folders. When you unzip the file, you
    should see only these two folders.
2. Log on to the Bottlenose submission server.
3. Navigate to _Assignment 1_ and submit the zip file.
4. Wait for a few minutes for feedback to appear, and take action if needed.





