package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Class used for testing Square Class.
 */
public class SquareTest {

  @Test
  public void getStrTest1() {
    assertEquals("_", Square.UNOCCUPIED.getStr());
  }


  @Test
  public void getStrTest12() {
    assertEquals("O", Square.OCCUPIED.getStr());
  }


  @Test
  public void getStrTest3() {
    assertEquals("N", Square.NULL.getStr());
  }


  @Test
  public void getStrTest4() {
    assertEquals(" ", Square.OUTOFBOUND.getStr());
  }

}