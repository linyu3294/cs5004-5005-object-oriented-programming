import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUNit test class for the TransmissionBox class.
 */
public class FibonacciCounterTest {
  private FibonacciCounter counter1;
  private FibonacciCounter counter2;

  /**
   * Setting up valid constructors.
   */
  @Before
  public void setUp() throws Exception {
    counter1 = new FibonacciCounter(0);
    counter2 = new FibonacciCounter(26);
  }


  @Test
  public void getFibNumberTest1() {
    assertEquals(121393, counter2.getFibNumber());
  }

  @Test
  public void getFibNumberTest2() {
    assertEquals(0, counter1.getFibNumber());
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidCounterTest1() {
    FibonacciCounter invalidCounter = new FibonacciCounter(-7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void fibOverFlowTest1() {
    FibonacciCounter invalidCounter = new FibonacciCounter(300000000);
  }

  @Test
  public void countUpTest1() {
    FibonacciCounter expectedCounter = new FibonacciCounter(1);
    assertEquals(expectedCounter.getFibNumber(), counter1.countUp().getFibNumber());
  }

  @Test
  public void countUpTest2() {
    FibonacciCounter expectedCounter = new FibonacciCounter(27);
    assertEquals(expectedCounter.getFibNumber(), counter2.countUp().getFibNumber());
  }

  @Test (expected = IllegalStateException.class)
  public void invalidCountDown() {
    FibonacciCounter expectedCounter = new FibonacciCounter(0);
    expectedCounter.countDown();
  }

  @Test
  public void validCountDownTest() {
    assertEquals(25, counter2.countDown().getCurrentCount());
  }


  @Test
  public void getCurrentCountTest1() {
    assertEquals(0, counter1.getCurrentCount());
  }

  @Test
  public void getCurrentCountTest2() {
    assertEquals(26, counter2.getCurrentCount());
  }







}
