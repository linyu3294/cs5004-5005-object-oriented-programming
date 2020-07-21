/**
 * This class represents a vector. The class is given the name Vector3D The Vector3D object has a X,
 * Y, Z Component. Consulted the following resources. https://stackoverflow.com/questions/5168592/force-a-string-to-2-decimal-places.
 * Using the above url, looked up how to format doubles to nearest 2 decimal places.
 */

public class Vector3D {
  /**
   * This is the x component of Vector3D object.
   */
  private double xComponent;
  /**
   * This is the y component of Vector3D object.
   */
  private double yComponent;
  /**
   * This is the z component of Vector3D object.
   */
  private double zComponent;


  /**
   * Constructs a Vector3D object object and initializes it to give it x, y, z components.
   *
   * @param xComponent the x component of a Vector3D object.
   * @param yComponent the y component of a Vector3D object.
   * @param yComponent the z component of a Vector3D object.
   */
  Vector3D(double xComponent, double yComponent, double zComponent) {
    this.xComponent = xComponent;
    this.yComponent = yComponent;
    this.zComponent = zComponent;
  }

  /**
   * Get the x component of a Vector3D object.
   *
   * @return the x component of a Vector3D object.
   */
  public double getX() {
    return this.xComponent;
  }

  /**
   * Get the y component of a Vector3D object.
   *
   * @return the Y component of a Vector3D object.
   */
  public double getY() {
    return this.yComponent;
  }

  /**
   * Get the z component of a Vector3D object.
   *
   * @return the z component of a Vector3D object.
   */
  public double getZ() {
    return this.zComponent;
  }

  /**
   * Returns a String that describes a Vector3D object.
   *
   * @return a String that describes a Vector3D object. The string uses (x,y,z) format Each
   *         component. And it is rounded to exactly two decimal places.
   */
  @Override
  public String toString() {
    return "("
            + String.format("%.2f", this.xComponent) + ","
            + String.format("%.2f", this.yComponent) + ","
            + String.format("%.2f", this.zComponent)
            + ")";
  }

  /**
   * Calculates the magnitude of a Vector3D object and returns it.
   *
   * @return a double  that represents the magnitude of a Vector object.
   */
  public double getMagnitude() {
    double sqrX = this.xComponent * this.xComponent;
    double sqrY = this.yComponent * this.yComponent;
    double sqrZ = this.zComponent * this.zComponent;
    double sqrSum = sqrX + sqrY + sqrZ;
    double magnitude = (double) Math.sqrt(sqrSum);
    return magnitude;
  }

  /**
   * Obtains a new Vector3D object by dividing each component of the original by its magnitude.
   *
   * @return a new Vector3D object (normalized version of the original object)
   */
  public Vector3D normalize() {
    if (this.getMagnitude() == 0) {
      throw new IllegalStateException();
    }
    Vector3D other = new Vector3D(
            this.xComponent / this.getMagnitude(),
            this.yComponent / this.getMagnitude(),
            this.zComponent / this.getMagnitude());
    return (other);
  }

  /**
   * Adds two Vector3D objects together.
   *
   * @return a new Vector3D object derived from adding together two Vector3D objects.
   * @Param other - Vector3D object.
   */
  public Vector3D add(Vector3D other) {
    Vector3D newVector = new Vector3D(
            this.xComponent + other.xComponent,
            this.yComponent + other.yComponent,
            this.zComponent + other.zComponent
    );
    return newVector;
  }

  /**
   * returns a Vector3D object that's been multiplied by a constant.
   *
   * @param constant - a double constant multiplier.
   * @return the product (Vector3D object) of the original Vector3D object multiplied by a constant.
   */
  public Vector3D multiply(double constant) {
    Vector3D newVector = new Vector3D(
            this.xComponent * constant,
            this.yComponent * constant,
            this.zComponent * constant);
    return newVector;
  }

  /**
   * Calculates and returns the Dot Product of two Vector3D objects.
   *
   * @param other - Vector3D object.
   * @return the dot product (double) of this Vector3D object with a second Vector3D object.
   */
  public double dotProduct(Vector3D other) {
    double sumX = this.xComponent * other.xComponent;
    double sumY = this.yComponent * other.yComponent;
    double sumZ = this.zComponent * other.zComponent;
    return sumX + sumY + sumZ;
  }

  /**
   * Calculates the angle between two Vector3D objects in degrees.
   *
   * @param other - A Vector3D object.
   * @return degrees - a double that represents the degrees in an angle.
   */
  public double angleBetween(Vector3D other) {
    if (this.getMagnitude() == 0) {
      throw new IllegalStateException();
    }
    if (other.getMagnitude() == 0) {
      throw new IllegalStateException();
    }
    double degrees = Math.toDegrees(
            Math.acos((this.dotProduct(other)) / (this.getMagnitude() * other.getMagnitude()))
    );
    return degrees;
  }


}
