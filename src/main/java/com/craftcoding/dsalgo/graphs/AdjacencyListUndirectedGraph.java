package com.craftcoding.dsalgo.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListUndirectedGraph implements Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyListUndirectedGraph(int vertices) {
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }
}
