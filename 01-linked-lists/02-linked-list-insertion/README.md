## Insertion

The Insertion operation is the act of inserting (or adding) a new element to the list. We can insert data in several ways depending on the needs of the data structure. A few operations we will discuss are as follows:

- Inserting to the End of an Unordered Linked List
- Inserting to the Front of an Unordered Linked List
- Inserting to the Middle of an Ordered Linked List

### Inserting to the End of an Unordered Linked List

In an unordered linked list (not sorted), adding to the end of the list is as simple as creating a new Node object to contain the data, setting its 'next' variable to point to null, and updating the current tail node to point to our new tail node. Here is a diagram of the operation:

![inserion-1](../images/insertion-1.png)

In the diagram above, we can see that a new Node object has been created, but it is currently floating in space and is not linked within our list. Our next step is to point our new node, Node D, to null to signify that it does not have a 'next' element.
![insertion-2](../images/insertion-2.png)
In this diagram, we have made the changes and have assigned the 'next' variable of Node D to null, however, we still don't have a way to actually reach Node D. For that, we need to access our tail node from earlier. If we were actually referencing code here, we would likely have a Node variable on the LinkedList class called 'tail' that currently contains the Node C object. We can update Node C's 'next' variable to point to our newly created Node D.
![insertion-3](../images/insertion-3.png)
Here we can see that Node C now points to Node D as next in the list. Once again if we were actually writing code here, we would want to update the 'tail' variable on our LinkedList class so that it accurately holds Node D as our new tail.

Here's how the operation would look in java code:

```java
// adds a new element to the end of the list

public void add(T newData){
      // construct the new node object
      Node<T> newNode = new Node<>;

      //assign the data for the new node
      newNode.data = newData;

      // point the previous tail node's next to point to the new node
      // only do this if the size is greater than 0
      // if the size is 0, then this operation would lead to a NullPointerException because our tail is initialized to null
      if(size > 0){
         tail.next = newNode;
      }
      // reassign the 'tail'to point to our new node
      tail = newNode;

      // increment the size
      size++;
}
```

In many cases, it is advised to keep track of the current size of the list to make your job a bit easier with many operations that we will uncover throughout this guide. Maintaining the size is as easy as ensuring that for any insertion or deletion operation, you make sure to increment or decrement the size respectively.

Now that we have demonstrated adding to the end of an unordered list, lets discuss how we might go about designing the insertion operation to support a couple of different use cases.

#### Inserting to the Front of an Unordered Linked List

Inserting to the front of the list is just as simple as our previous example. We start with the same step of creating a new Node object.
![NewHeadNode](../images/NewHeadNode.png)
Then, instead of pointing to `null`, to signify that it is at the end of the list, we must point the new node to the current 'head', Node A. 
After we make that change, similar to how we updated the 'tail' variable on the LinkedList class in the previous example, this time we must update the 'head' variable to point to our newly created node as the new first element in the list.
![NewHeadNode2.png](../images/NewHeadNode2.png)

#### Inserting in an Ordered Linked List

An ordered linked list complicates our operation quite a bit. Because the list is sorted, we must take into account that adding to the end of the list will likely not be an appropriate location for our new node. Instead, we must traverse through our list, comparing the values of existing nodes to our new node in order to determine the correct location to insert. Lets outline the steps below to sort a list in order from smallest to largest:

1. Create our new Node object to hold our data
![OrderedNodeInsert](../images/OrderedNodeInsert.png)
2. Begin our traversal by comparing our new node to the current 'head' node:
![OrderedNodInsert2](../images/OrderedNodeInsert2.png)
   - If our new node is smaller than the head node, our new node should become first in the list so we simply repeat the operation for inserting in the front of the list as outlined above.
   - If our new node is larger than the head node, we need to continue our traversal by grabbing the next node and repeating the comparison until we either find a condition where our new node is smaller, or we reach the end of the list.
![OrderedNodeInsert3](../images/OrderedNodeInsert3.png)
      - If we reach the end of the list (where `next` is `null`), perform the operation to insert at the end of the list as listed above.
      - If we find a location to insert that is not at the front of the list, reference step 3 for the operation to insert in the middle of the list.

3. In order to insert in the middle of the list, a few things must occur to keep everything linked. Lets assume we are inserting a new node, Node D, between Node B, and Node C:
![OrderedNodeInsert4](../images/OrderedNodeInsert4.png)
   - Node D will be before Node C, so we must point the `next` variable on Node D to point to Node C.
![OrederedNodeInsert5](../images/OrderedNodeInsert5.png)
   - Node D will be after Node B, so we must point the 'next' variable on Node B to point to Node D.
![OrderedNodeInsert6](../images/OrderedNodeInsert6.png)

In theory, this insertion operation can seem relatively straight forward, but as we'll see in our later code examples, there are several things to consider to accomplish this implementation.