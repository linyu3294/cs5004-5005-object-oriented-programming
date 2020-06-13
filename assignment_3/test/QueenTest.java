import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for Queen Class.
 */
public class QueenTest {
  private ChessPiece queen1;
  private ChessPiece queen2;
  private ChessPiece queen3;

  @Before
  public void setUp() throws Exception {
    queen1 = new Queen(0, 3, Color.WHITE);
    queen2 = new Queen(4, 7, Color.BLACK);
    queen3 = new Queen(7, 5, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    ChessPiece queen1 = new Queen(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece queen1 = new Queen(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece queen1 = new Queen(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece queen1 = new Queen(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece queen1 = new Queen(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, queen1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(4, queen2.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(7, queen3.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, queen1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(7, queen2.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(5, queen3.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, queen1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.BLACK, queen2.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.BLACK, queen3.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, queen1.canMove(0, 0));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, queen1.canMove(0, 7));
  }

  @Test
  public void canMoveTest3() {
    assertEquals(true, queen1.canMove(7, 3));
  }

  @Test
  public void canMoveTest4() {
    assertEquals(true, queen1.canMove(4, 7));
  }

  @Test
  public void canMoveTest5() {
    assertEquals(true, queen1.canMove(3, 0));
  }

  @Test
  public void canMoveTest6() {
    assertEquals(true, queen2.canMove(0, 3));
  }

  @Test
  public void canMoveTest7() {
    assertEquals(true, queen2.canMove(7, 4));
  }

  @Test
  public void canMoveTest8() {
    assertEquals(true, queen3.canMove(7, 5));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, queen1.canMove(-1, 0));
  }

  @Test
  public void canNotMoveTest2() {
    assertEquals(false, queen1.canMove(2, 2));
  }


  @Test
  public void canNotMoveTest4() {
    assertEquals(false, queen3.canMove(8, 4));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Rook(0, 0, Color.BLACK);
    assertEquals(true, queen1.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Rook(7, 3, Color.WHITE);
    assertEquals(true, queen3.canKill(other));
  }

  @Test
  public void canKillTest3() {
    ChessPiece other = new Bishop(4, 7, Color.BLACK);
    assertEquals(true, queen1.canKill(other));
  }

  @Test
  public void canKillTest4() {
    ChessPiece other = new Bishop(3, 6, Color.WHITE);
    assertEquals(true, queen2.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Rook(0, 0, Color.WHITE);
    assertEquals(false, queen1.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Rook(1, 1, Color.BLACK);
    assertEquals(false, queen1.canKill(other));
  }

  @Test
  public void canNotKillTest3() {
    ChessPiece other = new Bishop(4, 7, Color.WHITE);
    assertEquals(false, queen1.canKill(other));
  }

}