/******************************************************************************

BST Methods/Operations with descriptions:
	
   Insert: Add an element to the BST by not violating the BST properties.
   Delete: Remove a given node from the BST. The node can be the root node, non-leaf, or leaf node.
   Search: Search the location of the given element in the BST. This operation checks if the tree contains the specified key.
   InOrder: Outputs the tree as follows-
      Items to the left of root
      Root
      Items to the right of root


Below is the empty BinarySearchTree class. The implementation is as follows:

Within the BinarySearchTree class is a subclass Node defined as:

class Node { 
        int key; 
        Node left, right; 
}

An object instantiated from the BinarySearchTree class consists (publicly) as follows:
  Member:
    Node root
  Methods:
    void insertKey(int)
    void deleteKey(int)
    boolean search(int)

******************************************************************************/



class BinarySearchTree {

    //node class that defines Binary Tree node
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    // BinarySearchTree root node 
    Node root; 
  
   // Constructor for BinarySearchTree =>initial empty tree
    BinarySearchTree(){ 
        root = null; 
    } 
  
    //delete a node from BinarySearchTree
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    //recursive delete function
    Node delete_Recursive(Node rt, int key)  {
    // 
    // Insert recursive deletion code here
    //
        return rt; 
    } 
   
    // insert a node in BinarySearchTree 
    void insertKey(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    Node insert_Recursive(Node rt, int key) { 
    //
    // Insert recursive insertion code here
    //
        return rt; 
    } 
 
// method for inorder traversal of BinarySearchTree 
    void inorder() { 
        inorder_Recursive(root); 
    } 
   
    // recursively traverse the BinarySearchTree  
    
    void inorder_Recursive(Node root) { 
    //
    // Insert Recursive inorder code here
    //
    } 
     
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive search function
    Node search_Recursive(Node rt, int key)  { 
    //
    // Insert Recursive Search code here
    //      
      return rt;
    } 
}
class Main{
    public static void main(String[] args)  { 

    }
}