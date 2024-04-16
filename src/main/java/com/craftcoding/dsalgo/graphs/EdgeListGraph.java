package com.craftcoding.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeListGraph implements Graph {
    private List<int[]> edges;
    private int numVertices;

    public EdgeListGraph(int vertices) {
        this.numVertices = vertices;
        edges = new ArrayList<>();
    }

    @Override
    public void addEdge(int source, int destination) {
        edges.add(new int[]{source, destination});
        // For undirected graph, uncomment the next line
        // edges.add(new int[]{destination, source});
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> adjacent = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == vertex) adjacent.add(edge[1]);
            else if (edge[1] == vertex) adjacent.add(edge[0]);
        }
        return adjacent;
    }
}
