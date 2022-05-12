# Linked Lists

## Introduction

A **_Linked List_** is a linear data structure in which elements are not stored sequentially in memory like arrays, but rather, individual elements contain the memory address of the next element in the list, wherever that may actually be in memory. This notion of holding the memory address of the next element is called a **_pointer_** and is a very common concept to begin to uncover. Before we move on to the logical design of a linked list and the operations it may support, we need for first look at what types of artifacts typically make up a Linked List implementation.

More often than not, a LinkedList class will be composed of not only the parent class, i.e. LinkedList, but also a supporting subclass called a **_Node_**. Objects created from this Node class will serve as the actual elements of our list and in its most basic form must only care for two class variables. The first, and arguably most import piece, is a variable to hold the **_data_** itself. In many languages, we leverage the power of generics to ensure that this LinkedList can store objects of any type that we specify. The next class variable that Node will store will typically be of type Node and will actually contain the next node object in the list (or at least a reference to it). We call this variable **_next_** to denote that it is the next node. Lets take a look at how this concept may look in Java, but keep in mind, this class design is relatively portable and can be quite easily converted to your language of choice.

<img src="./images/node.png"/>

Now that we have a better understanding of the Node subclass, lets start to logically uncover the inner workings of a Linked List. As mentioned previously, a linked list is a series of nodes that contain references to the next node in the list. That said, a diagram of the flow might look something like this:

<img src="./images/linked-list.png"/>

In this diagram, Node A is referred to as our **_head_** node and is the first node in the list. Every time we wish to iterate through our list from start to finish, the head node will always be our starting point. Once we have our head node object, we can check the data contained within the 'data' variable, and continue moving onward simply by grabbing the next Node (Node B) which is stored in the variable 'next'. We can continue this same series of steps up until the point where we realize that the 'next' variable is actually pointing to null, not another valid node object. At this point, we have reached the end of our list.

One thing to note is that in many implementations of the Linked List class, you will store two nodes of importance. One of which, the head node, we have already discussed, but there is also value in storing a reference to the **_tail_** node, or the last valid node in the list. We'll uncover the usage of the tail node in the next section when we begin to talk about supported operations.

## Linked List Operations

There are many different operations that are important to working with any datastructure that are not exclusive to Linked Lists. A few of these operations that we will discuss are as follows:

- **Insertion** : Adding a new element to the list.
- **Retrieval** : Searching for a specific element within the list.
- **Deletion** : Removing a specific element within the list.

## Insertion

The Insertion operation is the act of inserting (or adding) a new element to the list. We can insert data in several ways depending on the needs of the data structure. A few operations we will discuss are as follows:

- Inserting to the End of an Unordered Linked List
- Inserting to the Front of an Unordered Linked List
- Inserting to the Middle of an Ordered Linked List

#### Inserting to the End of an Unordered Linked List

In an unordered linked list (not sorted), adding to the end of the list is as simple as creating a new Node object to contain the data, setting its 'next' variable to point to null, and updating the current tail node to point to our new tail node. Here is a diagram of the operation:

<img src="./images/insertion-1.png"/><br>
In the diagram above, we can see that a new Node object has been created, but it is currently floating in space and is not linked within our list. Our next step is to point our new node, Node D, to null to signify that it does not have a 'next' element.
<img src="./images/insertion-2.png"/><br>
In this diagram, we have made the changes and have assigned the 'next' variable of Node D to null, however, we still don't have a way to actually reach Node D. For that, we need to access our tail node from earlier. If we were actually referencing code here, we would likely have a Node variable on the LinkedList class called 'tail' that currently contains the Node C object. We can update Node C's 'next' variable to point to our newly created Node D.
<img src="./images/insertion-3.png"/><br>
Here we can see that Node C now points to Node D as next in the list. Once again if we were actually writing code here, we would want to update the 'tail' variable on our LinkedList class so that it accurately holds Node D as our new tail.

Here's how the operation would look in java code:

<img src="./images/insertion-example.png">

In many cases, it is advised to keep track of the current size of the list to make your job a bit easier with many operations that we will uncover throughout this guide. Maintaining the size is as easy as ensuring that for any insertion or deletion operation, you make sure to increment or decrement the size respectively.

