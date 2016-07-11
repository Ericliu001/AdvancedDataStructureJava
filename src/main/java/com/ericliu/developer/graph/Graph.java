package com.ericliu.developer.graph;

import java.util.List;

/**
 * Created by ericliu on 19/04/2016.
 */
public interface Graph {
    void addVertex(Vertex vertex);

    void addEdge(Edge edge);

    List<Vertex> getVertexes();

    List<Edge> getEdges();


}
