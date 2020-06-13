import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUNit test class for the TransmissionBox class.
 */
public class TransmissionBoxTest {
  private TransmissionBox testBox;
  private TransmissionBox testBox2;

  /**
   * Setting up valid constructors.
   */
  @Before
  public void setUp() {
    testBox = new TransmissionBox(1, 2, 3, 4, 5);
    testBox2 = new TransmissionBox(5, 2, 3, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest1() {
    TransmissionBox box = new TransmissionBox(-2, 1, 3, 5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    TransmissionBox box = new TransmissionBox(0, -5, 3, 5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    TransmissionBox box = new TransmissionBox(0, 1, 0, 5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    TransmissionBox box = new TransmissionBox(0, 1, 3, 9, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    TransmissionBox box = new TransmissionBox(0, 1, 3, 7, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest6() {
    TransmissionBox box = new TransmissionBox(127, 1, 3, 7, 5);
  }

  @Test
  public void getSpeedTest() {
    assertEquals(1, testBox.getSpeed(), 0.01);
  }

  @Test
  public void getGearTest() {
    assertEquals(1, testBox.getGear(), 0.01);
  }

  @Test
  public void toStringTest() {
    assertEquals(
            "Current Speed is 1.0" + "\n" + "Current Gear is 1.0",
            "Current Speed is "
                    + testBox.getSpeed()
                    + "\n" + "Current Gear is "
                    + testBox.getGear());
  }

  @Test
  public void speedUpTest() {
    TransmissionBox newTestBox = testBox.speedUp();
    assertEquals(
            "Current Speed is 3.0" + "\n" + "Current Gear is 3.0",
            "Current Speed is "
                    + newTestBox.getSpeed()
                    + "\n" + "Current Gear is "
                    + newTestBox.getGear());

  }

  @Test
  public void slowDownTest() {
    TransmissionBox newTestBox = testBox2.slowDown();
    assertEquals(
            "Current Speed is 3.0" + "\n" + "Current Gear is 3.0",
            "Current Speed is "
                    + newTestBox.getSpeed()
                    + "\n" + "Current Gear is "
                    + newTestBox.getGear());
  }
}
