# Lab 3: Refactoring and error handling

```
Due Thursday May 30th at midnight
Goals: The goals of this lab are to practice with a program written before, and to add
error handling capabilities.
```
# 1 Automatic Transmission vehicles: revisted

# 1.1 What to do

```
You have written a TransmissionBox class that represents an automatic transmission. In
this part, you must make the implementation more robust by:
Throwing an IllegalArgumentException or IllegalStateException as appropriate.
Declaring any exceptions in the signature of the method.
Documenting when a method may throw exceptions.
Testing that your implementation throws correct exceptions only in the appropriate
situations.
Your new implementation must obey the following constraints:
```
1. The speed should be a non-negative number. The speed should not be allowed to go
    beyond 120 mph.
2. Speed thresholds should be monotonically increasing (i.e. the threshold between
    gears 2 and 3 should not be greater than that between gears 3 and 4, and so on.

# 2 Fibonacci counter: revisted

# 2.1 What to do

```
You have written a FibonacciCounter class that represents a counter for the Fibonacci
sequence. In this part, you must make the implementation more robust by:
Throwing an IllegalArgumentException or IllegalStateException as appropriate.
Declaring any exceptions in the signature of the method.
Documenting when a method may throw exceptions.
Testing that your implementation throws correct exceptions only in the appropriate
situations.
Your new implementation must obey the following constraints:
```
1. The count is defined only for values that are non-negative. Any attempt to go outside
    this range is invalid.
2. The fibonacci number returned by the object should always be big enough to hold in a
    single integer (int). This is called an overflow. In Java, a value overflows when it
    exceeds Integer.MAX_VALUE, the maximum value of an integer in Java. In order to
    detect this, we can use a long as an intermediate value since the long can hold values
    larger than the int. We can store our calculation in a long and then check to see if it
    exceeds Integer.MAX_VALUE. (Hint: think about how you can also do this while using
    only int)

```

