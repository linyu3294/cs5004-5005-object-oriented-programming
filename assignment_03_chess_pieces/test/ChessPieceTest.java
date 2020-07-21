import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for ChessPiece Interface.
 */
public class ChessPieceTest {
  private ChessPiece pawn1;
  private ChessPiece pawn2;
  private ChessPiece knight1;
  private ChessPiece knight3;
  private ChessPiece rook1;
  private ChessPiece bishop1;
  private ChessPiece queen1;

  @Before
  public void setUp() throws Exception {
    pawn1 = new Pawn(0, 3, Color.WHITE);
    pawn2 = new Pawn(4, 6, Color.BLACK);
    knight1 = new Knight(0, 3, Color.WHITE);
    knight3 = new Knight(7, 5, Color.BLACK);
    rook1 = new Rook(0, 3, Color.WHITE);
    bishop1 = new Bishop(0, 3, Color.WHITE);
    queen1 = new Queen(0, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest1() {
    ChessPiece pawn1 = new Pawn(-5, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    ChessPiece knight1 = new Knight(5, -3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    ChessPiece rook1 = new Rook(-5, -3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    ChessPiece bishop1 = new Bishop(5, 9, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    ChessPiece queen1 = new Queen(10, 3, Color.BLACK);
  }

  @Test
  public void getRowTest1() {
    assertEquals(0, pawn1.getRow());
  }

  @Test
  public void getRowTest2() {
    assertEquals(0, knight1.getRow());
  }

  @Test
  public void getRowTest3() {
    assertEquals(0, rook1.getRow());
  }

  @Test
  public void getRowTest4() {
    assertEquals(0, bishop1.getRow());
  }

  @Test
  public void getRowTest5() {
    assertEquals(0, queen1.getRow());
  }

  @Test
  public void getColumnTest1() {
    assertEquals(3, pawn1.getColumn());
  }

  @Test
  public void getColumnTest2() {
    assertEquals(3, knight1.getColumn());
  }

  @Test
  public void getColumnTest3() {
    assertEquals(3, rook1.getColumn());
  }

  @Test
  public void getColumnTest4() {
    assertEquals(3, bishop1.getColumn());
  }

  @Test
  public void getColumnTest5() {
    assertEquals(3, queen1.getColumn());
  }

  @Test
  public void getColorTest1() {
    assertEquals(Color.WHITE, pawn1.getColor());
  }

  @Test
  public void getColorTest2() {
    assertEquals(Color.WHITE, knight1.getColor());
  }

  @Test
  public void getColorTest3() {
    assertEquals(Color.WHITE, rook1.getColor());
  }

  @Test
  public void getColorTest4() {
    assertEquals(Color.WHITE, bishop1.getColor());
  }

  @Test
  public void getColorTest5() {
    assertEquals(Color.WHITE, queen1.getColor());
  }

  @Test
  public void canMoveTest1() {
    assertEquals(true, pawn2.canMove(5, 6));
  }

  @Test
  public void canMoveTest2() {
    assertEquals(true, knight1.canMove(1, 5));
  }

  @Test
  public void canMoveTest3() {
    assertEquals(true, rook1.canMove(0, 0));
  }

  @Test
  public void canMoveTest4() {
    assertEquals(true, bishop1.canMove(4, 7));
  }

  @Test
  public void canMoveTest5() {
    assertEquals(true, queen1.canMove(0, 0));
  }

  @Test
  public void canNotMoveTest1() {
    assertEquals(false, pawn2.canMove(3, 6));
  }

  @Test
  public void canNotMoveTest2() {
    assertEquals(false, knight3.canMove(6, 4));
  }

  @Test
  public void canNotMoveTest3() {
    assertEquals(false, rook1.canMove(-1, 0));
  }

  @Test
  public void canNotMoveTest4() {
    assertEquals(false, bishop1.canMove(2, 2));
  }

  @Test
  public void canNotMoveTest5() {
    assertEquals(false, queen1.canMove(-1, 0));
  }

  @Test
  public void canKillTest1() {
    ChessPiece other = new Pawn(5, 5, Color.WHITE);
    assertEquals(true, pawn2.canKill(other));
  }

  @Test
  public void canKillTest2() {
    ChessPiece other = new Knight(1, 1, Color.BLACK);
    assertEquals(true, knight1.canKill(other));
  }

  @Test
  public void canKillTest3() {
    ChessPiece other = new Rook(0, 0, Color.BLACK);
    assertEquals(true, rook1.canKill(other));
  }

  @Test
  public void canKillTest4() {
    ChessPiece other = new Bishop(4, 7, Color.BLACK);
    assertEquals(true, bishop1.canKill(other));
  }

  @Test
  public void canKillTest5() {
    ChessPiece other = new Rook(0, 0, Color.BLACK);
    assertEquals(true, queen1.canKill(other));
  }

  @Test
  public void canNotKillTest1() {
    ChessPiece other = new Pawn(5, 5, Color.BLACK);
    assertEquals(false, pawn2.canKill(other));
  }

  @Test
  public void canNotKillTest2() {
    ChessPiece other = new Knight(6, 4, Color.WHITE);
    assertEquals(false, knight3.canKill(other));
  }

  @Test
  public void canNotKillTest3() {
    ChessPiece other = new Rook(0, 0, Color.WHITE);
    assertEquals(false, rook1.canKill(other));
  }

  @Test
  public void canNotKillTest4() {
    ChessPiece other = new Bishop(4, 7, Color.WHITE);
    assertEquals(false, bishop1.canKill(other));
  }

  @Test
  public void canNotKillTest5() {
    ChessPiece other = new Rook(0, 0, Color.WHITE);
    assertEquals(false, queen1.canKill(other));
  }
}