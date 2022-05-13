## Deletion

Deletion operations for a linked list will combine many of the ideas from the insertion and retrieval sections. For instance, just like with retrieval, we will need to iterate to find the desired element by either it's index, or in a different case, it's actual data value. Once we locate the desired node we essentially will complete the same steps as insertion, just in reverse. This idea can be adjusted based on if you're deleting from the front, middle, or end of the list.

### Deletion of Tail Node

Let's begin by taking a look at a diagram depicting a deletion operation from the end of the list as we showcase similar steps to insertion in reverse. As a reminder, here were our steps for inserting at the end of the list:

- Create a new Node to house our data
- Point our new node's 'next' to null to signify that it is at the end of the list
- Point our previous tail's 'next' to our new node
- Change our tail variable to hold the new node

<img src="./images/deletion-0.png">

Firstly, we need to undo the last step in the steps above by updating our tail. We do this by changing the tail variable to hold the node that comes just before the last node. This can be a bit tricky to do in a singly linked list (a list that is only linked in one direction) as we will need to traverse until we find a node who's 'next' is equal to our tail node and then change the tail to hold the value of this node instead. In a doubly linked list (a list that is linked in two directions) it would be much easier as in addition to a 'next', every node would also have a 'previous'.
<img src="./images/deletion-1.png">

Next, we know that our new tail is not really the tail at all, since it's 'next' still points to our previous tail and thus does not signify the end of the list. In order to undo this, we can simply bypass the previous tail by pointing our new tail's 'next' to null.

<img src="./images/deletion-2.png">

You might be wondering how we go about undoing the next step, where we created the node to begin with. The truth is, we don't need to formally 'delete' anything in most cases. When we changed the new tail to point to null instead of the old tail, we 'dereferenced' the old tail node. Dereferencing is a fancy way of saying that there is no longer any reference to the object in memory. When this happens in Java and some other languages, the object will be automatically deleted if there are no other references to it in the program. This is a process known as Garbage Collection and is a big selling point for Java as a language.

Once our method finishes executing, our dereferenced object will be garbage collected, removing it from memory altogether, and we will have fully completed our deletion operation.

Here's a look at how deleting from the end of a linked list might be implemented in Java code.

<img src="./images/tail-deletion-example.png">

### Deletion by Index or Value

We won't always have the luxury of deleting at either the start or the end of the list. In the majority of cases, a deletion from somewhere near the middle of the list will be required. For this operation, the steps get a bit more complicated as we will need to keep track of a number of nodes to essentially bypass the node that is to be deleted, once again making use of dereferencing to allow garbage collection to free up memory for the removed node. Whether we are deleting by index, or deleting by value, the steps are relatively similar and both involve traversal of the list.

As before, lets first see how a deletion by index looks in a diagram:

<img src="./images/index-deletion-0.png">
Our first step in analysis is once again to make note of the index values for the list elements. In this example, we will delete the node at index 2, or the third item in the list.

As with the previous example, we must once again iterate to the correct location in the list. However, just as before, we need to stop one node short so that we can work with it. In this case, we will iterate up to the desired index-1 and mark it with a local variable called current.

<img src="./images/index-deletion-1.png">

Once we have our current node, we need to bypass the next node to dereference it. In order to do this, we essentially need our current node's 'next' to be pointing to the 'next' of the next node, so we can utilize some chained calls with an operation such as current.next = current.next.next.

<img src="./images/index-deletion-2.png">

Once we reassign the next of the current node, the node to be deleted has been dereferenced and will be collected upon the exit of the method completing our deletion operation.

<img src="./images/index-deletion-3.png">

Here is a look at the operation in Java code:

<img src="./images/index-deletion-example.png">