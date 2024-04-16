package com.craftcoding.dsalgo.graphs;

import java.util.*;

public class AdjacencyListDirectedGraph implements Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyListDirectedGraph(int vertices) {
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // For undirected graph, uncomment the next line
        // adjacencyList.get(destination).add(source);
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }
}
