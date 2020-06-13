import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test Class for AbstractQuestionTest.
 */
public class LikertTest extends AbstractQuestionTest {

  @Override
  public AbstractQuestion getObject(String question, boolean isRequired) {
    return new Likert(question, isRequired);
  }

  @Test
  public void answerTest1() {
    question1.answer("Agree");
    assertEquals("Agree", question1.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAnswerTest1() {
    question1.answer("Banana");
    assertEquals("", question1.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAnswerTest2() {
    question2.answer("Sugoi");
    assertEquals("", question2.getAnswer());
  }

}