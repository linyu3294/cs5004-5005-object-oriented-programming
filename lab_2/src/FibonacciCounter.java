/**
 * This is a class that represents a FibonacciCounter.
 */
public class FibonacciCounter {
  private int currCount;
  private double fibNumber;

  /**
   * Constructs a FibonacciCounter Object.
   * @param currCount - initial count value and initializes the FibonacciCounter state.
   */
  FibonacciCounter(int currCount) {
    if (currCount < 0) {
      currCount = 0;
    } else {
      this.currCount = currCount;
    }
    this.fibNumber = (1 / Math.sqrt(5))
            * (Math.pow(((1 + Math.sqrt(5)) / 2), currCount)
              - Math.pow(((1 - Math.sqrt(5)) / 2), currCount));
  }

  /**
   * returns a FibonacciCounter object with its count incremented by 1.
   * @return a FibonacciCounter object.
   */
  public FibonacciCounter countUp() {
    return new FibonacciCounter(this.currCount + 1);
  }

  /**
   * returns a FibonacciCounter object with its count decremented by 1.
   * @return a FibonacciCounter object.
   */
  public FibonacciCounter countDown() {
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
