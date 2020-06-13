/**
 * This is a Class that represents an Essay Questions type.
 */
public abstract class AbstractQuestion implements Questionnaire {
  protected String questionText;
  protected boolean status;
  protected String answer;

  /**
   * This is a constructor for Abstract Question object.
   *
   * @param questionText - A string required by a Question object.
   * @param status - a string defines optional or required status.
   */
  public AbstractQuestion(String questionText, boolean status) {
    this.questionText = questionText;
    this.status = status;
    this.answer = "";
  }

  @Override
  public String getQuestionText() {
    return this.questionText;
  }

  @Override
  public boolean optional() {
    return this.status;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }


}