package com.craftcoding.dsalgo.graphs;

import java.util.Arrays;
import java.util.List;

public class DFS {
    private final AdjacencyListUndirectedGraph adjacencyListUndirectedGraph;
    private final boolean[] visited;
    public DFS(int n){
        adjacencyListUndirectedGraph = new AdjacencyListUndirectedGraph(n);
        visited = new boolean[n];
    }

    public void add(int src, int des){
        adjacencyListUndirectedGraph.addEdge(src, des);
    }

    public List<Integer> getNeighbours(int at){
        return adjacencyListUndirectedGraph.getAdjacentVertices(at);
    }
    public void dfs(int at){
        if(visited[at])
            return;

        System.out.print(at + " -> ");

        visited[at] = true;
        for(Integer node : getNeighbours(at)){
           dfs(node);
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(13);
        dfs.getNeighbours(0).addAll(Arrays.asList(1, 8, 9));
        dfs.getNeighbours(1).addAll(Arrays.asList(0,8));
        dfs.getNeighbours(2).addAll(Arrays.asList(3));
        dfs.getNeighbours(3).addAll(Arrays.asList(2,4,5,7));
        dfs.getNeighbours(4).addAll(Arrays.asList(3));
        dfs.getNeighbours(5).addAll(Arrays.asList(3,6));
        dfs.getNeighbours(6).addAll(Arrays.asList(5));
        dfs.getNeighbours(7).addAll(Arrays.asList(3,8,10,11));
        dfs.getNeighbours(8).addAll(Arrays.asList(0,1,7,9));
        dfs.getNeighbours(9).addAll(Arrays.asList(0,8));
        dfs.getNeighbours(10).addAll(Arrays.asList(7,11));
        dfs.getNeighbours(11).addAll(Arrays.asList(7,10));
        dfs.getNeighbours(12).addAll(Arrays.asList());

        dfs.dfs(0);
    }
}
