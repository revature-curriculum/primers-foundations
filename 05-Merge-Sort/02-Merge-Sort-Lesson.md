# Merge Sort

How was it? A little all over the place huh? 

Well, let us see if this will clear up your thoughts a little bit more.

For reference again, here is the diagram we have on Merge Sort:
![[Merge_Sort.png]]

To begin, let us think of "*divide and conquer*." The *divide and conquer* methodology here is separated into:
- **Dividing** the input arrays into ***2*** halves, and
- **Conquering** by ***sorting*** and ***merging*** the divided halves. 
However, this does not occur only once as shown above. We need to *divide* multiple times to finally begin *conquering*. In the diagram above we *divide* our array 7 times before we *merge* anything.

But first, to understand the inner workings of **Merge Sort**, we are going to look at this Algorithm *backward*, beginning with `merge()`.

We'll use the array from the diagram above:
```java
int arr[] = {38, 27, 43, 3, 9, 82, 10};
```
## So what does the `merge()` method do? 

In a nutshell, the merge method reassigns the values of an array with the values of its sub-arrays; *merging* the sub-arrays into the main array. 

So let's take our method and apply the parameters of our above diagram. 
```java
public static void merge(int[] arr, int[] left, int[] right, int l, int r){}
```
Here we have our initial array,`arr[]`; the left sub-array, `left[]`; the right sub-array, `right[]`; the value of half the length of `arr[]` or the length of `left[]`, `l`; and the other half of the length of `arr[]` or the length of `right[]`, `r`. 

### Comparing `left[]` & `right[]`
In this method, we need to iterate through all three arrays. As we iterate through them we are assigning values to `arr[]` with the values from `left[]` and `right[]`; hence the *merge*. The only condition here is that they must merge in **order**. Thus, to do that we must place conditions that dictate which element from which sub-array will overwrite the element in the index we are focusing in `arr[]`, then repeat for the next index over. 

Thus the logic should look like this:
```java
public static void merge(int[] arr, int[] left, int[] right, int l, int r){
	
	// Here we are establishing temporary variables to use as indexes per each array
	int i = 0, j = 0, k = 0;
	
	// Here we are stating as long as we have not reached the end 
	// of either sub-array continue the comparing and merging process
	while(i < l && j < r){
		
		//Here we are comparing the value of left[] at index i with
		//the value of right[] at index j 
		if(left[i] <= right[j]){
			
			//Here we assign the value of left[] at index i to arr[] at index k.
			// Then we increment up the value of i (assigned to the indexes of left[]) and
			// k (assigned to the indexes of arr[]), but not j (assigned to indexes of right[]).
			arr[k++] = left[i++];
			//We don't increment the index value of the right[], j, because we did not insert
			//that value into arr[]. 
		}
		//Here, if the above condition isn't met,
		else {
			//we assign the value of right[] at index j to arr[] at index k.
			// Then we increment up the value of j and
			// k, and not i (assigned to indexes of left[]).
			arr[k++] = right[j++];
		}
	}
}
```
### Don't Forget Your Leftovers
At this point, we are comparing each element from each sub-array, and inserting each one in order until we reach the end of one of the sub-arrays. However, we will only reach the end of **one** sub-array, breaking free of the `while` loop's condition and leaving the opposing sub-array with at least one extra element that has not been inserted. 

Thus, the next set of logic is to take into account the remaining elements of both sub-arrays.
``` java
public static void merge(int[] arr, int[] left, int[] right, int l, int r){

	int i = 0, j = 0, k = 0;

	while(i < l && j < r){
		
		if(left[i] <= right[j]){
			arr[k++] = left[i++];
		}
		else {
			arr[k++] = right[j++];
		}
	}
// ============================== 

	//Here were are assigning the remaining values of the left[] to the end of arr[]
	while(i < l){
		arr[k++] = left[i++];
	}

	//Here were are assigning the remaining values of the right[] to the end of arr[]
	while(j < r){
		arr[k++] = right[j++];
	}
}
```
## The main `mergeSort()` method
Our `merge()` method takes in two sub-arrays within its parameters, but where do those sub-arrays come from? From our main `mergeSort()` method of course!

