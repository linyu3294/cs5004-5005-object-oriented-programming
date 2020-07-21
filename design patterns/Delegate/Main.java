package delegate;

public class Main {
  public static void main(String args[]) {
    Cat c = new Cat();
    // Delegation
    c.makeSound();          // Output: Meow
    // now to change the sound it makes
    ISoundBehaviour newsound = new RoarSound();
    c.setSoundBehaviour(newsound);
    // Delegation
    c.makeSound();          // Output: Roar!
  }
}