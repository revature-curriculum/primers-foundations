# Binary Search
Were you able to implement a Binary Search? 

If yes, then great! 

If not, do not worry. In this section, we go more in-depth.


As stated before, there are multiple ways of doing a Binary Search. There is the **Iteration Method** and the **Recursive Method**. Both approaches use the same "`divide and conquer`" ideology but have different time complexity making one faster than the other. Binary Search through a Recursive Method would have a time complexity of `O(log n)`, while an Iterative approach would equal `O(n)`. This makes the Iterative Method **more efficient** than a Recursive Method.

## Iterative Approach
To review, here is the pseudo-code of an Iterative approach, provided in the previous section:
``` java
    binarySearch(arr, x, first, last)
        repeat till frst = last
               mid = (frist + last)/2
                   if (x == arr[mid])
                   return mid
   
                   else if (x > arr[mid]) // x is on the right side
                       first = mid + 1
   
                   else                  // x is on the left side
                       last = mid - 1
```
Here we conduct all of our logic within one method, `binarySearch()`. Our method's parameters are the array we are searching in (`arr`), the value we are searching for (`x`), the lowest/first element in the array (`first`), and the highest/last element in the array (`last`).

- First, we want to create a loop that would iterate through the array until we find the element with the same value we are searching for or until the search finishes. We can do this with a `while` loop that contains a boolean condition that will flip once we find a match or iterate through the end of the list.

- Next, we want to make the method split the list into two at the *middle* element, `mid`. We will sum the *first* and *last* indexes and divide them by 2. This will then equal our `mid` variable. Using the data type `int` will automatically round down for us since an `int` value can not hold decimals.

- Establishing the **middle element** creates two **sub-arrays** on either side of it. The method should first compare the **middle element's value** with the value we are searching for.
    - If they **match**, then we found the element we want, and the method returns the middle element's index.
    - If our element is **greater than** the middle, the method conducts *another search* in the sub-array to the right side. The method should then shift the `first` variable to equal `mid+1`.
    - If **less than**, we search through the sub-array on the left side. The method should shift the `last` variable to equal `mid-1`.

- The method repeats this process of *dividing* the list into smaller and smaller *halves*. Comparing the **middle elements** until it finds a match with the value we are searching for, or once it runs into *an end* to the list.

Here is a diagram to illustrate what is happening:  

![Binary Search](Images/BinarySearch.png)

**Binary Search** does not search through every element of the list. It will section off areas where the element could be and searches there. Hence the reason why this search only works with an ordered list.

## Recursive Approach
Here is the pseudo-code for a Recursive approach:
``` Java
    binarySearch(arr, x, first, last)
            if last >= first
               mid = (first + last) / 2 
                   if x == arr[mid]
                   return mid
       
               else if x > arr[mid]        // x is on the right side
                   return binarySearch(arr, x, mid + 1, last)
               
               else                        // x is on the left side
                   return binarySearch(arr, x, first, mid - 1) 
            else
                return -1
```
Here we reuse our `binarySearch()` method within itself. Using a method within itself in software development is called **Recursion**. We use *Recursion* to make our code look cleaner and sometimes because it can be easier to implement than doing it *Iteratively*.
Our Recursive method will still contain the same parameters as it did in our Iterative approach (`arr` is our array, `x` is the value we are searching for, `first` is the first element of the list and `last` is the last element of the list). 

- First, we need to establish a condition statement to tell the method to continue to search through the list or to stop because we have reached an end. Above, in the pseudo-code, we compared the last element's index with the first element's index.
    - If `last >= first`, the method continues to search for the element.
    - Else, `first > last`, the method concludes that we have reached an end to the list and will return a value that means the element "does not exist." In this case, the method will return `-1`.

- If `last >= first`, we move forward with *dividing and conquering* as we did in the iterative method. The method should divide the sum of the first and last index in half and have it equal our `mid variable. We divided our array into two sub-arrays, as we did in the iterative approach.

- The method then compares the middle element's value with what we are searching for, `x`.
    - If they **match** (`if x == arr[mid]`)then the method returns the index of the middle element.
    - If they do **not match**, then the method **calls itself**, respective of what side of a condition it meets.

- If you notice above, in the pseudo-code, there is an `if else` statement within an `if else` statement. The outer `if else` determines if we continue the binary search or not, while the inner `if else` determines whether to: return `mid`, search the left side or search the right side of the array.
    - If `x > arr[mid]`, we want to search the **right** of the list. Thus, the method will call `binarySearch(arr, x, mid + 1, last)`. We insert `mid + 1` in place of the parameter `first` so that the method searches to the **right**.
    - Else, `x < arr[mid]`, we want to search the **left** of the list. Thus, the method will call `binarySearch(arr, x, first, mid - 1)`. We insert `mid - 1` in place of the parameter `last` so that the method searches to the **left**.

- Once the **Recursion** occurs, the method will continue to call itself, return a value, or stop searching respective of which condition it meets. All this without ever implementing a `while` or `for` loop.

## Code Samples
### Iterative Solution: Java
``` Java
//Method returns an int value
public static int binarySearch(int arr[], int x, int first, int last){
    while(frist <= last){
        int mid = first + (last - first) / 2; //'(last - first)' putting this in place of just 'last' will pervent integer overflow

        if(arr[mid] == x)
            return mid;

        else if(arr[mid] < x)
            first = mid - 1;
        
        else // if(arr[mid] > x)
            last = mid - 1;
    }
    return -1;
}
```
### Recursive Solution: Java
``` Java
//Method returns an int value
public static int binarySearch(int arr[], int x, int first, int last){
    
    if(last >= first){
        int mid = first + (last - first) / 2; //'(last - first)' putting this in place of just 'last' will pervent integer overflow

        if(arr[mid] == x) //found the element
            return mid;

        else if(arr[mid] > x)
            return binarySearch(arr, x, first, mid-1); //seaches left side

        else //if (arr[mid] < x)
            return binarySearch(arr, x, mid + 1, last); //seaches right side
    }
    else
        return -1; //-1 means the element was not found
}
```
#### Here are some sources for further reading:
- [Geeks for Geeks](https://www.geeksforgeeks.org/binary-search/)
- [Recursion: A Quick Guide for Software Engineers](https://www.educative.io/blog/recursion)
- [Java Recursion - How to make Recursive Methods](https://www.youtube.com/watch?v=sE0sH8vSmE4)
- [Algorithms: Binary Search](https://www.youtube.com/watch?v=P3YID7liBug)
- [Binary Search - Recursive implementation](https://www.youtube.com/watch?v=-bQ4UzUmWe8)