import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test class for Color Class.
 */
public class ColorTest {
  private ChessPiece rook1;
  private ChessPiece rook2;
  private ChessPiece rook3;

  @Before
  public void setUp() throws Exception {
    rook1 = new Rook(0, 3, Color.WHITE);
    rook2 = new Rook(4, 7, Color.BLACK);
    rook3 = new Rook(7, 5, Color.BLACK);
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
}