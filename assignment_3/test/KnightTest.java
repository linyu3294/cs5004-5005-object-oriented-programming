import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for Knight Class.
 */
public class KnightTest {
  private ChessPiece knight1;
  private ChessPiece knight2;
  private ChessPiece knight3;
  private ChessPiece knight4;

  @Before
  public void setUp() throws Exception {
    knight1 = new Knight(0, 3, Color.WHITE);
    knight2 = new Knight(4, 7, Color.BLACK);
    knight3 = new Knight(7, 5, Color.BLACK);
    knight4 = new Knight(0, 0, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    ChessPiece knight1 = new Knight(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece knight1 = new Knight(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece knight1 = new Knight(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece knight1 = new Knight(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece knight1 = new Knight(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, knight1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(4, knight2.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(7, knight3.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, knight1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(7, knight2.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(5, knight3.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, knight1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.BLACK, knight2.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.BLACK, knight3.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, knight1.canMove(1, 5));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, knight1.canMove(1, 1));
  }

  @Test
  public void canMoveTest3() {
    assertEquals(true, knight2.canMove(5, 5));
  }

  @Test
  public void canMoveTest4() {
    assertEquals(true, knight2.canMove(3, 5));
  }

  @Test
  public void canMoveTest5() {
    assertEquals(true, knight2.canMove(2, 6));
  }

  @Test
  public void canMoveTest6() {
    assertEquals(true, knight3.canMove(7, 5));
  }

  @Test
  public void canMoveTest7() {
    assertEquals(false, knight4.canMove(0, 1));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, knight3.canMove(6, 4));
  }

  @Test
  public void canNotMoveTest2() {
    assertEquals(false, knight3.canMove(8, 3));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Knight(1, 5, Color.BLACK);
    assertEquals(true, knight1.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Knight(1, 1, Color.BLACK);
    assertEquals(true, knight1.canKill(other));
  }

  @Test
  public void canKillTest3() {
    ChessPiece other = new Knight(3, 5, Color.WHITE);
    assertEquals(true, knight2.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Knight(1, 5, Color.WHITE);
    assertEquals(false, knight1.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Knight(6, 4, Color.WHITE);
    assertEquals(false, knight3.canKill(other));
  }
}