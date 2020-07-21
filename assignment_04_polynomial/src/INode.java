/**
 * This is a Interface that represents a Node.
 */
public interface INode {
  /**
   * Sets the pointer to the previous node.
   *
   * @param node - input node.
   */
  void setPrevious(INode node);

  /**
   * Sets the pointer to the next node.
   *
   * @param node - input node.
   */
  void setNext(INode node);

  /**
   * Gets the pointer to the previous node.
   *
   * @return - input node.
   */
  INode getPrevious();

  /**
   * Gets the pointer to the Next node.
   *
   * @return - input node.
   */
  INode getNext();

  /**
   * Gets the term of the current node.
   *
   * @return - the current term.
   */
  ITerm getTerm();
}
