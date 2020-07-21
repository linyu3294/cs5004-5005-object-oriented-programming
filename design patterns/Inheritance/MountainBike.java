package Inheritance;

public class MountainBike extends Bicycle {
  public int seatHeight;

  public MountainBike(int gear, int speed, int seatHeight) {
    super(gear, speed);
    this.seatHeight = seatHeight;
  }

  public void setSeatHeight(int newSeatHeight) {
    this.seatHeight = newSeatHeight;
  }

  public String toString() {
    return (super.toString()) + this.seatHeight;
  }

}
