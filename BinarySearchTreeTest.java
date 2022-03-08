/**
 * @author Nabaa Khan
 * Test class for BinarySearchTree class
 */
public class BinarySearchTreeTest{
  public static void main(String[] args){
   
    //instantiate binary search tree
    BinarySearchTree bst = new BinarySearchTree();
    
    //insert elements into BST
    bst.setRoot(new BSTNode(3));
    bst.insert(bst.getRoot(), 4);
    bst.insert(bst.getRoot(), 8);
    bst.insert(bst.getRoot(), 12);
    bst.insert(bst.getRoot(), 20);
    bst.insert(bst.getRoot(), 33);
    
    //tests insert() and inOrder() methods
    System.out.println("Binary Search Tree: " + bst.inOrder(bst.getRoot()));
    
    //tests sum() method
    System.out.println("Sum of the BST is: " + bst.sum(bst.getRoot()));
    
    //tests search() method
    System.out.println("Is 33 in the BST? " + bst.search(bst.getRoot(), 33));
    System.out.println("Is 10 in the BST? " + bst.search(bst.getRoot(), 10));
    
    //tests kthSmallest() method
    System.out.println("The 3rd smallest element is: " + bst.kthSmallest(bst.getRoot(), 3));
    System.out.println("The 5th smallest element is: " + bst.kthSmallest(bst.getRoot(), 5));
    
    //tests delete() method
    bst.deleteHelper(bst.getRoot());
    bst.delete(bst.getRoot(), 12);
    System.out.println("Delete 12: " + bst.inOrder(bst.getRoot()));
    bst.deleteHelper(bst.getRoot());
    bst.delete(bst.getRoot(), 5);
    System.out.println("Delete 5: " + bst.inOrder(bst.getRoot()));
  }
}