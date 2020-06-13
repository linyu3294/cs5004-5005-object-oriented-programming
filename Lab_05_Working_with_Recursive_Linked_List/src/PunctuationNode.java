/**
 * This is a class for PunctuationNode.
 */
public class PunctuationNode implements Sentence {
  private String punctuation;
  private Sentence rest;

  /**
   * This is a constructor for class PunctuationNode.
   *
   * @param punctuation - a String.
   * @param rest        - a String.
   */
  public PunctuationNode(String punctuation, Sentence rest) {
    this.punctuation = punctuation;
    this.rest = rest;
  }

  /**
   * A method to get number of words.
   *
   * @return - a integer.
   */
  @Override
  public int getNumberOfWords() {
    return this.rest.getNumberOfWords();
  }

  /**
   * A method to get longest word.
   *
   * @return - a integer.
   */
  @Override
  public String longestWord() {
    return this.rest.longestWord();
  }

  /**
   * Returns a String that represents a sentence.
   *
   * @return - a Sentence.
   */
  @Override
  public String toString() {
    return this.punctuation + this.rest;
  }

  /**
   * clones a sentence.
   *
   * @return - a Sentence.
   */
  @Override
  public Sentence clone() {
    return new PunctuationNode(this.punctuation, this.rest.clone());
  }

  /**
   * merges a sentence with another.
   *
   * @return - a Sentence.
   */
  @Override
  public Sentence merge(Sentence other) {
    return new PunctuationNode(this.punctuation, this.rest.merge(other));
  }
}
