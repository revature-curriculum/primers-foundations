## Binary Search Trees:

A binary tree is composed of (at most) three components: A root node, a left node, and a right node.

```
     root
    /    \
  left   right
```

Note: either left, right, or both nodes can be null. In an empty binary tree, all three components (including root) would be null.

A binary search tree (referred to as BST for short) consists of multple binary trees linked together. A numerical example is below:

```
             45 
           /    \ 
          10      90 
         /  \    /   
        7   12  50 
```

Here, 45 is the root of the BST. The values in the subtree to the left of the root
are all less than 45. The values in the subtree to the right of the root are greater
than 45.

**IMPORTANT NOTE:** A Binary Search Tree can **NOT** have duplicate values!  
<br />
<br />

## BST Methods/Operations with descriptions:
- Insert: Add an element to the BST by not violating the BST properties.
- Delete: Remove a given node from the BST. The node can be the root node, non-leaf, or leaf node.
- Search: Search the location of the given element in the BST. This operation checks if the tree contains the specified key.
- InOrder: Outputs the tree as follows
  - Items to the left of root
  - Root
  - Items to the right of root
  - An InOrder output of the example tree above would be: 7, 10, 12, 45, 50, 90
<br />

### Insert An Element In BST
An element is always inserted as a leaf node in BST. Given below are the steps for inserting an element:
- Start from the root.
- Compare the element to be inserted with the root node. If it is less than root, then traverse the left subtree or traverse the right subtree.
- Traverse the subtree till the end of the desired subtree. Insert the node in the appropriate subtree as a leaf node.

### Search Operation In BST
To search if an element is present in the BST, we again start from the root and then traverse the left or right subtree depending on whether the element to be searched is less than or greater than the root.
- Compare the element to be searched with the root node.
- If the key (element to be searched) = root, return root node.
- Else if key < root, traverse the left subtree.
- Else traverse right subtree.
- Repetitively (recursively) compare subtree elements until the key is found or the end of the tree is reached.

### Remove Element From The BST
When we delete a node from the BST, then there are three possibilities as discussed below:
- Node Is A Leaf Node
  - If a node to be deleted is a leaf node, then we can directly delete this node as it has no child nodes.
- Node Has Only One Child
  - When we need to delete the node that has one child, then we copy the value of the child in the node and then delete the child.
- Node Has Two Children
  - When a node to be deleted has two children, then we replace the node with the in-order (left-root-right) successor of the node. 
  - We replace the node with this minimum node and delete the node.


# Instructions:

A BinarySearchTree class is set up in BinarySearchTree.java. The implementation is as follows:

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
    void inOrder(void)

The implementations for insertKey, deleteKey, search, and inOrder are recursive with corresponding internal methods (for example, for insertKey there is an empty method called insert_Recursive). Fill in the recursive code to implement the methods above.

## Testing
Test cases are provided in Replit.