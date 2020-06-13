/**
 * This is a Class that represents an YesNo Questions type.
 */
public class YesNo extends AbstractQuestion {

  YesNo(String questionText, boolean status) {
    super(questionText, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (!answer.equals("Yes") && !answer.equals("No")) {
      throw new IllegalArgumentException("Answer has to be \"Yes\" or \"No\"");
    } else {
      this.answer = answer;
    }
  }
}
