
public class Singleton {

  private static Singleton instance;

  /** Don't let anyone else instantiate this class */
  private Singleton() {}

  /** Lazily create the instance when it is accessed for the first time */
  public static synchronized Singleton getInstance() {
    if(instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}