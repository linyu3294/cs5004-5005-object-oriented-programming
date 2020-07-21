import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for Rectangle class.
 */
public class RectangleTest {
  Rectangle rect1;
  Rectangle rect2;
  Rectangle rect3;
  Rectangle rect4;
  Rectangle rect5;
  Rectangle rect6;
  Rectangle rect7;

  @Before
  public void setUp() {
    rect1 = new Rectangle(0, 0, 5, 5);
    rect2 = new Rectangle(3, 3, 5, 5);
    rect3 = new Rectangle(-3, 3, 5, 5);
    rect4 = new Rectangle(6, 6, 5, 5);
    rect5 = new Rectangle(-4.5, -3.5, 4, 3);
    rect6 = new Rectangle(-7, -8, 20, 34);
    rect7 = new Rectangle(5, 5, 1, 3);
  }


  @Test()
  public void validConstructorTest1() {
    Rectangle validRect = new Rectangle(5, 5, 0, 0);
    assertEquals(true, validRect.equals(new Rectangle(5, 5, 0, 0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest1() {
    Rectangle invalidRect = new Rectangle(5, 5, -6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    Rectangle invalidRect = new Rectangle(5, 5, -6, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    Rectangle invalidRect = new Rectangle(5, 5, 0, -4);
  }

  @Test
  public void toStringTest1() {
    assertEquals("x:0, y:0, w:5, h:5", rect1.toString());
  }

  @Test
  public void toStringTest2() {
    assertEquals("x:-4.5, y:-3.5, w:4, h:3", rect5.toString());
  }

  @Test
  public void equalsTest1() {
    Rectangle other = new Rectangle(-3, 3, 5, 5);
    assertEquals(true, rect3.equals(other));
  }

  @Test
  public void equalsTest2() {
    Rectangle other = new Rectangle(-3, 3, 5, 5);
    assertEquals(true, other.equals(rect3));
  }

  @Test
  public void equalsTest3() {
    Rectangle other = new Rectangle(-4.5, -3.5, 4, 3);
    assertEquals(true, rect5.equals(other));
  }

  @Test
  public void equalsTest4() {
    Rectangle other = new Rectangle(-4.5, -3.5, 4, 3);
    assertEquals(true, other.equals(rect5));
  }

  @Test
  public void equalsTest5() {
    assertEquals(false, rect1.equals(rect5));
  }

  @Test
  public void overlapTest1() {
    assertEquals(true, rect1.overlap(rect2));
  }

  @Test
  public void overlapTest2() {
    assertEquals(true, rect2.overlap(rect1));
  }

  @Test
  public void overlapTest3() {
    assertEquals(true, rect1.overlap(rect3));
  }

  @Test
  public void overlapTest4() {
    assertEquals(true, rect3.overlap(rect1));
  }

  @Test
  public void overlapTest5() {
    assertEquals(true, rect6.overlap(rect1));
  }

  @Test
  public void overlapTest6() {
    assertEquals(true, rect1.overlap(rect6));
  }

  @Test
  public void overlapTest7() {
    Rectangle newRect1 = new Rectangle(0,0,20,10);
    Rectangle newRect2 = new Rectangle(-22,-22,23,23);
    assertEquals(true, newRect1.overlap(newRect2));
  }

  @Test
  public void noOverlapTest1() {
    assertEquals(false, rect1.overlap(rect4));
  }

  @Test
  public void noOverlapTest2() {
    assertEquals(false, rect4.overlap(rect1));
  }

  @Test
  public void noOverlapTest3() {
    assertEquals(false, rect1.overlap(rect5));
  }

  @Test
  public void noOverlapTest4() {
    assertEquals(false, rect5.overlap(rect1));
  }

  @Test
  public void noOverlapTest5() {
    assertEquals(false, rect1.overlap(rect7));
  }

  @Test
  public void noOverlapTest6() {
    assertEquals(false, rect7.overlap(rect1));
  }

  @Test
  public void noOverlapTest7() {
    Rectangle newRect1 = new Rectangle(0, 0, 20, 10);
    Rectangle newRect2 = new Rectangle(-22, -50, 23, 5);
    assertEquals(false, newRect1.overlap(newRect2));
  }

  @Test
  public void noOverlapTest8() {
    Rectangle newRect1 = new Rectangle(0, 0, 20, 10);
    Rectangle newRect2 = new Rectangle(-22, -50, 23, 5);
    assertEquals(false, newRect1.overlap(newRect2));
  }

  @Test
  public void intersectTest1() {
    Rectangle other = new Rectangle(3, 3, 2, 2);
    assertEquals(true, (rect1.intersect(rect2)).equals(other));
  }

  @Test
  public void intersectTest2() {
    Rectangle other = new Rectangle(3, 3, 2, 2);
    assertEquals(true, (rect2.intersect(rect1)).equals(other));
  }

  @Test
  public void intersectTest3() {
    Rectangle other = new Rectangle(0, 3, 2, 2);
    assertEquals(true, (rect1.intersect(rect3)).equals(other));
  }

  @Test
  public void intersectTest4() {
    Rectangle other = new Rectangle(0, 3, 2, 2);
    assertEquals(true, (rect3.intersect(rect1)).equals(other));
  }

  @Test
  public void intersectTest5() {
    Rectangle other = new Rectangle(-3, 3, 5, 5);
    assertEquals(true, (rect3.intersect(rect6)).equals(other));
  }

  @Test
  public void intersectTest6() {
    Rectangle other = new Rectangle(0, 0, 5, 5);
    assertEquals(true, (rect1.intersect(rect6)).equals(other));
  }

  @Test
  public void intersectTest7() {
    Rectangle other = new Rectangle(0, 0, 5, 5);
    assertEquals(true, (rect6.intersect(rect1)).equals(other));
  }

  @Test(expected = NoSuchElementException.class)
  public void noIntersectTest1() {
    Rectangle newRect = rect4.intersect(rect1);
  }

  @Test(expected = NoSuchElementException.class)
  public void noIntersectTest2() {
    Rectangle newRect = rect1.intersect(rect4);
  }

  @Test(expected = NoSuchElementException.class)
  public void noIntersectTest3() {
    Rectangle newRect = rect1.intersect(rect7);
  }

  @Test(expected = NoSuchElementException.class)
  public void noIntersectTest4() {
    Rectangle newRect = rect7.intersect(rect1);
  }

  @Test
  public void unionTest1() {
    Rectangle other = new Rectangle(0, 0, 8, 8);
    assertEquals(true, (rect1.union(rect2)).equals(other));
  }

  @Test
  public void unionTest2() {
    Rectangle other = new Rectangle(0, 0, 8, 8);
    assertEquals(true, (rect2.union(rect1)).equals(other));
  }

  @Test
  public void unionTest3() {
    Rectangle other = new Rectangle(-3, 0, 8, 8);

    assertEquals(true, (rect1.union(rect3)).equals(other));
  }

  @Test
  public void unionTest4() {
    Rectangle other = new Rectangle(-3, 0, 8, 8);
    assertEquals(true, (rect3.union(rect1)).equals(other));
  }

  @Test
  public void unionTest5() {
    Rectangle other = new Rectangle(-7, -8, 20, 34);
    assertEquals(true, (rect3.union(rect6)).equals(other));
  }

  @Test
  public void unionTest6() {
    Rectangle other = new Rectangle(-7, -8, 20, 34);
    assertEquals(true, (rect1.union(rect6)).equals(other));
  }

  @Test
  public void unionTest7() {
    Rectangle other = new Rectangle(-7, -8, 20, 34);
    assertEquals(true, (rect6.union(rect1)).equals(other));
  }

}