/**
 * This is a class for Sentence.
 */
public class WordNode implements Sentence {
  private String word;
  private Sentence rest;

  /**
   * This is a constructor for the Sentence Class.
   *
   * @param word - string.
   * @param rest - a Sentence.
   */
  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  /**
   * Does: Calculates the total number of words in a Sentence.
   *
   * @return - The total number of words from "current" + the rest of the words.
   */
  @Override
  public int getNumberOfWords() {
    return 1 + this.rest.getNumberOfWords();
  }

  /**
   * Does: Determines the longest word in the sentence.
   *
   * @return - A string of the longest word.
   */
  @Override
  public String longestWord() {
    if (word.length() >= this.rest.longestWord().length()) {
      return this.word;
    }
    return this.rest.longestWord();
  }

  /**
   * Does: Adds a period to the end of the string if there none.
   *
   * @return - a String.
   */
  @Override
  public String toString() {
    if (this.rest.toString().equals("")) {
      // If we are at the end of the word nodes
      // and check for last node is Empty Node
      return this.word + ".";
    }
    if (rest instanceof PunctuationNode) {
      return this.word + this.rest.toString();
    }

    return this.word + " " + this.rest.toString();
  }

  /**
   * Does: clones a sentence.
   *
   * @return - a String.
   */
  @Override
  public Sentence clone() {
    return new WordNode(this.word, this.rest.clone());
  }

  /**
   * Does: merges a sentence.
   *
   * @return - a String.
   */
  @Override
  public Sentence merge(Sentence secondSentence) {
    return new WordNode(this.word, this.rest.merge(secondSentence));
  }
}
