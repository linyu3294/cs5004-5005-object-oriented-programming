import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test class for Essay Question Type.
 */
public class EssayTest extends AbstractQuestionTest {

  @Test
  public void answerTest() {
    question2.answer("I had a sausage egg and cheese for breakfast today");
    assertEquals("I had a sausage egg and cheese for breakfast today", question2.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAnswerTest() {
    question2.answer("Many online questionnaire tools like SurveyMonkey, " +
            "Doodle Poll, etc. " +
            "(even Blackboard) allow creating " +
            "a questionnaire made of several types of questions: " +
            "Yes/No, Essay-form, Likert scale, etc. " +
            "In this lab you will write classes that represent different types of questions.\n" +
            "\n" +
            "Each question, irrespective of type, has the following common aspects:\n" +
            "\n" +
            "It has the text of the question itself, " +
            "and a method getQuestionText that returns it.\n" +
            "\n" +
            "It is either required or optional, and has a method that returns its status.\n" +
            "\n" +
            "It has a method answer(String) that allows one to enter an answer as a String. " +
            "What the string contains depends on the type of question.\n" +
            "\n" +
            "The types of questions are:\n" +
            "\n" +
            "YesNo: this can be answered in one of two ways: yes or no. " +
            "answer(String) would accept only \"Yes\" or \"No\" as valid answers.\n" +
            "\n" +
            "Essay: this can be answered in at most 140 characters, including spaces.\n" +
            "\n" +
            "Likert: this can be answered on a fixed, 5-point Likert scale " +
            "(Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree). " +
            "answer(String) would accept only these precise words as valid answers.\n" +
            "\n" +
            "Design the data for the above in a way that captures their similarities " +
            "and accurately represents the relevant data. " +
            "Create these interfaces/classes, and write appropriate constructors " +
            "that allows one to create a question using it. " +
            "Write tests that create and verify various question-type objects.");
    assertEquals("", question2.getAnswer());
  }

  @Test
  public void getAnswerTest() {
    question2.answer("popeyes");
    assertEquals("popeyes", question2.getAnswer());
  }

  @Test
  public void getAnswerTest2() {
    question2.answer("broccoli");
    assertEquals("broccoli", question2.getAnswer());
  }

  @Override
  public AbstractQuestion getObject(String question, boolean isRequired) {
    return new Essay(question, isRequired);
  }
}