Now that we have demonstrated adding to the end of an unordered list, lets discuss how we might go about designing the insertion operation to support a couple of different use cases.

#### Inserting to the Front of an Unordered Linked List

Inserting to the front of the list is just as simple as our previous example. We start with the same step of creating a new Node object, however, this time instead of pointing to null to signify that it is at the end of the list, we must point the new node to the current 'head', Node A. After we make that change, similar to how we updated the 'tail' variable on the LinkedList class in the previous example, this time we must update the 'head' variable to point to our newly created node as the new first element in the list.

#### Inserting in an Ordered Linked List

An ordered linked list complicates our operation quite a bit. Because the list is sorted, we must take into account that adding to the end of the list will likely not be an appropriate location for our new node. Instead, we must traverse through our list, comparing the values of existing nodes to our new node in order to determine the correct location to insert. Lets outline the steps below to sort a list in order from smallest to largest:

1. Create our new Node object to hold our data
2. Begin our traversal by comparing our new node to the current 'head' node:
   1. If our new node is smaller than the head node, our new node should become first in the list so we simply repeat the operation for inserting in the front of the list as outlined above.
   2. If our new node is larger than the head node, we need to continue our traversal by grabbing the next node and repeating the comparison until we either find a condition where our new node is smaller, or we reach the end of the list.
      1. If we reach the end of the list (where next is null), perform the operation to insert at the end of the list as listed above.
      2. If we find a location to insert that is not at the front of the list, reference step 3 for the operation to insert in the middle of the list.
3. In order to insert in the middle of the list, a few things must occur to keep everything linked. Lets assume we are inserting a new node, Node D, between Node B, and Node C:
   1. Node D will be before Node C, so we must point the 'next' variable on Node D to point to Node C.
   2. Node D will be after Node B, so we must point the 'next' variable on Node B to point to Node D.

In theory, this insertion operation can seem relatively straight forward, but as we'll see in our later code examples, there are several things to consider to accomplish this implementation.

## Retrieval

When discussing the retrieval of data from a linked list, we typically still refer to elements by their index, despite there not being true a index relationship to the elements like there would be with an array or an ArrayList. However, we can still consider an element's location in the list as their index, starting from 0. Therefore, our head Node would be at index 0, and our tail Node would be at an index equal to the length of the list minus one (to account for the list being indexed at 0).

In order to physically retrieve the data, we must iterate through the list n spaces, where n is the desired index. Once we reach the desired index, it is as simple as returning the data contained within the node at that location. The name for the actual retrieval function is typically called 'get' and in many languages and implementations, can be overloaded to accept different types of parameters instead of just the index.

Lets look at how this retrieval may look in a diagram and then we will follow it up with an implementation in code.

Assume that we have the same four node list from earlier as seen below:

<img src="./images/insertion-3.png">

Since our primary retrieval will be index based, we should now consider the indices for the list, remembering to start from 0.

<img src="./images/indices.png">

As we can see from the diagram above, our four node list has the following indices that we can retrieve: 0, 1, 2 and 3. If the 'get' method was called with a provided parameter of 2, the retrieval would be as follows.

- Begin with the starting node of the list (head), which is at index 0 and contains a reference for the 'next' node.
- Initialize a loop to iterate n number of times (n being 2 in this case)
- In the body of the loop, all we need to do is progress the pointer with each iteration. We do this by re-assigning our current node (which at the beginning of the loop is head) with the value of the 'next' node.
- If our loop is set to iterate two times, we will call 'next' two times, and thus end on the third item in the list at index 2.
- Once we are at the desired location, we return the data value stored within the node.

Here's how this operation might look in Java code:

<img src="./images/retrieval.png">

The above implementation is fairly basic and is not protected against any user error if the method were to be called with an index that is outside of the range of our list. For instance, if our list only had four elements, if the method was called with any value higher than 3, we would end up with a NullPointerException as our loop continued and tried to call either 'next' or 'data' on a null value.

Similarly, if the method is called with a negative value, our loop would never iterate to begin with, thus leading us to return the value of the head node. In the second case, we wouldn't get an explicit exception to let us know something is wrong, instead we would just have undesired functionality. For these reasons, we would likely want to have a check against the provided index before the loop iterates just to make sure that it falls within the bounds of the list.

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

## Examples

[Java example](examples/java/linked-list.java)