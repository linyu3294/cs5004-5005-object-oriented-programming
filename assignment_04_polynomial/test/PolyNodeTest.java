import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Test class for PolyNode.
 */
public class PolyNodeTest {
  private INode node1;
  private INode node2;

  @Before
  public void setUp() throws Exception {
    ITerm term1 = new Term(4, 5);
    node1 = new PolyNode(term1);
    ITerm term2 = new Term(5, 2);
    node2 = new PolyNode(term2);
  }

  @Test
  public void setPrevious() {
    node1.setPrevious(node2);
    assertEquals(" +5x^2", node1.getPrevious().toString());
  }

  @Test
  public void setNext() {
    node1.setNext(node2);
    assertEquals(" +5x^2", node1.getNext().toString());
  }

  @Test
  public void getPrevious() {
    node1.setPrevious(node2);
    assertEquals(" +5x^2", node1.getPrevious().toString());
  }

  @Test
  public void getNext() {
    node1.setNext(node2);
    assertEquals(" +5x^2", node1.getNext().toString());
  }

  @Test
  public void getTerm() {
    assertEquals(" +5x^2", node2.getTerm().toString());
  }

  @Test
  public void toString1() {
    node1.setNext(node2);
    assertEquals(" +5x^2", node1.getNext().toString());
  }
}