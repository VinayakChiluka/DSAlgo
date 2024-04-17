package com.craftcoding.dsalgo.graphs;

import java.util.*;

public class BFS {
    private int numVertices;  // Number of vertices in the graph
    private LinkedList<Integer> adj[]; // Adjacency lists

    // Constructor
    BFS(int v) {
        numVertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    LinkedList<Integer> shortedPath(int s, int e){
        boolean[] visited = new boolean[numVertices];
        int[] prev = new int[numVertices];
        Arrays.fill(prev, -1); // Fill prev array with -1 to indicate no previous node
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (Integer neighbor : adj[node]) {
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    prev[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        for(int at=e; at != -1; at = prev[at]){
            path.addFirst(at);
        }

        if(path.get(0) == s)
            return path;
        else
            return new LinkedList<>();

    }

    // Function to perform BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited (by default set as false)
        boolean[] visited = new boolean[numVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited and enqueue it
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

    public static void main(String args[]) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 0)");

     //   g.BFS(0);

        System.out.println( g.shortedPath(0, 3));
    }
}
