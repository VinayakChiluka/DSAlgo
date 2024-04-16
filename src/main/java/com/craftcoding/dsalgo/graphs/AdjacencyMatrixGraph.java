package com.craftcoding.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixGraph(int vertices) {
        adjacencyMatrix = new int[vertices][vertices];
    }

    @Override
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        // For undirected graph, uncomment the next line
        // adjacencyMatrix[destination][source] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix[vertex].length; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                adjacentVertices.add(i);
            }
        }
        return adjacentVertices;
    }
}