We want `mergeSort()` to just take in an **array** and possibly the *length of said array*, you could most definitely set a variable to the length of the array within the method itself. It will just add more logic to the body of the method. We will include the length of the array in our example here.
```java
public static void mergeSort(int[] arr, int n){}
```
So, the above `mergeSort()` method takes in an array of *integers*, `arr`, and an *integer* value `n` which represents the length of the array (`n = arr.length`). Now we have to do the honor of creating the necessary split of `arr[]` into two sub-arrays. 
```java
public static void mergeSort(int[] arr, int n){

	//First we need to find the middle value of our arr[]
	//we will use this to create sub-arrays with a size of half of arr[] 
	int mid = n/2;

	//Create the empty sub-array left[] with a size of the left half of arr[] 
	int[] left = new int[mid];

	//Create the empty sub-array righgt[] with a size of the right half of arr[] 
	int[] right = new int[n-mid];
	
	//Now to copy the elements from arr[] into both sub-array
	// left[] will copy only the elements on the left half of arr[]
	for(int i=0; i < mid; i++){
		left[i] = arr[i]; 
	}
	// right[] will copy only the elements of the right half of arr[]
	for(int i=mid; i < n; i++){
		right[i-mid] = arr[i];
	}
}
```
Now we have the logic of splitting an array into two sub-arrays. However, as you recall in the diagram above we need to then split the sub-arrays even more so. This is where **Recursion** comes in! To divide the sub-arrays even further we need to insert those sub-arrays as *main arrays* of the `mergeSort()` method. 
```java
public static void mergeSort(int[] arr, int n){
	int mid = n/2;
	int[] left = new int[mid];
	int[] right = new int[n-mid];

	for(int i=0; i < mid; i++){
		left[i] = arr[i]; 
	}
	for(int i=mid; i < n; i++){
		right[i-mid] = arr[i];
	}
	
	//insert left[] to divide that array and use mid as the length of the array
	mergeSort(left, mid);
	
	//insert right[] to divide that array, and use n-mid as the length of the array
	mergeSort(right, n-mid);
	
}
```

We have to continue doing this split on each sub-array we make until we finally create arrays that contain only **one** element in it. However, since we are using recursion, the division will continue unless we set some condition that breaks it from this loop. Once out of the loop then we can finally have our sub-arrays **merge** with one another!
```java
public static void mergeSort(int[] arr, int n){

	//set a condition that will stop the recursion if 
	//the length of the array is less than 2, 
	//and return a value to continue through the parent mergeSort()
	if(n < 2) {
		return;
	}

	int mid = n/2;
	int[] left = new int[mid];
	int[] right = new int[n-mid];

	for(int i=0; i < mid; i++){
		left[i] = arr[i]; 
	}
	for(int i=mid; i < n; i++){
		right[i-mid] = arr[i];
	}

	mergeSort(left, mid);
	mergeSort(right, n-mid);
	
	//Once out of the mergeSort() for left[] and right[] 
	//we want to call the merge().
	// we use all of the variables and arrays 
	// used in mergerSort() in our parameters for merge()
	merge(arr, left, right, mid, n-mid);
}
```
Once we finally merge back up to our initial parent method the whole process will be completed and our array should be sorted!

## Complexity
The **time complexity** of the *entire* **Merge Sort** when solved will be `O(n logn)`. Since it is a recursive solution, we look at the complexity of the method more like this:
```java
T(n) = 2T(n/2) + O(n)
```
Here, `2T(n/2)` is equal to the time it takes to sort each sub-array within itself, and `O(n)` is the time it takes to merge the entire array. 

The **space complexity** of a **Merge Sort** is equal to `O(n)` since we create temporary arrays for every recursion of the method.

## Full Code Example
```java
public static void merge(int[] arr, int[] left, int[] right, int l, int r){
	int i = 0, j = 0, k = 0;
	
	while(i < l && j < r){
		if(left[i] <= right[j]){
			arr[k++] = left[i++];
		}
		else {
			arr[k++] = right[j++];
		}
	}
	while(i < l){
		arr[k++] = left[i++];
	}
	while(j < r){
		arr[k++] = right[j++];
	}
}

public static void mergeSort(int[] arr, int n){
	if(n < 2) {
		return;
	}

	int mid = n/2;
	int[] left = new int[mid];
	int[] right = new int[n-mid];

	for(int i=0; i < mid; i++){
		left[i] = arr[i]; 
	}
	for(int i=mid; i < n; i++){
		right[i-mid] = arr[i];
	}

	mergeSort(left, mid);
	mergeSort(right, n-mid);
	
	merge(arr, left, right, mid, n-mid);
}
```

## Additional Resources:
- [Baeldung](https://www.baeldung.com/java-merge-sort)
- [Geeks4Geeks](https://www.geeksforgeeks.org/merge-sort/)
- [Merge Sort Algorithm in Java - Full Tutorial with Source](https://www.youtube.com/watch?v=bOk35XmHPKs)
- [Recursion: A Quick Guide for Software Engineers](https://www.educative.io/blog/recursion)
- [Java Recursion - How to make Recursive Methods](https://www.youtube.com/watch?v=sE0sH8vSmE4)