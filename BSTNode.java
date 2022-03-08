import java.lang.StringBuilder;

/*
 * @author Nabaa Khan
 * A class that implements a Binary Search Tree node
 */
public class BSTNode {
  
  //Stores the data 
  private int data;
  
  //Stores node's left child
  private BSTNode left;
  
  //Stores node's right child
  private BSTNode right;
  
  /**
   * Creates the binary search tree node
   * @param key the data to store in the node
   */
  public BSTNode(int data) {
    this.data = data;
  }
  
  /**
   * Retrieve the data
   * @return the data
   */
  public int getData() {
    return data;
  }
  
  /** 
   * Retrieve the node's left child
   * @return the left child
   */
  public BSTNode getLeft() {
    return left;
  }
  
   /** 
   * Retrieve the node's right child
   * @return the right child
   */
  public BSTNode getRight() {
    return right;
  }
  
  /**
   * Change the data in the node
   * @param the new data to store
   */
  public void setData(int data) {
    this.data = data;
  }
  
  /**
   * Change the root's left child
   * @param the node that should be the root's left child
   */
  public void setLeft(BSTNode node) {
    this.left = node;
  }
  
   /**
   * Change the root's right child
   * @param the node that should be the root's right child
   */
  public void setRight(BSTNode node) {
    this.right = node;
  }
}