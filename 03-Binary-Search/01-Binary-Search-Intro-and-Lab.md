# Search Algorithms
In software development, the process of **Searching** is finding an element within a data structure. If we find the element that we are searching for, then the search is successful and we will recieve the location of that element. However, if we do not, then the search is unsuccessful and we will recive nothing. 

The most comon search methods that we use are:
- **Linear Search**, and
- **Binary Search**
both of which can be implemented using either a Iterative method which uses looping constructs, or Recursive methods that use recursion logic. 

## Intro to Binary Search 
A binary search follows the *divide and conquer* approach in which the list is divided into two halves. The item we are searching for is then compared with the **middle** element of the list. If they match, we return the index of the middle element. If not, we determin whether the item we are searching for is greater or less than the middle element. From there we iterate with the same method through the appropriate sub-array of the list until we find the element that matches and return its index.

Here is how it would look like in pseudo-code:
``` Java
    binarySearch(arr, x, first, last)
        repeat till first = last
               mid = (first + last)/2
                   if (x == arr[mid])
                   return mid
   
                   else if (x > arr[mid]) // x is on the right side
                       first = mid + 1
   
                   else                  // x is on the left side
                       last = mid - 1
```

The next module will contain a more indepth explaination of Binary Search.

But First, try to implement this on your own, using what you know so far. Use whatever method you choose to implemtent; Iterative or Recursive.

**To access the labs via Replit.com, you must first [join the Post-Training Replit Team by clicking here](https://replit.com/teams/join/ovnxpukpgnmqolcfnlrlxvygvzunwhgo-staging-foundations-h2-22) and signing up for a free Replit.com account with your ==Revature.net== Email. If you do not use your Revature email, your progress may not be tracked by our systems**

[Replit](https://replit.com/team/staging-foundations-h2-22/binary-search-lab)  
[Source](https://github.com/revature-curriculum/binary-search-lab.git)

Once finished with the lab here, continue to the following section to read a more in-depth description of this Algorithm.
