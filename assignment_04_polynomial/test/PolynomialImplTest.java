import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test class for Polynomial.
 */
public class PolynomialImplTest {
  private Polynomial polynomialtest = new PolynomialImpl();


  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructorTest() {
    Polynomial invalidPolynomial = new PolynomialImpl("-3x^-4 +4x");

  }

  @Test
  public void toStringTest1() {
    polynomialtest.addTerm(0, 4);
    assertEquals("", polynomialtest.toString());
  }

  @Test
  public void toStringTest2() {
    polynomialtest.addTerm(4, 0);
    assertEquals("4", polynomialtest.toString());
  }

  @Test
  public void toString3() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.addTerm(2, 8);
    assertEquals("2x^8 -2x^4 -8x^3", polynomialtest.toString());
  }

  @Test
  public void equalsTest1() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.addTerm(2, 8);
    assertEquals("2x^8 -2x^4 -8x^3", polynomialtest.toString());
  }

  @Test
  public void getDegreeTest1() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.addTerm(2, 8);
    assertEquals(8, polynomialtest.getDegree());
  }

  @Test
  public void getCoefficientTest1() {
    polynomialtest.addTerm(2, 8);
    assertEquals(2, polynomialtest.getCoefficient(8));
  }

  public void getCoefficientTest2() {
    polynomialtest.addTerm(-2, 8);
    assertEquals(-2, polynomialtest.getCoefficient(8));
  }


  @Test
  public void addTermTest1() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.addTerm(2, 8);
    assertEquals("2x^8 -2x^4 -8x^3", polynomialtest.toString());
  }

  @Test
  public void removeTermTest1() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.removeTerm(3);
    assertEquals("-2x^4", polynomialtest.toString());
  }

  @Test
  public void removeTermTest2() {
    polynomialtest.addTerm(2, 4);
    polynomialtest.addTerm(-4, 4);
    polynomialtest.addTerm(2, 2);
    polynomialtest.addTerm(-8, 3);
    polynomialtest.removeTerm(4);
    assertEquals("-8x^3 +2x^2", polynomialtest.toString());
  }

  @Test
  public void evaluateTest1() {
    polynomialtest.addTerm(15, 844);
    polynomialtest.addTerm(-10, 434);
    double evalResult = polynomialtest.evaluate(1.01);
    assertEquals( 65827.2810, evalResult, 0.01);

  }

  @Test
  public void addTest1() {
    Polynomial poly1 = new PolynomialImpl();
    poly1.addTerm(2, 4);
    poly1.addTerm(-4, 6);
    System.out.println(poly1.toString());
    Polynomial poly2 = new PolynomialImpl();
    poly2.addTerm(2, 2);
    poly2.addTerm(-8, 3);
    System.out.println(poly2.toString());
    assertEquals("-4x^6 +2x^4 -8x^3 +2x^2", poly1.add(poly2).toString());
  }
}