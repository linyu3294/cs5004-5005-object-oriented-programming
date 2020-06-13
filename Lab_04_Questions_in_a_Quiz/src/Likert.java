/**
 * This is a Class that represents an Likert Questions type.
 */
public class Likert extends AbstractQuestion {

  public Likert(String questionText, boolean status) {
    super(questionText, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer.equals("Strongly Agree")
            || answer.equals("Agree")
            || answer.equals("Neither Agree nor Disagree")
            || answer.equals("Disagree")
            || answer.equals("Strongly Disagree")
    ) {
      this.answer = answer;
    } else {
      throw new IllegalArgumentException("Answer needs to be one of the following: " +
              "Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree)");
    }
  }
}
