/**
 * This is a class that represents a polynomial node class.
 */
public class PolyNode implements INode {
  private INode previous;
  private ITerm current;
  private INode next;

  /**
   * This is a constructor for the PolyNode.
   *
   * @param term - content of the current node.
   */
  public PolyNode(ITerm term) {
    this.previous = null;
    this.current = term;
    this.next = null;
  }

  /**
   * Sets the next node in relation.
   *
   * @param next - A Node.
   */
  @Override
  public void setPrevious(INode next) {
    this.previous = next;
  }

  /**
   * Sets the previous node in relation.
   *
   * @param previous - A Node.
   */
  @Override
  public void setNext(INode previous) {
    this.next = previous;
  }

  /**
   * Gets the previous node in relation.
   */
  @Override
  public INode getPrevious() {
    return this.previous;
  }

  /**
   * Gets the next node in relation.
   */
  @Override
  public INode getNext() {
    return this.next;
  }

  /**
   * Gets the current node.
   */
  @Override
  public ITerm getTerm() {
    return this.current;
  }

  /**
   * Returns a string that represents the current node.
   */
  @Override
  public String toString() {
    return this.current.toString();
  }
}
