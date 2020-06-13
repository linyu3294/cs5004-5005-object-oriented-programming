import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for Bishop Class.
 */
public class BishopTest {
  private ChessPiece bishop1;
  private ChessPiece bishop2;
  private ChessPiece bishop3;

  @Before
  public void setUp() throws Exception {
    bishop1 = new Bishop(0, 3, Color.WHITE);
    bishop2 = new Bishop(4, 7, Color.BLACK);
    bishop3 = new Bishop(7, 5, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    ChessPiece bishop1 = new Bishop(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece bishop1 = new Bishop(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece bishop1 = new Bishop(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece bishop1 = new Bishop(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece bishop1 = new Bishop(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, bishop1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(4, bishop2.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(7, bishop3.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, bishop1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(7, bishop2.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(5, bishop3.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, bishop1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.BLACK, bishop2.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.BLACK, bishop3.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, bishop1.canMove(4, 7));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, bishop1.canMove(3, 0));
  }

  @Test
  public void canMoveTest3() {
    assertEquals(true, bishop2.canMove(0, 3));
  }

  @Test
  public void canMoveTest4() {
    assertEquals(true, bishop2.canMove(7, 4));
  }

  @Test
  public void canMoveTest5() {
    assertEquals(true, bishop3.canMove(7, 5));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, bishop1.canMove(2, 2));
  }

  @Test
  public void canNotMoveTest2() {
    assertEquals(false, bishop2.canMove(5, 7));
  }

  @Test
  public void canNotMoveTest3() {
    assertEquals(false, bishop3.canMove(8, 4));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Bishop(4, 7, Color.BLACK);
    assertEquals(true, bishop1.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Bishop(3, 6, Color.WHITE);
    assertEquals(true, bishop2.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Bishop(4, 7, Color.WHITE);
    assertEquals(false, bishop1.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Bishop(3, 7, Color.WHITE);
    assertEquals(false, bishop2.canKill(other));
  }
}