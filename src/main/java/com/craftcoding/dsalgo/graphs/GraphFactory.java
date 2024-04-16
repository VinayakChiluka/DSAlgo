package com.craftcoding.dsalgo.graphs;

public class GraphFactory {
    public static Graph createGraph(String type, int vertices) {
        switch (type) {
            case "adjacencyList-directed":
                return new AdjacencyListDirectedGraph(vertices);
            case "adjacencyList-undirected":
                return new AdjacencyListUndirectedGraph(vertices);
            case "adjacencyMatrix":
                return new AdjacencyMatrixGraph(vertices);
            case "edgeList":
                return new EdgeListGraph(vertices);
            default:
                throw new IllegalArgumentException("Unknown graph type");
        }
    }
}
