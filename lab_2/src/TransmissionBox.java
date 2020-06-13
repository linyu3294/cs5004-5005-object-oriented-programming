/**
 * This is a class that represents a TransmissionBox.
 */
public class TransmissionBox {
  private double speed;
  private double gear;
  private double thresholdOne;
  private double thresholdTwo;
  private double thresholdThree;
  private double thresholdFour;

  /**
   * Constructs a TransmissionBox object and initializes to gives it 5 parameters.
   * It will throw IllegalArgumentException if any of the parameters is invalid.
   *
   * @param speed       - current speed of the TransmissionBox object.
   * @param thresholdOne - Limit of gear 1.
   * @param thresholdTwo - Limit of gear 2.
   * @param thresholdThree - Limit of gear 3.
   * @param thresholdFour - Limit of gear 4.
   */

  TransmissionBox(double speed,
                  double thresholdOne,
                  double thresholdTwo,
                  double thresholdThree,
                  double thresholdFour) {

    if (speed <= 0) {
      throw new IllegalArgumentException();
    }
    if (thresholdOne <= 0) {
      throw new IllegalArgumentException();
    }
    if (thresholdTwo <= thresholdOne) {
      throw new IllegalArgumentException();
    }
    if (thresholdThree <= thresholdTwo) {
      throw new IllegalArgumentException();
    }
    if (thresholdFour <= thresholdThree) {
      throw new IllegalArgumentException();
    }


    this.speed = speed;
    this.thresholdOne = thresholdOne;
    this.thresholdTwo = thresholdTwo;
    this.thresholdThree = thresholdThree;
    this.thresholdFour = thresholdFour;

    if (this.speed >= 0 && this.speed < thresholdOne) {
      this.gear = 1;
    } else if (this.speed >= thresholdOne && this.speed < thresholdTwo) {
      this.gear = 2;
    } else if (this.speed >= thresholdTwo && this.speed < thresholdThree) {
      this.gear = 3;
    } else if (this.speed >= thresholdThree && this.speed < thresholdFour) {
      this.gear = 4;
    } else {
      this.gear = 5;
    }
  }

  /**
   * Returns the current speed of the TransmissionBox object.
   *
   * @return a Double that represents current speed.
   */
  public double getSpeed() {
    return this.speed;
  }

  /**
   * Returns the current gear of the TransmissionBox object.
   *
   * @return a Double that represents current gear.
   */
  public double getGear() {
    return this.gear;
  }

  /**
   * Returns a string that represents the TransmissionBox object.
   *
   * @return a string that represents the TransmissionBox object.
   */
  @Override
  public String toString() {
    String stTransmissionBox =
            "Current Speed is " + this.speed
                    + "\n"
                    + "Current Gear is" + this.gear;
    return stTransmissionBox;
  }

  /**
   * Returns a TransmissionBox object with speed + 2.
   *
   * @return a TransmissionBox object with speed + 2.
   */
  public TransmissionBox speedUp() {
    TransmissionBox newBox = new TransmissionBox(this.speed + 2,
            this.thresholdOne,
            this.thresholdTwo,
            this.thresholdThree,
            this.thresholdFour);
    return newBox;
  }

  /**
   * Returns a TransmissionBox object with speed - 2.
   *
   * @return a TransmissionBox object with speed - 2.
   */
  public TransmissionBox slowDown() {
    TransmissionBox newBox = new TransmissionBox(this.speed - 2,
            this.thresholdOne,
            this.thresholdTwo,
            this.thresholdThree,
            this.thresholdFour);
    return newBox;
  }


}
