/**
 * This is a class that represents a FibonacciCounter.
 */
public class FibonacciCounter {
  private int currCount;
  private double fibNumber;

  /**
   * Constructs a FibonacciCounter Object. if user enters a current Count < than 0, throws an
   * IllegalArgumentException .
   *
   * @param currCount - initial count value and initializes the FibonacciCounter state.
   * @throws IllegalArgumentException -if user enters a current Count overflows Max Integer
   */
  FibonacciCounter(int currCount) throws IllegalArgumentException {

    if (currCount < 0) {
      throw new IllegalArgumentException(
              "You cannot have a count less than 0"
      );
    } else {
      this.currCount = currCount;
    }
    this.fibNumber = (1 / Math.sqrt(5))
            * (Math.pow(((1 + Math.sqrt(5)) / 2), currCount)
            - Math.pow(((1 - Math.sqrt(5)) / 2), currCount));
    if (this.fibNumber > Integer.MAX_VALUE) {
      throw new IllegalArgumentException(
              "You fibNumber is larger than what an Integer can store."
      );
    }
  }

  /**
   * returns a FibonacciCounter object with its count incremented by 1.
   *
   * @return a FibonacciCounter object.
   */
  public FibonacciCounter countUp() {
    return new FibonacciCounter(this.currCount + 1);
  }

  /**
   * returns a FibonacciCounter object with its count decremented by 1.
   *
   * @return a FibonacciCounter object.
   */
  public FibonacciCounter countDown() throws IllegalStateException {
    if (this.currCount == 0) {
      throw new IllegalStateException();
    }
    return new FibonacciCounter(this.currCount - 1);
  }

  /**
   * Returns the current count of a FibonacciCounter object.
   *
   * @return a int that represents the current count.
   */
  public int getCurrentCount() {
    return this.currCount;
  }

  /**
   * Returns the current Fibonacci number of a FibonacciCounter object.
   *
   * @return a int that represents the current Fibonacci number.
   */
  public int getFibNumber() {
    return (int) this.fibNumber;
  }


}
