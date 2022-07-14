# Binary Search
Were you able to implement a Binary Search? If yes, that is great! If not, do not worry. Here we go more in depth for you.

Like stated before there are multiple ways of doing a Binary Search. There is an Iteration Method, and a Recursive Method. Both of them have different time complexity, hench one is faster than the other. A Binary Search through a Recursive Method would be of time complexity `O(log n)`, as for an Iterative Method time complexity would be `O(n)`. This make the Iterative Method more efficent than a Recursive Method.

To review, here is the pseudo-code of an Iterative appraoch, provided in the previous section:
``` Java
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
Here we conduct all of our logic within one method, `binarySearch()`. Our parameters here are: The array we are searching in (`arr`), the element we are searching for (`x`), the lowest/first value in the array (`first`), and the highest/last value in the array (`last`). 

- First we want to creat a loop that would iterate through the array until we find the element or until the array finihes. We can do this with a while loop that contains a boolean condition that will flip only once we reach the element we are searching for, or the end of the search.

- Next we want to find the middle element of the array. If the array is an even number of elements you will face a decmial value when you divide the array. You will need to round to a whole number, either up or down. This will ensure you get a whole number value for the index of the middle value. 

- Once we established the **middle element**, we created two sub-arrays on either side of it. Then we compare the **middle** with the element we are searching for. If they **match**, then we found the element we want and we `return` the index of the middle element. If our element is **greater than** the middle, we conduct *another search* in the sub-array to the right side. If less than, we search through the left side's sub-array.

- We repeat this process of dividing up the list into smaller and smaller halves and comparing the middle element until we find the element we are searching for or once we run out of elements.



The logic for a Recursive approach would follow as:
``` Java
    binarySearch(arr, x, low, high)
           if low > high
               return False 
   
           else
               mid = (low + high) / 2 
                   if x == arr[mid]
                   return mid
       
               else if x > arr[mid]        // x is on the right side
                   return binarySearch(arr, x, mid + 1, high)
               
               else                        // x is on the right side
                   return binarySearch(arr, x, low, mid - 1) 
```
