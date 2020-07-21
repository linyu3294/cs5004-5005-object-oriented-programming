package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a class for testing CrossBoard.
 */
public class CrossBoardTest {
  private IBoard board1;
  private IBoard board2;

  @Before
  public void setUp() throws Exception {
    board1 = new CrossBoard(1, 2);
    board2 = new CrossBoard();
  }

  @Test
  public void outOfBoundTest1() {
    assertEquals(false, board1.inBound(1, 1));
  }

  @Test
  public void outOfBoundTest2() {
    assertEquals(false, board1.inBound(-4, 1));
  }

  @Test
  public void outOfBoundTest3() {
    assertEquals(false, board1.inBound(4, -5));
  }

  @Test
  public void outOfBoundTest4() {
    assertEquals(false, board1.inBound(4, 7));
  }

  @Test
  public void outOfBoundTest5() {
    assertEquals(false, board1.inBound(5, 6));
  }

  @Test
  public void setPiece() {
    board1.setPiece(1, 2);
    assertEquals("O", board1.checkSquareState(1, 2));
  }

  @Test
  public void removePiece() {
    board2.removePiece(2, 6);
    assertEquals("X", board1.checkSquareState(2, 6));
  }


}