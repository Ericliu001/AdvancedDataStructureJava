package com.ericliu.developer.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 11/07/2016.
 */
public class GraphImpl implements Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;


    public GraphImpl() {
        this.vertexes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public GraphImpl(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    @Override
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public List<Vertex> getVertexes() {
        return vertexes;
    }

    @Override
    public List<Edge> getEdges() {
        return edges;
    }



}
