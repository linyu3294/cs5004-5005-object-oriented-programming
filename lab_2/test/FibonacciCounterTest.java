import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUNit test class for the TransmissionBox class.
 */
public class FibonacciCounterTest {
  private FibonacciCounter counter1;
  private FibonacciCounter counter2;
  private FibonacciCounter counter3;

  /**
   * Setting up valid constructors.
   */
  @Before
  public void setUp() throws Exception {
    counter1 = new FibonacciCounter(-7);
    counter2 = new FibonacciCounter(0);
    counter3 = new FibonacciCounter(26);
  }


  @Test
  public void getFibNumberTest1() {
    assertEquals(121393, counter3.getFibNumber());
  }

  @Test
  public void getFibNumberTest2() {
    assertEquals(0, counter1.getFibNumber());
  }


  @Test
  public void countUpTest1() {
    FibonacciCounter expectedCounter = new FibonacciCounter(1);
    assertEquals(expectedCounter.getFibNumber(), counter1.countUp().getFibNumber());
  }

  @Test
  public void countUpTest2() {
    FibonacciCounter expectedCounter = new FibonacciCounter(27);
    assertEquals(expectedCounter.getFibNumber(), counter3.countUp().getFibNumber());
  }

  @Test
  public void countDownTest1() {
    FibonacciCounter expectedCounter = new FibonacciCounter(0);
    assertEquals(expectedCounter.getFibNumber(), counter1.countDown().getFibNumber());
  }

  @Test
  public void countDownTest2() {
    FibonacciCounter expectedCounter = new FibonacciCounter(0);
    assertEquals(expectedCounter.getFibNumber(), counter2.countDown().getFibNumber());
  }

  @Test
  public void getCurrentCountTest1() {
    assertEquals(26, counter3.getCurrentCount());
  }

  @Test
  public void getCurrentCountTest2() {
    FibonacciCounter newCounter = counter3.countUp();
    assertEquals(27, newCounter.getCurrentCount());
  }


}
