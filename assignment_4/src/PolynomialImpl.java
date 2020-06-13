/**
 * This represents a class of Linked List that comprises multiple nodes.
 */
public class PolynomialImpl implements Polynomial {
  private INode head;
  private INode tail;
  private int terms;

  /**
   * This is a constructor for the PlynomialImp class.
   */
  public PolynomialImpl() {
    this.head = null;
    this.tail = null;
  }

  /**
   * This is a constructor for the PlynomialImp class.
   */
  public PolynomialImpl(String poly) {
    String[] polyArray = poly.split(" ");
    if (polyArray.length == 0) {
      throw new IllegalArgumentException("No valid terms found in input string.");
    }
    for (int i = 0; i < polyArray.length; i++) {
      if (i == 0 && !polyArray[i].contains("-") && !polyArray[i].contains("+")) {
        polyArray[i] = "+" + polyArray[i];
      }
      if (polyArray[i].contains("-x")) {
        polyArray[i].replace("-x", "-1x");
      }
      if (polyArray[i].contains("+x")) {
        polyArray[i].replace("+x", "+1x");
      }
      if (polyArray[i].contains("x") && !polyArray[i].contains("^")) {
        polyArray[i] = polyArray[i] + "^1";
      }
      if (!polyArray[i].contains("x^")) {
        polyArray[i] = polyArray[i] + "x^0";
      }


      if (
              !polyArray[i].contains("^")
                      || !polyArray[i].contains("x")
      ) {
        throw new IllegalArgumentException("Invalid format.");
      }
      int newCoefficient = Integer.parseInt(polyArray[i].
              replace("^", "#").
              split("x#")[0]);
      int newPower = Integer.parseInt(polyArray[i]
              .replace("^", "#").
                      split("x#")[1]);
      this.addTerm(newCoefficient, newPower);
    }

  }


  /**
   * Compares two polynomial objects.
   *
   * @return - a boolean asserting equality.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(this instanceof PolynomialImpl)) {
      return false;
    }
    PolynomialImpl otherPoly = (PolynomialImpl) other;
    boolean samePolynomial = other.toString().equals(this.toString());
    return samePolynomial;
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
   * returns a string that represents a polynomial.
   *
   * @return a String that represents a polynomial.
   */
  @Override
  public String toString() {
    INode tempNode = this.head;
    String polynomialString = "";
    while (tempNode != null) {
      polynomialString = polynomialString + tempNode.getTerm().toString();
      if (tempNode.equals(this.head)) {
        polynomialString = polynomialString.
                replace(" +", "").
                replace(" -", "-");
      }
      tempNode = tempNode.getNext();
    }
    return polynomialString;
  }


  /**
   * Gets the degree/ or highest power of a polynomial.
   *
   * @return an integer that represents the degree.
   * @throws IllegalStateException - when polynomial is empty.
   */
  @Override
  public int getDegree() throws IllegalStateException {
    int degree;
    if (this.head != null) {
      try {
        String temp = this.head.getTerm().toString();
        temp = temp.replace("^", "_").split("_")[1];
        degree = Integer.parseInt(temp);
      } catch (ArrayIndexOutOfBoundsException e) {
        degree = 1;
      }
      return degree;
    } else {
      throw new IllegalStateException("Polynomial has no terms!");
    }
  }


  /**
   * Gets the coefficient of the specified power of a polynomial.
   *
   * @return a coefficient of a specified power.
   * @throws IllegalStateException - when polynomial has no coefficient for the power.
   */
  @Override
  public int getCoefficient(int power) {
    INode tempNode = this.head;
    int coefficient = 0;
    while (tempNode != null) {
      if (tempNode.getTerm().getPower() == power) {
        coefficient = tempNode.getTerm().getCoefficient();
      }
      tempNode = tempNode.getNext();
    }
    return coefficient;
  }


  /**
   * Adds a term to the polynomial as a node.
   *
   * @param coefficient - coefficient of a Node.
   * @param power       - power of a node.
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    ITerm newTerm = new Term(coefficient, power);
    INode newNode = new PolyNode(newTerm);

    if (this.head == null && this.tail == null) {
      this.head = newNode;
      this.tail = newNode;

    } else {
      if (newNode.getTerm().getCoefficient() != 0) {
        INode tempNode = this.head;

        while (tempNode != null) {
          Term tempTerm = (Term) tempNode.getTerm();
          int tempTermPower = tempTerm.getPower();

          if (power == tempTermPower) {
            tempTerm.setCoefficient(tempTerm.getCoefficient() + coefficient);
            break;
          }

          if (power > tempTermPower) {
            newNode.setNext(tempNode);
            newNode.setPrevious(tempNode.getPrevious());
            try {
              tempNode.getPrevious().setNext(newNode);
            } catch (NullPointerException e) {
              this.head = newNode;
            }
            tempNode.setPrevious(newNode);
            break;
          }

          if (tempNode.getNext() == null) {
            newNode.setPrevious(tempNode);
            newNode.setNext(tempNode.getNext());
            try {
              tempNode.getNext().setPrevious(newNode);
            } catch (NullPointerException e) {
              this.tail = newNode;
            }
            tempNode.setNext(newNode);
            break;
          }
          tempNode = tempNode.getNext();
        }
      }
    }
  }


  /**
   * Removes a node in the Polynomial.
   *
   * @param power - int that represents the power of a node.
   */
  @Override
  public void removeTerm(int power) {
    INode tempNode = this.head;
    while (tempNode != null) {
      if (this.head == null && this.tail == null) {
        throw new IllegalArgumentException("Polynomial has no terms!");
      }
      if (power == tempNode.getTerm().getPower()) {
        try {
          tempNode.getPrevious().setNext(tempNode.getNext());
        } catch (NullPointerException e) {
          this.head = tempNode.getNext();
        }
        try {
          tempNode.getNext().setPrevious(tempNode.getPrevious());
        } catch (NullPointerException e) {
          this.tail = tempNode.getPrevious();
        }
      }
      tempNode = tempNode.getNext();

    }
  }


  /**
   * Removes a node in the Polynomial.
   *
   * @param xValue - int that represents the power of a node.
   */
  @Override
  public double evaluate(double xValue) {
    Double sum = 0.00;
    INode tempNode = this.head;
    while (tempNode != null) {
      sum = sum + (tempNode.getTerm().getCoefficient()
              * (Math.pow(xValue, tempNode.getTerm().getPower())));
      tempNode = tempNode.getNext();
    }
    return sum;
  }


  /**
   * Combines two polynomials together.
   *
   * @param other - another polynomial.
   * @return a single polynomial that represents the result of combining two.
   */
  @Override
  public Polynomial add(Polynomial other) {
    Polynomial newPoly = new PolynomialImpl();
    String otherString = other.toString();
    if (
            !otherString.split(" ")[0].contains("+")
                    && !otherString.split(" ")[0].contains("-")
    ) {
      otherString = "+" + otherString;
    }
    newPoly = new PolynomialImpl(this.toString() + " " + otherString);
    return newPoly;
  }
}
