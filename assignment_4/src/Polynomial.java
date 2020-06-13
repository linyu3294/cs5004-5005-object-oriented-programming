/**
 * This is a Interface class used to define Polynomial operations.
 */
public interface Polynomial {
  /**
   * Gets the highest power(degree) of any node in a polynomial.
   *
   * @return a int that represents the highest power.
   */
  int getDegree();

  /**
   * Gets the coefficient of a specified power in a polynomial.
   *
   * @return a int that represents a coefficient.
   */
  int getCoefficient(int power);

  /**
   * Adds a node to a polynomial.
   *
   * @param coefficient - coefficient of a Node.
   * @param power       - power of a node.
   */
  void addTerm(int coefficient, int power);

  /**
   * Removes a node with the specified power in a polynomial.
   *
   * @param power - int that represents the power of a node.
   */
  void removeTerm(int power);

  /**
   * Calculates a polynomial by using a value to plug in for X.
   *
   * @param xValue - a double passed into the polynomial for X.
   */
  double evaluate(double xValue);

  /**
   * Adds two polynomials together.
   *
   * @param other - another polynomial.
   * @return - the result of combining two polynomials.
   */
  Polynomial add(Polynomial other);
}
