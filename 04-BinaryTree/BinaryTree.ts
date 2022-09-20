class TreeNode{
    data: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(data: number){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


class BinaryTree{
    root: TreeNode | null;
    size: number;
    constructor() { 
        this.root = null;
        this.size = 0;
    }


    add(data: number){
        let tempRoot = this.root;
        let node = new TreeNode(data);

        // Check if root is null
        if (!tempRoot){
            this.root = node;
            this.size++;
            return;
        } 

        // if root is not null, traverse the tree

        while(true){
            if(node.data === tempRoot.data) return;

            if(node.data < tempRoot.data){     // go left
                if(!tempRoot.left){            // no left exists yet
                    tempRoot.left = node;
                    this.size++;
                    return;
                }
                // a left exists, so continue the loop
                tempRoot = tempRoot?.left
                continue;
            } else{                             // go right
                if(!tempRoot.right){            // no right exists yet
                    tempRoot.right = node;
                    this.size++;
                    return;
                }
                // a right exists, so continue the loop
                tempRoot = tempRoot?.right;
                continue;
            }
        }
    }

    delete(data: number){
        // Find the node
        this.root = this.deleteNode(this.root!, data)
    }

    private deleteNode(current: TreeNode, data: number): TreeNode | null{
        // null check for current
        if(!current) return current;

        //  If the node is found
        if(data === current.data){
            //  AND has no children
            if(!current.left && !current.right) return null //  delete the node
            //  OR has one child
            //      replace the node with the existing child
            else if(!current.left) return current.right
            else if(!current.right) return current.left
            //  OR has two children
            //      choose either its inorder predecessor or successor to replace the node
            else{
                //      for inorder successor, get the smallest in the right subtree
                let temp = this.smallestNode(current.right);
                //      assign the value of the inorder successor to the current node
                current.data = temp.data
                //      delete the inorder successor
                current.right = this.deleteNode(current.right, temp.data)
                return current;
            }
        } else if(data < current.data){     // go left
            current.left = this.deleteNode(current.left!, data)
            return current;
        } else{                             // go right
            current.right = this.deleteNode(current.right!, data)
            return current;
        }
    }

    private smallestNode(node: TreeNode){
        while(node.left) node = node.left
        return node;
    }

    // traverse the tree and print
    print(){
        this.printTree(this.root!, 0)
    }

    private printTree(root: TreeNode | null, space: number): void{
        if(!root) return;

        space += this.size;
        this.printTree(root.right!, space);

        let spaces = "";
        for(let i=this.size; i<space; i++) spaces += " ";

        console.log(spaces + root.data);
        
        this.printTree(root.left!, space)
    }
}

let tree = new BinaryTree();
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