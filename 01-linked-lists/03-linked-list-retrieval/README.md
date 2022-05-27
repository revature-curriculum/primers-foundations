# Retrieval

When discussing the retrieval of data from a linked list, we typically still refer to elements by their index. However, a Linked List does not have a true index relationship to the elements like there would be with an array or an ArrayList. We can **still** consider an element's location in the Linked List as their index, starting from 0. Therefore, our **head** Node would be at index 0, and our **tail** Node would be at the last index (*length of the list minus one, since arrays starts at index 0*).

In order to physically **retrieve** the data, we must **iterate** through the list `n` spaces, where `n` is equal to the **desired index**. Once we reach the desired index, it is as simple as returning the data contained within the node at that location. The retrieval function is called `get`, which, in many languages and implementations, can be **overloaded** to accept different types of parameters, and not  just the index.

Here is a visual repesentation of how retrival of a node is done:

![insertion-3](https://revature-curriculum.s3.amazonaws.com/primers/primers-foundations/linked-list/insertion-3.png)
Assume that we have the same four node list from earlier as seen above

![indices](https://revature-curriculum.s3.amazonaws.com/primers/primers-foundations/linked-list/indices.png)
Since our primary retrieval will be **index** based, we should now consider the indices for the list, *remembering to start from 0*.

As we can see from the diagram above, we are able to retrive 4 different nodes with indecies 1 - 3. If the `get` method was called with a provided parameter of 2 (`get(2)`), the retrieval would be as follows:
- Begin with the *starting node* of the list, the `head`, which is at index `0` and contains a reference for the `next` node.
- Initialize a loop to iterate `n` times (`n = 2` in this case)
  `for(int i=0; i < n; i++){}`
- In the body of the loop, progress the *pointer* with each iteration.
	- re-assign our current node (*starting with index `0`*) with the value of the `next` node.
	  `current = current.next;`
	- If our loop is set to iterate two times, we will call `next` two times, and thus end on the third item in the list at index `2`.
- Once we are at the desired location, we return the data value stored within the node.
  `return current.data;`

Here's how this operation might look in Java code:
```java
// n represents the index
public T get(int n){
        
        //store the current head node in a local variable
        Node<T> current = head;

        //begin a loop that should iterate n number of times with n being the index
        for(int i=0; i < n; i++){
            // for each iteration, 'move' the pointer by reassigning our current node with the value of current.next which should be the next node in the list
            current = current.next;
        }
        //once the loop has finished iterating, we know that the current node should hold our desired data, so we return current.data
        return current.data;
}
```

## Exceptions
The above implementation is fairly basic and is not protected against any user error if the method were to be called with an index that is outside of the range of our list. For example, if our list only had four elements,  the method being called with any value higher than 3 would end up with a `NullPointerException` as our loop continued and tried to call either `next` or `data` on a `null` value.

Similarly, if the method is called with a **negative** value, our loop would **never iterate** to begin with, thus leading us to return the value of the head node. In this case, we wouldn't get an explicit exception to let us know something is wrong, instead we would just have undesired functionality. 

For these reasons, we would likely want to have a check against the provided index before the loop iterates just to make sure that it falls within the bounds of the list.

