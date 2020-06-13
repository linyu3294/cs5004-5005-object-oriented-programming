/**
 * This is a Class that represents an Essay Questions type.
 */
public class Essay extends AbstractQuestion {

  Essay(String questionText, boolean status) {
    super(questionText, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer.length() > 140) {
      throw new IllegalArgumentException();
    } else {
      this.answer = answer;
    }
  }
}
