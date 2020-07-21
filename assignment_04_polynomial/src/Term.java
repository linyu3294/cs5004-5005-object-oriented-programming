/**
 * This is a class that represents a Polynomial Term.
 */
public class Term implements ITerm {
  private int coefficient;
  private int power;

  /**
   * This is a constructor for a term object.
   *
   * @param coefficient - an int that represents a coefficient.
   * @param power       - an int that represents the power of a term.
   */
  public Term(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative!");
    }

    this.coefficient = coefficient;
    this.power = power;

  }

  /**
   * Returns a String that represents a term.
   *
   * @return String - a String that represents a term.
   */
  @Override
  public String toString() {
    String expression;
    String coefficientStr = "";
    if (this.coefficient > 0) {
      coefficientStr = " +" + this.coefficient;
    } else if (this.coefficient < 0) {
      coefficientStr = " -" + Math.abs(this.coefficient);
    } 

    String powerStr = "";
    if (this.power != 0 && this.coefficient != 0) {
      powerStr = "x^" + this.power;
    }
    expression = coefficientStr + powerStr;
    return expression;
  }


  /**
   * This is a dummy override.
   *
   * @return - unused dummy.
   */
  @Override
  public int hashCode() {
    System.out.println("Dummy Code");
    return this.hashCode();
  }


  /**
   * Compares two terms.
   *
   * @param other - another term.
   * @return a boolean.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(this instanceof Term)) {
      return false;
    }
    Term otherTerm = (Term) other;
    boolean sameTerm = other.toString().equals(this.toString());
    return sameTerm;
  }

  /**
   * Gets the power of a term.
   *
   * @return - an integer that represens a power.
   */
  @Override
  public int getPower() {
    return this.power;
  }

  /**
   * Gets the coefficient of a term.
   *
   * @return - an integer that represens a coefficient.
   */
  @Override
  public int getCoefficient() {
    return this.coefficient;
  }

  /**
   * Sets the coefficient for a term.
   *
   * @param coefficient - an integer that represents a coefficient.
   */
  @Override
  public void setCoefficient(int coefficient) {
    this.coefficient = coefficient;
  }

}
