import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Vector3D class.
 */
public class Vector3DTest {
  /**
   * Declaring 3 Vector3D objects used throughout this test class.
   */
  private Vector3D vector1;
  private Vector3D vector2;
  private Vector3D vector3;


  /**
   * Initiating three Vector3D objects used throughout this test class.
   */
  @Before
  public void setUp() {
    vector1 = new Vector3D(0, 0, 0);
    vector2 = new Vector3D(4f, 5f, 7f);
    vector3 = new Vector3D(-3.489, 78.475, -0.1524);
  }

  @org.junit.Test
  public void getXTest1() {
    assertEquals(0f, vector1.getX(), 0.01);
  }

  @org.junit.Test
  public void getXTest2() {
    assertEquals(4f, vector2.getX(), 0.01);
  }

  @org.junit.Test
  public void getXTest3() {
    assertEquals(-3.48f, vector3.getX(), 0.01);
  }

  @org.junit.Test
  public void getYTest1() {
    assertEquals(0f, vector1.getY(), 0.01);
  }

  @org.junit.Test
  public void getYTest2() {
    assertEquals(5f, vector2.getY(), 0.01);
  }

  @org.junit.Test
  public void getYTest3() {
    assertEquals(78.47f, vector3.getY(), 0.01);
  }

  @org.junit.Test
  public void getZTest1() {
    assertEquals(0f, vector1.getZ(), 0.01);
  }

  @org.junit.Test
  public void getZTest2() {
    assertEquals(7f, vector2.getZ(), 0.01);
  }

  @org.junit.Test
  public void getZTest3() {
    assertEquals(-0.1574f, vector3.getZ(), 0.01);
  }

  @org.junit.Test
  public void toStringTest1() {
    assertEquals("(0.00,0.00,0.00)", vector1.toString());
  }

  @org.junit.Test
  public void toStringTest2() {
    assertEquals("(4.00,5.00,7.00)", vector2.toString());
  }

  @org.junit.Test
  public void toStringTest3() {
    assertEquals("(-3.49,78.48,-0.15)", vector3.toString());
  }

  @org.junit.Test
  public void getMagnitudeTest1() {
    assertEquals(0, vector1.getMagnitude(), 0.01);
  }

  @org.junit.Test
  public void getMagnitudeTest2() {
    assertEquals(9.4869, vector2.getMagnitude(), 0.01);
  }

  @org.junit.Test
  public void getMagnitudeTest3() {
    assertEquals(78.553, vector3.getMagnitude(), 0.01);
  }

  @org.junit.Test(expected = IllegalStateException.class)
  public void normalizeTest1() {
    System.out.print(vector1.normalize());
  }

  @org.junit.Test
  public void normalizeTest2() {
    assertEquals("(0.42,0.53,0.74)", vector2.normalize().toString());
  }

  @org.junit.Test
  public void normalizeTest3() {
    assertEquals("(-0.04,1.00,-0.00)", vector3.normalize().toString());
  }

  @org.junit.Test
  public void addTest1() {
    assertEquals("(4.00,5.00,7.00)", vector1.add(vector2).toString());
  }

  @org.junit.Test
  public void addTest2() {
    assertEquals("(0.51,83.48,6.85)", vector2.add(vector3).toString());
  }

  @org.junit.Test
  public void multiplyTest1() {
    assertEquals("(0.00,0.00,0.00)", vector1.multiply(0.6).toString());
  }

  @org.junit.Test
  public void multiplyTest2() {
    assertEquals("(160.00,200.00,280.00)", vector2.multiply(40f).toString());
  }

  @org.junit.Test
  public void dotProductTest1() {
    assertEquals(0, vector1.dotProduct(vector2), 0.01);
  }

  @org.junit.Test
  public void dotProductTest2() {
    assertEquals(377.35, vector2.dotProduct(vector3), 0.01);
  }

  @org.junit.Test(expected = IllegalStateException.class)
  public void angleBetweenTest1() {
    vector1.angleBetween(vector2);
  }

  @org.junit.Test
  public void angleBetweenTest2() {
    assertEquals(59.58, vector2.angleBetween(vector3), 0.01);
  }

}


