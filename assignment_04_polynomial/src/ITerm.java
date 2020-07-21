/**
 * This is a a Interface that represents a Term.
 */
public interface ITerm {
  /**
   * Gets the value of the power that's in a term.
   *
   * @return - an integer that represents an exponent.
   */
  int getPower();

  /**
   * Gets the value of the coefficient that's in a term.
   *
   * @return - an integer that represents an coefficient.
   */
  int getCoefficient();

  /**
   * Resets the value of a coefficient that's in a term.
   *
   */
  void setCoefficient(int coefficient);
}
