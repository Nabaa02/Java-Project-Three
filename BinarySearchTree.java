/**
 * @author Nabaa Khan
 * Class that represents a binary search tree
 */
public class BinarySearchTree{
  
  //Stores the root
  private BSTNode root;
  
  /**
   * Creates binary search tree
   * @param root of the tree
   */
  public BinarySearchTree(){
    root = null;
  }
  
   /**
   * Retrieves the root of the tree
   * @return the root of the tree
   */
  protected BSTNode getRoot(){
    return root;
  }
  
  /**
   * Sets the root of the tree
   * @param the root of the tree
   */
  protected void setRoot(BSTNode node){
    root = node;
  }
  
  /**
   * Inserts node in binary search tree
   * @param the root of the tree
   * @param the key is the key of the node to be inserted
   * @return node that was inserted
   */
  public BSTNode insert(BSTNode root, int key){
    //create node to insert
    BSTNode node = new BSTNode(key);
    //if root is null, root is the inserted node
    if(root == null){
      root = node;
      //return root
      return root;
    }
    else{
      //create previous node
      BSTNode prev = null;
      //create temporary node to traverse through tree
      BSTNode temp = root;
      //iterate as long as temp is not null
      while(temp != null){
        //if temp's node is greater than key, go left
        if(temp.getData() > key){
          prev = temp;
          temp = temp.getLeft();
        }
        //if temp's node is less than key, go right
        else if(temp.getData() < key){
          prev = temp;
          temp = temp.getRight();
        }
      }
      //if prev's node is greater than key, set prev's left node to be inserted node
      if(prev.getData() > key){
        prev.setLeft(node);
        return prev.getLeft();
      }
      else{
        //if prev's node is less than key, set prev's right node to be inserted node
        prev.setRight(node);
        return prev.getRight();
      }
    }
  }
  
  /**
   * Performs inorder traversal of the binary search tree
   * @param the root of the tree
   * @return String format of the binary search tree
   */
  public String inOrder(BSTNode root){
    //initialize String result 
    String result = "";
    //if root's left node is not null, print node 
    if(root.getLeft() != null){
      result += inOrder(root.getLeft());
    }
    //print root
    System.out.println(root.getData());
    //if root's right node is not null, print node
    if(root.getRight() != null){
      result += inOrder(root.getRight());
    }
    //return String result
    return result;
  }
  
  /**
   * Finds sum of all the keys of the binary search tree
   * @param the root of the tree
   * @return sum of the binary search tree 
   */
  public int sum(BSTNode root){
    //if root is null, return 0 as the sum
    if(root == null){
      return 0;
    }
    else{
      //otherwise, return root plus sum of the left subtree and the sum of the right subtree
      return (root.getData() + sum(root.getLeft()) + sum(root.getRight()));
    }
  }
  
  /**
   * Search a node with a specific key in the binary search tree
   * @param the root of the tree
   * @param the key is the key to be searched for
   * @return node that was searched for
   */
  public BSTNode search(BSTNode root, int key){
    //set temp to traverse through tree starting from the root
    BSTNode temp = root;
    //iterate as long as temp is not null
    while(temp != null){
      //if key is equal to temp's node, return temp
      if(key == temp.getData()){
        return temp;
      }
      else{
        //if key is less than temp's node, traverse left
        if(key < temp.getData()){
          temp = temp.getLeft();
        }
        else{
          //otherwise, traverse right
          temp = temp.getRight();
        }
      }
    }
    return null;
  }
  
  /**
   * Finds the kth smallest element in the binary search tree
   * @param the root of the tree
   * @param the kth element to search for
   * @return the kth element 
   */
  public BSTNode kthSmallest(BSTNode root, int k){
    //if root is null, return null
    if(root == null){
      return null;
    }
    else{
      //otherwise, set root's left node to run through the method again on the left side of the tree
      root.setLeft(kthSmallest(root.getLeft(), k));
      //if root's left node is not null, return root's left node
      if(root.getLeft() != null){
        return root.getLeft();
      }
      //intitialize temp to be 0
      int temp = 0;
      //increment temp
      temp++;
      //if temp is equal to k, return root of tree
      if(temp == k){
        return root;
      }
      else{
        //otherwise, run method agaon on the right side of the tree
        return kthSmallest(root.getRight(), k);
      }
    }
  }
  
  /**
   * Helper method of the delete method; finds minimum value of the tree
   * @param the root of the tree
   * @return minimum value of the tree
   */
  public int deleteHelper(BSTNode root){
    //initialize minimum value to start at root
    int minValue = root.getData();
    //iterate as long as root's left node is not null
    while(root.getLeft() != null){
      //minimum value will be tree's left-most node 
      minValue = root.getLeft().getData();
      //continue to traverse leftwards
      root = root.getLeft();
    }
    //return minimum value of the tree
    return minValue;
  }
  
  /**
   * Deletes a node from the binary search tree
   * @param the root of the tree
   * @param the key is the key to be deleted
   * @return node to be deleted
   */
  public BSTNode delete(BSTNode root, int key){
    //if root is null, return root
    if(root == null){
      return root;
    }
    //if key is less than root's node, set root's left node to run through the method again on the left side of the tree 
    if(key < root.getData()){
      root.setLeft(delete(root.getLeft(), key));
    }
    //if key is greater than root's node, set root's right node to to run through the method agaon the right side of the tree
    else if(key > root.getData()){
      root.setRight(delete(root.getRight(), key));
    }
    else{
      //if root's left child is not null, return root's right child
      if(root.getLeft() != null){
        return root.getRight();
      }
      //if root's right child is not null, return root's left child
      else if(root.getRight() != null){
        return root.getLeft();
      }
      //set root to run through helper method
      root.setData(deleteHelper(root.getRight()));
      //set root's right node to run through the method agaon on the right side of the tree
      root.setRight(delete(root.getRight(), root.getData()));
    }
    //return the root
    return root;
  }
}