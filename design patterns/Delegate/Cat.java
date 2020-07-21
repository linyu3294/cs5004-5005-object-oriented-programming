package delegate;

public class Cat {
  private ISoundBehaviour sound = new MeowSound();

  public void makeSound() {
    this.sound.makeSound();
  }

  public void setSoundBehaviour(ISoundBehaviour newsound) {
    this.sound = newsound;
  }
}
