# Breadth First Search (BFS)

The **Breadth First Search traversal** (BFS) is an algorithm, which is used to visit *all* adjacent nodes of a given graph before reaching the end. In this traversal algorithm, one node is selected and then all of the **adjacent** nodes are visited one by one. After completing all of the **adjacent** vertices, it then moves down to check other vertices and their adjacent vertices.

## Visual Walkthrough

![BFS Diagram](Images/BFSdiagram.png)

 1. We start from **top** node, `1`.
 2. Since there is only one node at the top of this graph, we go down to the *next* level
 3. The second level down now had two nodes side by side. These are the *adjacent vertices*. Here we traverse through node `2` and then `3`.
 4. Now that there are no more nodes in this level, BFS will move down to the next layer, were traverse again left to right.

Below is the code example to refer to.

## Algorithm
```java
class Graph {

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Integer> adj[]; 

    // Constructor
    Graph(int v) { 
        V = v;
        adj = new LinkedList[v];
        for (int i= 0; i<v; ++i)
        adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
        void BFS(int s) {

        // Mark all the vertices as not visited(default as false)
        boolean visited[] = new boolean [V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]= true; 
        queue.add(s);
        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();   
            System.out.print(s+" ");

            /* Get all adjacent vertices of the dequeued vertexes If an adjacent has not been visited, then mark it visited and enqueue it
            */
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Following is Breadth First Traversal " + 
    "(starting from vertex 2)");
    g.BFS(2);
    }
}
```
```
Output:
Following is Breadth First Traversal (starting from vertex 2) 
2 0 3 1
```

# Depth First Search (DFS)


The **Depth First Search traversal** (DFS) is an algorithm used to visit the *last* nodes a quickly as possible. In this algorithm, the starting vertex is given, then the traversal moves to an adjacent vertex. I will continue down in the *same* direction until it has reached the **last** vertex on that side of the graph. Then the traversal will begin *BFS* but in **reverse**! Once it reaches the top of the graph, it will then dive back down as much as it can from the other half of the graph.

## Visual Walkthrough
![DFS Diagram](Images/DFSdiagram.png)
 1. Start with the top node, `1`.
 2. Then go to the *next* _**deepest**_ node on the left.
 3. Continue traversal in the same direction until you reach the end of the left *road*.
 4. Now that we have hit the *deepest left* node, we will go back to the top and repeat the traversal through the nodes on the *right side* of the graph.

## Types of DFS
There are multiple way in which one can conduct DFS. Here are all the types of DFS:

-   Inorder Traversal (Left-Root-Right)
-   Preorder Traversal (Root-Left-Right)
-   Postorder Traversal (Left-Right-Root)

The example above follows an **Inorder Traversal**. Below is how we would code for an **Inorder DFS**.

## Algorithm
```java
class Graph {
    //No. of vertices
    private int V; 

    private LinkedList<Integer> adj[];
    
    //Constructor
    @SuppressWarnings("unchecked") Graph(int v) { 
        V = v;
        adj =new LinkedList[v];
        for(int i = 0; i < v; ++i)
        adj[i] =` `new` `LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) { 
        //Add w to v's list
        adj[v].add(w); 
    }

    //A function used by DFS
    void DFSUtil(int v, boolean visited[]) { 
        //Mark the current node as visited and print it
        visited[v] = true; 
       
        System.out.print(v + " ");
        
        // Iterate for all vertices adjacent to this one
        Iterator<Integer> i = adj[v].listIterator(); 
        
        while(i.hasNext()) {
            int n = i.next();

            if(!visited[n])
            DFSUtil(n, visited);
        }
    }
    
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) { 
    
    // Mark all the vertices as not visited(false by default)
    boolean visited[] = new boolean[V]; 
    
    // Call the recursive helper function to print DFS traversal
    DFSUtil(v, visited); 
    }

    //Driver's Code
    public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,0);
    g.addEdge(2,3);
    g.addEdge(3,3);
    System.out.println("Following is Depth First Traversal " +
    "(starting from vertex 2)");
    
    //Function call
    g.DFS(2); 
    }
}
```
```
Output:
Following is Depth First Traversal (starting from vertex 2) 2 0 1 3
```
# Differences between BFS and DFS
Both BFS and DFS traverse through our graph and searches every node. It can be a little difficult to remember the differences. Thus, here is a chart for your convience:

## BFS vs. DFS
|BFS|DFS|
|--|--|
|Breadth First Search|Depth First Search|
|Uses Queue to find the shortest path|Uses Stack to find the shortest path|
|Better when target is closer to Source|Better when target is far from source|
|As BFS considers all neighbors, it is not suitable for decision trees used in puzzle games|More suitable for decision trees. As with one decision, we need to traverse further to augment the decision|
|Slower|Faster|

## Real world examples
It's always difficult for one to imagine when they would use these in the job field, so here are some uses for each and how we can see them used in our daily lives.

### BFS
- **Peer to Peer Networks.**  In Peer to Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes.
- **Social Networking Websites:** In social networks, we can find people within a given distance ‘k’ from a person using Breadth First Search till ‘k’ levels.
- **GPS Navigation systems:**  Breadth First Search is used to find all neighboring locations.
- **Broadcasting in Network:**  In networks, a broadcasted packet follows Breadth First Search to reach all nodes.
-  **In Garbage Collection:**  Breadth First Search is used in copying garbage collection using *Cheney’s algorithm*. Breadth First Search is preferred over Depth First Search because of the better locality of reference.
### DFS
 - **Detecting cycle in a graph** A graph has a cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges.
- **Path Finding**   We can specialize the DFS algorithm to find a path between two given vertices u and z.
    - Call DFS(G, u) with u as the start vertex
    - Use a stack S to keep track of the path between the start vertex and the current vertex
    - As soon as destination vertex z is encountered, return the path as the contents of the stack
- **Topological Sorting** Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs. In computer science, applications of this type arise in instruction scheduling, ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, determining the order of compilation tasks to perform in makefiles, data serialization, and resolving symbol dependencies in linkers.
- **Finding Strongly Connected Components of a graph**  A directed graph is called strongly connected if there is a path from each vertex in the graph to every other vertex.
- **Solving puzzles with only one solution** such as mazes, (DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.)

## Sources

 - [BFS | GeeksForGeeks](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/?ref=gcse)
 - [DFS | GeeksForGeeks](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/?ref=gcse)
 - [Java Graph Tutorial | Software Testing Help](https://www.softwaretestinghelp.com/java-graph-tutorial/)
 - [Graph Traversals - BFS & DFS | YouTube](https://www.youtube.com/watch?v=pcKY4hjDrxk)
