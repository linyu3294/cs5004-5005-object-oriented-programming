import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This is a Test Class for WordNode Class.
 */
public class WordNodeTest {
  private Sentence sentence1;
  private Sentence sentence2;
  private Sentence sentence3;

  @Before
  public void setUp() {
    sentence1 = new WordNode("hey",
            new WordNode("Yulin",
                    new EmptyNode()));

    sentence2 = new WordNode("hello",
            new PunctuationNode(";",
                    new WordNode("world",
                            new EmptyNode())));

    sentence3 = new WordNode("I",
            new WordNode("CS",
                    new WordNode("Says",
                            new WordNode("AlexPoop",
                                    new WordNode("Pho",
                                            new PunctuationNode(".",
                                                    new EmptyNode()))))));
  }

  @Test
  public void getNumberOfWordsTest1() {
    assertEquals(2, sentence1.getNumberOfWords());
  }

  @Test
  public void getNumberOfWordsTest2() {
    assertEquals(2, sentence2.getNumberOfWords());
  }

  @Test
  public void getNumberOfWordsTest3() {
    assertEquals(5, sentence3.getNumberOfWords());
  }

  @Test
  public void longestWordTest1() {
    assertEquals("Yulin", sentence1.longestWord());
  }

  @Test
  public void longestWordTest2() {
    assertEquals("hello", sentence2.longestWord());
  }

  @Test
  public void longestWordTest3() {
    assertEquals("AlexPoop", sentence3.longestWord());
  }

  @Test
  public void toString1() {
    assertEquals("hey Yulin.", sentence1.toString());
  }

  @Test
  public void clone1() {
    assertEquals("hey Yulin.", sentence1.clone().toString());
  }

  @Test
  public void clone2() {
    assertEquals("hello;world.", sentence2.clone().toString());
  }

  @Test
  public void clone3() {
    assertEquals("I CS Says AlexPoop Pho.", sentence3.clone().toString());
  }

  @Test
  public void merge() {
    Sentence sentence3 = sentence1.merge(sentence2);
    assertEquals("hey Yulin.hello;world.",sentence3);
  }
}