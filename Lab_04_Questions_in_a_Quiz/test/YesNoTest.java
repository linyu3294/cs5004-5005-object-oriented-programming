import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test Class for AbstractQuestionTest.
 */
public class YesNoTest extends AbstractQuestionTest {

  @Override
  public AbstractQuestion getObject(String question, boolean isRequired) {
    return new YesNo(question, isRequired);
  }

  @Test
  public void validAnswerTest1() {
    question2.answer("Yes");
    assertEquals("Yes", question2.getAnswer());
  }

  @Test
  public void validAnswerTest2() {
    question2.answer("No");
    assertEquals("No", question2.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAnswerTest1() {
    question2.answer("popeyes");
    assertEquals("popeyes", question2.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAnswerTest2() {
    question2.answer("Hungry");
    assertEquals("Hungry", question2.getAnswer());
  }


}