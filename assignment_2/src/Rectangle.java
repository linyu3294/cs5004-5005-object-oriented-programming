import java.util.NoSuchElementException;

/**
 * This is a class that represents a Rectangle.
 */
public class Rectangle {
  private double lowerLeftX;
  private double lowerLeftY;
  private double width;
  private double height;
  private double upperBound;
  private double rightBound;


  /**
   * This is the constructor for a Rectangle object.
   *
   * @param lowerLeftX - x coordinate of the lower left point of a Rectangle object.
   * @param lowerLeftY - y coordinate of the lower left point of a Rectangle object.
   * @param width      - the width of a Rectangle object.
   * @param height     - the height of a Rectangle object.
   * @throws IllegalStateException when either width or height is less or equal to 0.
   */
  public Rectangle(double lowerLeftX,
                   double lowerLeftY,
                   double width,
                   double height) throws IllegalStateException {
    if (width < 0) {
      throw new IllegalArgumentException(
              "Rectangle cannot have a width that's less or equal to 0"
      );
    }
    if (height < 0) {
      throw new IllegalArgumentException(
              "Rectangle cannot have a height that's less or equal to 0"
      );
    }
    this.width = width;
    this.height = height;
    this.lowerLeftX = lowerLeftX;
    this.lowerLeftY = lowerLeftY;
    this.rightBound = this.lowerLeftX + this.width;
    this.upperBound = this.lowerLeftY + this.height;
  }

  /**
   * Writes a Rectangle object to String.
   *
   * @return a String that represents the attributes of a Rectangle object.
   */
  @Override
  public String toString() {
    return "x:" + Math.round(this.lowerLeftX)
            + ", y:" + Math.round(this.lowerLeftY)
            + ", w:" + Math.round(this.width)
            + ", h:" + Math.round(this.height);
  }

  @Override
  public int hashCode() {
    System.out.println("Dummy Code");
    return this.hashCode();
  }

  /**
   * This is a method used to compare to Rectangle objects.
   *
   * @param objOther - the Rectangle object being compared with.
   * @return boolean - result of the comparison
   */
  @Override
  public boolean equals(Object objOther) {
    if (this == objOther) {
      return true;
    }
    if (!(objOther instanceof Rectangle)) {
      return false;
    }
    Rectangle other = (Rectangle) objOther;
    boolean sameX = this.lowerLeftX == other.lowerLeftX;
    boolean sameY = this.lowerLeftY == other.lowerLeftY;
    boolean sameW = this.width == other.width;
    boolean sameH = this.height == other.height;
    return sameX && sameY && sameW && sameH;
  }

  /**
   * Determines if this Rectangle object overlaps with another Rectangle object.
   *
   * @param other - Another Rectangle object.
   * @return a boolean.
   */
  public boolean overlap(Rectangle other) {
    Double sumX = Math.max(this.rightBound, other.rightBound)
            - Math.min(this.lowerLeftX, other.lowerLeftX);
    Double sumWidth = this.width + other.width;
    Double sumY = Math.max(this.upperBound, other.upperBound)
            - Math.min(this.lowerLeftY, other.lowerLeftY);
    Double sumHeight = this.height + other.height;
    Boolean widthOverlap = sumX < sumWidth;
    Boolean heightOverlap = sumY < sumHeight;
    return (widthOverlap && heightOverlap);
  }

  /**
   * Produces a Rectangle object from two overlapping Rectangle objects.
   *
   * @param other - a Rectangle object.
   * @return a  intersecting Rectangle object of two overlapping Rectangle objects.
   * @throws NoSuchElementException when two Rectangle objects do NOT overlap.
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    if (!this.overlap(other)) {
      throw new NoSuchElementException(
              "This rectangle does not overlap with other rectangle! "
                      + "No intersecting rectangle can be derived!");
    }
    Double newLowerLeftX = Math.max(this.lowerLeftX, other.lowerLeftX);
    Double newLowerLeftY = Math.max(this.lowerLeftY, other.lowerLeftY);
    Double newWidth =
            Math.abs(this.width + other.width) - (Math.max(this.rightBound, other.rightBound)
                    - Math.min(this.lowerLeftX, other.lowerLeftX));
    Double newHeight =
            Math.abs(this.height + other.height) - (Math.max(this.upperBound, other.upperBound)
                    - Math.min(this.lowerLeftY, other.lowerLeftY));
    return new Rectangle(newLowerLeftX, newLowerLeftY, newWidth, newHeight);
  }


  /**
   * Produces a smallest Rectangle object that encompasses two Rectangle objects. This method does
   * not require the two initial objects overlap one another.
   *
   * @param other - a Rectangle object.
   * @return a Rectangle object - result of a union of two Rectangle objects.
   */
  public Rectangle union(Rectangle other) {
    Double newLowerLeftX = Math.min(this.lowerLeftX, other.lowerLeftX);
    Double newLowerLeftY = Math.min(this.lowerLeftY, other.lowerLeftY);
    Double newWidth =
            (Math.max(this.rightBound, other.rightBound)
                    - Math.min(this.lowerLeftX, other.lowerLeftX));
    Double newHeight =
            (Math.max(this.upperBound, other.upperBound)
                    - Math.min(this.lowerLeftY, other.lowerLeftY));
    return (new Rectangle(newLowerLeftX, newLowerLeftY, newWidth, newHeight));
  }
}



