package cs3500.marblesolitaire.model.hw02;


import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.GameOver;
import cs3500.marblesolitaire.model.hw04.IGameOver;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test class for MarbleSolitaireModel.
 */
public class EnglishSolitaireModelImpTest {
  private IBoard board;
  private OrthoRules ortho;
  private IGameOver gameOver;

  @Before
  public void setup() {
    board = new CrossBoard(3,3,3);
    ortho = new OrthoRules(board);
    gameOver = new GameOver(board);
  }

  @Test
  public void constructorTest1() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl(1, 3);
    board = new CrossBoard(3,1, 3);
    assertEquals("_", board.checkSquareState(1, 3));
  }

  @Test
  public void constructorTest2() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(0, 4);
    board = new CrossBoard(3,0, 4);
    assertEquals("_", board.checkSquareState(0, 4));
  }

  @Test
  public void constructorTest3() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(4, 5);
    board = new CrossBoard(3,4, 5);
    assertEquals("_", board.checkSquareState(4, 5));

  }

  @Test
  public void constructorTest4() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(6, 2);
    board = new CrossBoard(3,6, 2);
    assertEquals("_", board.checkSquareState(6, 2));

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest1() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(0, 0);
    board = new CrossBoard(3,0, 0);
    assertEquals("_", board.checkSquareState(0, 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest2() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(5, 5);
    board = new CrossBoard(3,5, 5);
    assertEquals("_", board.checkSquareState(5, 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest3() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(1, 5);
    board = new CrossBoard(3,1, 5);
    assertEquals("_", board.checkSquareState(1, 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest4() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(5, 5);
    board = new CrossBoard(3,5, 5);
    assertEquals("_", board.checkSquareState(5, 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest5() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(-1, 4);
    board = new CrossBoard(3,-1, 4);
    assertEquals("_", board.checkSquareState(-1, 4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest6() {
    MarbleSolitaireModel newMarble = new MarbleSolitaireModelImpl(3, 7);
    board = new CrossBoard(3,3, 7);
    assertEquals("N", board.checkSquareState(3, 7));
  }


  @Test
  public void moveRightTest() {
    ortho.moveAndChangeState(board, 3, 1, 3, 3);
    assertEquals("O", board.checkSquareState(3, 3));
    assertEquals("_", board.checkSquareState(3, 1));
    assertEquals("_", board.checkSquareState(3, 2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest1() {
    ortho.moveAndChangeState(board, 3, 0, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest2() {
    ortho.moveAndChangeState(board, 3, 0, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest3() {
    ortho.moveAndChangeState(board, 3, 2, 3, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest4() {
    ortho.moveAndChangeState(board, 3, 3, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest5() {
    ortho.moveAndChangeState(board, 3, 1, 3, 3);
    ortho.moveAndChangeState(board, 3, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest6() {
    ortho.moveAndChangeState(board, 3, 1, 3, 3);
    ortho.moveAndChangeState(board, 3, 0, 3, 2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest7() {
    ortho.moveAndChangeState(board, 1, 3, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveRightTest8() {
    ortho.moveAndChangeState(board, 1, 0, 1, 2);
  }

  @Test
  public void moveLeftTest() {
    ortho.moveAndChangeState(board, 3, 5, 3, 3);
    assertEquals("O", board.checkSquareState(3, 3));
    assertEquals("_", board.checkSquareState(3, 5));
    assertEquals("_", board.checkSquareState(3, 4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest1() {
    ortho.moveAndChangeState(board, 3, 6, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest2() {
    ortho.moveAndChangeState(board, 3, 6, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest3() {
    ortho.moveAndChangeState(board, 3, 4, 3, 2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest4() {
    ortho.moveAndChangeState(board, 3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest5() {
    ortho.moveAndChangeState(board, 3, 5, 3, 3);
    ortho.moveAndChangeState(board, 3, 5, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest6() {
    ortho.moveAndChangeState(board, 3, 5, 3, 3);
    ortho.moveAndChangeState(board, 3, 6, 3, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest7() {
    ortho.moveAndChangeState(board, 1, 2, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveLeftTest8() {
    ortho.moveAndChangeState(board, 1, 5, 1, 3);
  }

  @Test
  public void moveUpTest() {
    ortho.moveAndChangeState(board, 5, 3, 3, 3);
    assertEquals("O", board.checkSquareState(3, 3));
    assertEquals("_", board.checkSquareState(4, 3));
    assertEquals("_", board.checkSquareState(5, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest1() {
    ortho.moveAndChangeState(board, 6, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest2() {
    ortho.moveAndChangeState(board, 6, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest3() {
    ortho.moveAndChangeState(board, 4, 3, 2, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest4() {
    ortho.moveAndChangeState(board, 3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest5() {
    ortho.moveAndChangeState(board, 5, 3, 3, 3);
    ortho.moveAndChangeState(board, 5, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest6() {
    ortho.moveAndChangeState(board, 5, 3, 3, 3);
    ortho.moveAndChangeState(board, 6, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest7() {
    ortho.moveAndChangeState(board, 5, 1, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveUpTest8() {
    ortho.moveAndChangeState(board, 2, 5, 0, 5);
  }


  @Test
  public void moveDownTest() {
    ortho.moveAndChangeState(board, 1, 3, 3, 3);
    assertEquals("O", board.checkSquareState(3, 3));
    assertEquals("_", board.checkSquareState(1, 3));
    assertEquals("_", board.checkSquareState(2, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest1() {
    ortho.moveAndChangeState(board, 0, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest2() {
    ortho.moveAndChangeState(board, 0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest3() {
    ortho.moveAndChangeState(board, 2, 3, 4, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest4() {
    ortho.moveAndChangeState(board, 3, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest5() {
    ortho.moveAndChangeState(board, 1, 3, 3, 3);
    ortho.moveAndChangeState(board, 1, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest6() {
    ortho.moveAndChangeState(board, 1, 3, 3, 3);
    ortho.moveAndChangeState(board, 0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest7() {
    ortho.moveAndChangeState(board, 1, 1, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMoveDownTest8() {
    ortho.moveAndChangeState(board, 4, 5, 6, 5);
  }


  @Test
  public void getScoreTest1() {
    ortho.moveAndChangeState(board, 3, 5, 3, 3);
    assertEquals(31, board.getScore());
  }

  @Test
  public void gameOverTest() {
    OrthoRules ortho = new OrthoRules(board);
    /**--- MOVE 1 ---  */
    ortho.moveAndChangeState(board, 3, 1, 3, 3);

    /**--- MOVE 2 ---  */
    ortho.moveAndChangeState(board, 5, 2, 3, 2);

    /**--- MOVE 3 ---  */
    ortho.moveAndChangeState(board, 4, 0, 4, 2);

    /**--- MOVE 4 ---  */
    ortho.moveAndChangeState(board, 4, 3, 4, 1);

    /**--- MOVE 5 ---  */
    ortho.moveAndChangeState(board, 4, 5, 4, 3);

    /**--- MOVE 6 ---  */
    ortho.moveAndChangeState(board, 6, 4, 4, 4);

    /**--- MOVE 7 ---  */
    ortho.moveAndChangeState(board, 3, 4, 5, 4);

    /**--- MOVE 8 ---  */
    ortho.moveAndChangeState(board, 6, 2, 6, 4);

    /**--- MOVE 8.1 ---  */
    ortho.moveAndChangeState(board, 6, 4, 4, 4);

    /**--- MOVE 9 ---  */
    ortho.moveAndChangeState(board, 2, 2, 4, 2);

    /**--- MOVE 10 ---  */
    ortho.moveAndChangeState(board, 0, 2, 2, 2);

    /**--- MOVE 11.1 ---  */
    ortho.moveAndChangeState(board, 1, 4, 3, 4);

    /**--- MOVE 11.2 ---  */
    ortho.moveAndChangeState(board, 3, 4, 5, 4);

    /**--- MOVE 11.3 ---  */
    ortho.moveAndChangeState(board, 5, 4, 5, 2);

    /**--- MOVE 11.4 ---  */
    ortho.moveAndChangeState(board, 5, 2, 3, 2);

    /**--- MOVE 11.5 ---  */
    ortho.moveAndChangeState(board, 3, 2, 1, 2);

    /**--- MOVE 12.1 ---  */
    ortho.moveAndChangeState(board, 2, 0, 4, 0);

    /**--- MOVE 12.2 ---  */
    ortho.moveAndChangeState(board, 4, 0, 4, 2);

    /**--- MOVE 12.3 ---  */
    ortho.moveAndChangeState(board, 4, 2, 4, 4);

    /**--- MOVE 13 ---  */
    ortho.moveAndChangeState(board, 2, 6, 2, 4);

    /**--- MOVE 14 ---  */
    ortho.moveAndChangeState(board, 2, 3, 2, 5);

    /**--- MOVE 15.1 ---  */
    ortho.moveAndChangeState(board, 4, 6, 2, 6);

    /**--- MOVE 15.2 ---  */
    ortho.moveAndChangeState(board, 2, 6, 2, 4);

    /**--- MOVE 16.1 ---  */
    ortho.moveAndChangeState(board, 0, 4, 0, 2);

    /**--- MOVE 16.2 ---  */
    ortho.moveAndChangeState(board, 0, 2, 2, 2);

    /**--- MOVE 17.1 ---  */
    ortho.moveAndChangeState(board, 2, 1, 2, 3);

    /**--- MOVE 17.2 ---  */
    ortho.moveAndChangeState(board, 2, 3, 2, 5);

    assertEquals(false, gameOver.gameOver(board));

    /**--- MOVE 17.3 ---  */
    ortho.moveAndChangeState(board, 2, 5, 4, 5);

    assertEquals(false, gameOver.gameOver(board));

    /**--- MOVE 17.4 ---  */
    ortho.moveAndChangeState(board, 4, 5, 4, 3);

    assertEquals(false, gameOver.gameOver(board));

    /**--- MOVE 17.5 ---  */
    ortho.moveAndChangeState(board, 4, 3, 2, 3);

    assertEquals(false, gameOver.gameOver(board));

    /**--- MOVE 17.5 ---  */
    ortho.moveAndChangeState(board, 1, 3, 3, 3);

    assertEquals(true, gameOver.gameOver(board));
  }
}