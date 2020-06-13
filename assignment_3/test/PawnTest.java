import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class used for Pawn Class.
 */
public class PawnTest {
  private ChessPiece pawn1;
  private ChessPiece pawn2;
  private ChessPiece pawn3;
  private ChessPiece pawn4;
  private ChessPiece pawn5;

  @Before
  public void setUp() throws Exception {
    pawn1 = new Pawn(0, 3, Color.WHITE);
    pawn2 = new Pawn(4, 6, Color.BLACK);
    pawn3 = new Pawn(7, 5, Color.BLACK);
    pawn4 = new Pawn(0, 0, Color.WHITE);
    pawn5 = new Pawn(0, 0, Color.BLACK);

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    ChessPiece pawn1 = new Pawn(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece pawn1 = new Pawn(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece pawn1 = new Pawn(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece pawn1 = new Pawn(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece pawn1 = new Pawn(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, pawn1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(4, pawn2.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(7, pawn3.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, pawn1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(6, pawn2.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(5, pawn3.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, pawn1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.BLACK, pawn2.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.BLACK, pawn3.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, pawn2.canMove(5, 6));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, pawn3.canMove(7, 5));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, pawn2.canMove(3, 6));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Pawn(5, 5, Color.WHITE);
    assertEquals(true, pawn2.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Pawn(5, 7, Color.WHITE);
    assertEquals(true, pawn2.canKill(other));
  }


  @Test
  public void canKillTest3() {
    ChessPiece other = new Pawn(5, 5, Color.WHITE);
    assertEquals(true, pawn2.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Pawn(5, 5, Color.BLACK);
    assertEquals(false, pawn2.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Pawn(3, 5, Color.BLACK);
    assertEquals(false, pawn2.canKill(other));
  }

  @Test
  public void canNotKillTest3() {
    ChessPiece other = new Pawn(0, 1, Color.BLACK);
    assertEquals(false, pawn4.canKill(other));
  }

  @Test
  public void canNotKillTest4() {
    ChessPiece other = new Pawn(0, 1, Color.WHITE);
    assertEquals(false, pawn5.canKill(other));
  }
}