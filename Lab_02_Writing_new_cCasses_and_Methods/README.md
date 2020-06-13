  # Lab 2: Writing new classes and methods

  ```
  Due Thursday May 23rd at midnight.
  ```
  # 1 Automatic Transmission vehicles

  # 1.1 Introduction

  ```
  Cars with a manual transmission require the driver to change gears as he/she is
  changing speed. Putting it simply, this changes how much of the rotation of the engine
  affects the rotation of the axles (low gears transfer rotation slowly, so that even if the
  engine is revved up the car does not speed up much). This is the same as how gears on a
  bicycle work.
  Cars with automatic transmission solve this problem by letting the car computer choose
  how much rotation to transfer at certain speeds. This behavior may be simulated in a
  computer program.
  ```
  # 1.2 What to do

  ```
  Write a class TransmissionBox that represents a single car transmission. It represents the
  current speed of the car, and the current gear (automatically determined from speed):
  A constructor that takes the current speed, and 4 speed thresholds for the 5 gears in
  order (speed to go from 1 to 2 or back, speed to go from 2 to 3 or back, etc.)
  A method which, when called, returns a TransmissionBox object with speed increased
  by 2 and the appropriate gear.
  A method which, when called, returns a TransmissionBox object with speed
  decreased by 2 and the appropriate gear.
  Methods that get the speed and the current gear.
  A toString method that can be used to get the current state of the transmission
  (speed and gear) as a suitably formatted string.
  For each method:
  Design the signature of the method.
  Write Javadoc-style comments for that method.
  Write the body for the method.
  Write one or more tests that check that the method works as specified in all cases.
  Write tests for this class: think about each test objective, and then how you will test it.
  Remember: one test, one objective. However it may take several assert statement to test
  one objective: this is perfectly OK.
  ```
  # 2 Fibonacci Counter

  # 2.1 Introduction

  ```
  A Fibonacci series is a popular sequence of numbers. The first two numbers of this series
  are 0 and 1. After this, the next Fibonacci number is obtained by adding the previous
  two. Thus the Fibonacci sequence is.
  A Fibonacci counter is a machine that counts Fibonacci numbers. Much like a step
  tracker, it can be started at any count. It can be incremented or decremented by 1 (count
  falling below 0 is invalid). Given a number ’n’, the nth Fibonacci number can be
  calculated directly using Binet’s formula:
  ```
  # 2.2 What to do

  ```
  Write a class FibonacciCounter that represents a single Fibonacci counter. This class
  should contain the following:
  ```
  1. A constructor that takes the initial count value and initializes the object appropriately.
  2. A method that returns a FibonacciCounter object with its count incremented by 1.
  3. A method that returns a FibonacciCounter object with its count decremented by 1. If
      it cannot be decremented, it returns the object with the same count.
  4. A method that returns the current count of the counter.
  5. A method that returns the Fibonacci number corresponding to the current count.
      For each method:
         Design the signature of the method.
         Write Javadoc-style comments for that method.
         Write the body for the method.
         Write one or more tests that check that the method works as specified in all cases.
      You may find the Math class useful for this lab. Look at the documentation for the Math
      class and try to understand how to use it.
      Write tests for this class: think about each test objective, and then how you will test it.
      Remember: one test, one objective. However it may take several assert statement to test
      one objective: this is perfectly OK.

  ```

