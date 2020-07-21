package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This is a class for testing MarbleSolitaireControllerImpl class.
 */
public class MarbleSolitaireControllerImplTest {
  MarbleSolitaireController controller;
  MarbleSolitaireModel model;


  @Test
  public void nullReadableTest() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = null;
    String msg = "";
    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    } catch (IllegalArgumentException e) {
      msg = e.getMessage();
    }
    assertEquals(
            "Readable input is null.", msg);
  }


  @Test
  public void nullAppendableTest() throws IOException {
    StringBuffer out = null;
    Reader in = new StringReader("6 4 4 4");
    String msg = "";
    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    } catch (IllegalArgumentException e) {
      msg = e.getMessage();
    }
    assertEquals(
            "Appendable input is null.", msg);
  }

  @Test
  public void invalidModelTest() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("6 4 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    model = null;
    String msg = "";
    try {
      controller.playGame(model);
    } catch (IllegalArgumentException e) {
      msg = e.getMessage();
    }
    assertEquals(
            "The model is null.", msg);
  }

  @Test
  public void inputRunOutTest() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("6 4 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    model = new MarbleSolitaireModelImpl();
    String msg = "";
    try {
      controller.playGame(model);
    } catch (IllegalStateException e) {
      msg = e.getMessage();
    }
    assertEquals(
            "Readable ran out of inputs", msg);
  }

  @Test
  public void invalidIInputTest() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("i q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    model = new MarbleSolitaireModelImpl();
    controller.playGame(model);
    assertEquals("Invalid move. Play again. Input must be a positive integer or 'q/Q'.\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n", out.toString());
  }

  @Test
  public void moveTest() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    model = new MarbleSolitaireModelImpl();
    controller.playGame(model);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n", out.toString());
  }

}