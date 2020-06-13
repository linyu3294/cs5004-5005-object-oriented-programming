/**
 * This is a Interface used to implement different types of questions.
 */
public interface Questionnaire {
  /**
   * Method getQuestionText that returns the question.
   *
   * @return a string that represents the question.
   */
  String getQuestionText();

  /**
   * Method return either required or optional.
   *
   * @return a string that represents the the status of a question.
   */
  boolean optional();

  /**
   * Allows one to enter an answer as a String for a question.
   *
   * @param answer -a string that represents the answer.
   */
  void answer(String answer);

  /**
   * Allows one to get an answer as a String for a question.
   *
   * @return answer -a string that represents the answer.
   */
  String getAnswer();
}
