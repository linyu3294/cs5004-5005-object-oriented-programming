import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This is a Test class for Term.
 */
public class TermTest {
  private Term term;

  @Before
  public void setUp() throws Exception {
    term = new Term(3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    Term invalidTerm = new Term(3, -2);
  }

  @Test
  public void toStringTest() {
    assertEquals(" +3x^5", term.toString());
  }

  @Test
  public void equalsTest() {
    Term term2 = new Term(3, 5);
    assertTrue(term.equals(term2));
  }

  @Test
  public void getPowerTest() {
    assertEquals(5, term.getPower());
  }

  @Test
  public void getCoefficientTest() {
    assertEquals(3, term.getCoefficient());
  }

  @Test
  public void setCoefficientTest() {
    term.setCoefficient(10);
    assertEquals(10, term.getCoefficient());
  }
}