/**
 * This a class for EmptyNode.
 */
public class EmptyNode implements Sentence {

  /**
   * Returns 0.
   *
   * @return - 0 words at the start.
   */
  @Override
  public int getNumberOfWords() {
    return 0;
  }

  /**
   * Returns empty string.
   *
   * @return - 0 words at the start.
   */
  @Override
  public String longestWord() {
    return "";
  }

  /**
   * Returns empty string.
   *
   * @return - 0 words at the start.
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Returns sentence to merge.
   *
   * @return - other sentence.
   */
  @Override
  public Sentence merge(Sentence other) {
    return other.clone();
  }

  /**
   * Returns empty Node.
   *
   * @return - 0 words at start.
   */
  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

}
