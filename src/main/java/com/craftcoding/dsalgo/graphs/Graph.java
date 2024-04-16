package com.craftcoding.dsalgo.graphs;

import java.util.List;

public interface Graph {
    void addEdge(int source, int destination);
    List<Integer> getAdjacentVertices(int vertex);
}
