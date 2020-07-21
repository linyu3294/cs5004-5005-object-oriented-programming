# Assignment 4: Using Lists

# Polynomials

# 1 Introduction

```
A polynomial is made of several terms, each term having a coefficient and a variable raised to a
power. Polynomials are one-variable if all their terms contain only one variable. An example of
such a polynomial is. This polynomial has four terms.
```
```
The degree of a polynomial is defined as the highest power of the variable in a term. In the
above example, the degree of the polynomial is 4. The polynomials we deal with have only
positive, integral powers. The coefficients of our polynomials are also integral numbers.
```
```
Two polynomials are the same if they contain the same terms.
```
```
Several algebraic operations are possible with polynomials. The simplest one is evaluating the
polynomial for a specific value of the variable. For example, for a polynomial
, its value at is defined as
which is.
```
```
Polynomials can be added together to create a new polynomial. The addition is performed by
combining all the terms and adding the coefficients of the terms with the same power. For
example + =. The degree of the sum is
the maximum of the degrees of the two polynomials.
```
# 2 What to do

```
Design an interface Polynomial that defines the above operations. This is your polynomial
abstract data type. Specifically this interface should have the following method signatures:
```
```
A method addTerm that takes a coefficient and a power (both integral numbers) and adds the
resulting term to the polynomial. (This will enable you to build a polynomial term-by-term.)
It should throw an IllegalArgumentException if a negative power is passed to it.
```
```
A method removeTerm that takes a power and removes any and all terms in the polynomial
with that power.
```
```
A method getDegree that returns the degree of this polynomial.
```
```
A method getCoefficient that takes a power and returns the coefficient for the term with
that power.
```
```
A method evaluate that takes a double-precision decimal number and returns a double-
precision result.
```
```
A method add that takes another Polynomial object and returns the polynomial obtained by
adding the two polynomials. Any implementation should ensure that this method does not
mutate either polynomial. The implementation may assume that the given Polynomial is the
of the same concrete class as this object; if it is a different class, the method may throw an
IllegalArgumentException.
```
```
Now implement this interface in a class PolynomialImpl. Beyond implementing the
Polynomial interface, this implementation should have the following features/obey these
constraints:
```
```
This class should store the polynomial using the a linked list with nodes. This representation
must be implemented by you (i.e. you are not allowed to use existing list classes in Java).
```
```
This class should store only terms with non-zero coefficients.
```
```
This class should store the polynomial terms in decreasing order of their powers.
```
```
This class should have a constructor with no parameters that creates a polynomial with no
terms, i.e. the polynomial 0 (how to represent this?).
```
```
This class should have another constructor that takes a polynomial as a string, parses it and
creates the polynomial accordingly. The string contains the polynomial, with each term
separated by a space. The following examples should work with your constructor:
```
```
"4x^3 +3x^1 -5"
```
```
"-3x^4 -2x^5 -5 +11x^1"
```
```
Hint: Break the string into substrings and process. You may find the Scanner and String
classes helpful to do this. Furthermore one can convert "23" into the integer 23 by using
Integer.parseInt("23").
```
```
While you are free to write helper methods, you are not allowed to write any other public
methods other than those in the interface and the above two constructors.
```
```
This class should include a toString method that returns a string that contains the
polynomial. The following examples should help you infer the required format:
```
```
creates the string “5x^2 +4x^1 -2”
```
```
creates the string “-50x^3 +1x^2 +3”
```
```
creates the string “2x^5 -3x^2 +4x^1 -10”
```
```
Write tests that thoroughly test this implementation. As always, it is recommended to write the
test before completing the PolynomialImpl implementation.
```
# 3 Hints: How to tackle the assignment

```
Start by creating empty interfaces and classes for polynomials and nodes. Now select a method
from the ADT and implement it end-to-end. Write tests for it before writing the implementation,
and when your implementation passes your tests, move on to the next method. Tackle the
parsing constructor at the end: you should not need it to test other methods.
```
```
For the add method: think about how you can “accumulate” the result. This is just a hint: you
do not need to implement it this way.
```
# 4 Criteria for grading

```
You will be graded on:
```
1. The design of your interface.
2. Whether your implementation obeys all the above constraints.
3. The correctness of your methods.
4. How well you have tested your methods.
5. Whether you have written enough comments for your classes and methods, and whether they
    are in proper Javadoc style.
6. Whether you have used access modifiers correctly: public, protected or private.
7. Whether your code is formatted correctly (according to the style grader).

# 5 What to submit

```
Submit a single zip file that has two folders: src and test. The src folder should contain all your
.java files and the test should contain all your JUnit test files. Please submit your zip file by
the above deadline, and then complete the self-evaluation until the day after the deadline.
```

