/**
 * This is a Interface for Sentence.
 */
public interface Sentence {

  /**
   * Returns number of Words.
   *
   * @return - an int.
   */
  int getNumberOfWords();

  /**
   * Returns Longest Word.
   *
   * @return - a String.
   */
  String longestWord();

  /**
   * Returns a String that represents a sentence.
   *
   * @return - a String.
   */
  String toString();

  /**
   * clones a sentence.
   *
   * @return - a Sentence.
   */
  Sentence clone();

  /**
   * merges a sentence with another.
   *
   * @return - a Sentence.
   */
  Sentence merge(Sentence secondSentence);
}

