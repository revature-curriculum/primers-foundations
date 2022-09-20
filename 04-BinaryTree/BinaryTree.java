
public class BinaryTree{
    private TreeNode root = null;
    private int size = 0;

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void add(int data){
        TreeNode tempRoot = this.root;
        TreeNode node = new TreeNode(data);

        if(tempRoot == null){
            this.root = node;
            this.size++;
            return;
        }

        while(true){
            if(node.data == tempRoot.data) return;

            if(node.data < tempRoot.data){      // go left
                if(tempRoot.left == null){      // no left exists yet
                    tempRoot.left = node;
                    this.size++;
                    return;
                }
                // a left exists, continue the loop
                tempRoot = tempRoot.left;
                continue;
            } else {                            // go right
                if(tempRoot.right == null){     // no right exists yet
                    tempRoot.right = node;
                    this.size++;
                    return;
                }
                // a right exists, continue the loop
                tempRoot = tempRoot.right;
                continue; 
            }
        }
    }

    public void delete(int data){
        // Find the node
        // we reassign root here just in case the node to delete is root
        // if root is not the node, it remains unchanged
        this.root = this.deleteNode(this.root, data);
    }

    private TreeNode deleteNode(TreeNode current, int data){
        // null check for current
        if(current == null) return current;

        // If the node is found
        if(current.data == data){
            // AND has no children
            if(current.left == null && current.right == null){ 
                // delete the node
                return null;
            } 
            // OR has one child
            //  replace the node with the existing child
            else if(current.left == null){
                return current.right;
            } 
            else if(current.right == null){
                return current.left;
            }
            // OR has two children
            //  choose either the inorder predecessor or successor to replace
            else {
                // for inorder successor, get the smallest in the right subtree
                TreeNode temp = smallestNode(current.right);
                // assign the value of the successor to current
                current.data = temp.data;
                // delete the inorder successor since we're moving it up in the tree
                current.right = this.deleteNode(current.right, temp.data);
                return current;
                
            }
        } else if(current.data > data){     // go left
            current.left = this.deleteNode(current.left, data);
            return current;
        } else {                            // go right
            current.right = this.deleteNode(current.right, data);
            return current;
        }
    }

    private TreeNode smallestNode(TreeNode node){
        while(node.left != null) node = node.left;
        return node;
    }

    public void print(){
        printTree(this.root, 0);
    }

    private void printTree(TreeNode root, int space){
        if(root == null) return;

        space += this.size;
        printTree(root.right, space);

        String spaces = "";
        for(int i = this.size; i<space; i++) spaces += " ";

        System.out.println(spaces + root.data);
        printTree(root.left, space);
    }


    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(6);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(7);
        tree.add(5);
        tree.add(9);
        tree.add(16);
        tree.add(13);
        tree.add(12);
        tree.add(14);
        tree.add(11);
        tree.add(18);
        tree.add(17);
        tree.add(15);
        tree.add(19);
        tree.delete(10);
        tree.print();
    }
}