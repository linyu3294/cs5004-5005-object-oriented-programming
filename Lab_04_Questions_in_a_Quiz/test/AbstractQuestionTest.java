import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a abstract Test Class for all Question types.
 */
public abstract class AbstractQuestionTest {
  protected Questionnaire question1;
  protected Questionnaire question2;

  public abstract AbstractQuestion getObject(String question, boolean isRequired);

  @Before
  public void setUp() throws Exception {
    question1 = getObject("Describe what you had for Lunch Today?", true);
    question2 = getObject("Describe what your favorite pokemon is?", false);
  }

  @Test
  public void getQuestionTextTest1() {
    assertEquals("Describe what you had for Lunch Today?", question1.getQuestionText());
  }

  @Test
  public void getQuestionTextTest2() {
    assertEquals("Describe what your favorite pokemon is?", question2.getQuestionText());
  }

  @Test
  public void optionalTest1() {
    assertEquals(true, question1.optional());
  }

  @Test
  public void optionalTest2() {
    assertEquals(false, question2.optional());
  }


}