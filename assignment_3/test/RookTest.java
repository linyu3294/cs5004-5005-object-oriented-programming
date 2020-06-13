import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for Rook Class.
 */
public class RookTest {
  private ChessPiece rook1;
  private ChessPiece rook2;
  private ChessPiece rook3;

  @Before
  public void setUp() throws Exception {
    rook1 = new Rook(0, 3, Color.WHITE);
    rook2 = new Rook(4, 7, Color.BLACK);
    rook3 = new Rook(7, 5, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    ChessPiece rook1 = new Rook(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece rook1 = new Rook(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece rook1 = new Rook(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece rook1 = new Rook(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece rook1 = new Rook(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, rook1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(4, rook2.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(7, rook3.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, rook1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(7, rook2.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(5, rook3.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, rook1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.BLACK, rook2.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.BLACK, rook3.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, rook1.canMove(0, 0));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, rook1.canMove(0, 7));
  }

  @Test
  public void canMoveTest3() {
    assertEquals(true, rook1.canMove(7, 3));
  }

  @Test
  public void canMoveTest4() {
    assertEquals(true, rook3.canMove(7, 5));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, rook1.canMove(-1, 0));
  }

  @Test
  public void canNotMoveTest2() {
    assertEquals(false, rook2.canMove(3, 6));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Rook(0, 0, Color.BLACK);
    assertEquals(true, rook1.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Rook(7, 3, Color.WHITE);
    assertEquals(true, rook3.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Rook(0, 0, Color.WHITE);
    assertEquals(false, rook1.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Rook(1, 1, Color.BLACK);
    assertEquals(false, rook1.canKill(other));
  }
}