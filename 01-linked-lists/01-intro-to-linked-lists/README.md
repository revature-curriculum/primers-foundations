# Linked Lists

## Introduction

A **_Linked List_** is a linear data structure in which elements are not stored sequentially in memory like arrays, but rather, individual elements contain the memory address of the next element in the list, wherever that may actually be in memory. This notion of holding the memory address of the next element is called a **_pointer_** and is a very common concept to begin to uncover. Before we move on to the logical design of a linked list and the operations it may support, we need for first look at what types of artifacts typically make up a Linked List implementation.

More often than not, a LinkedList class will be composed of not only the parent class, i.e. LinkedList, but also a supporting subclass called a **_Node_**. Objects created from this Node class will serve as the actual elements of our list and in its most basic form must only care for two class variables. The first, and arguably most import piece, is a variable to hold the **_data_** itself. In many languages, we leverage the power of generics to ensure that this LinkedList can store objects of any type that we specify. The next class variable that Node will store will typically be of type Node and will actually contain the next node object in the list (or at least a reference to it). We call this variable **_next_** to denote that it is the next node. Lets take a look at how this concept may look in Java, but keep in mind, this class design is relatively portable and can be quite easily converted to your language of choice.

Now that we have a better understanding of the Node subclass, lets start to logically uncover the inner workings of a Linked List. As mentioned previously, a linked list is a series of nodes that contain references to the next node in the list. That said, a diagram of the flow might look something like this:

```java

public class LinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    class Node<T>  {
        // data is the data to be contained within this element and is of type T. 
        // This symbol is an example of using Generics in Java.
        T data;
    
        // next is the next node in the list. 
        // If next is ever pointing to null, we can assume we are at the end of the list.
        Node<T> next;
    }
```

![linked-lists](../images/linked-list.png)


In this diagram, Node A is referred to as our **_head_** node and is the first node in the list. Every time we wish to iterate through our list from start to finish, the head node will always be our starting point. Once we have our head node object, we can check the data contained within the 'data' variable, and continue moving onward simply by grabbing the next Node (Node B) which is stored in the variable 'next'. We can continue this same series of steps up until the point where we realize that the 'next' variable is actually pointing to null, not another valid node object. At this point, we have reached the end of our list.

One thing to note is that in many implementations of the Linked List class, you will store two nodes of importance. One of which, the head node, we have already discussed, but there is also value in storing a reference to the **_tail_** node, or the last valid node in the list. We'll uncover the usage of the tail node in the next section when we begin to talk about supported operations.

## Linked List Operations

There are many different operations that are important to working with any datastructure that are not exclusive to Linked Lists. A few of these operations that we will discuss are as follows:

- **Insertion** : Adding a new element to the list.
- **Retrieval** : Searching for a specific element within the list.
- **Deletion** : Removing a specific element within the list.

## Examples

[Java example](examples/java/linked-list.java)