package com.ericliu.developer.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 19/04/2016.
 */
public class MatrixGraphImpl implements Graph {
    public int size = 1 << 2;
    public Edge[][] matrix = new Edge[size][size];
    public List<Vertex> vertexs;


    public MatrixGraphImpl() {
        vertexs = new ArrayList<Vertex>();
    }


    private void resize(int index) {
        while (index >= size) {
            int newSize = 2 * size;
            Edge[][] newMatrix = new Edge[newSize][newSize];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }

            size = newSize;
            matrix = newMatrix;
        }
    }


    @Override
    public void addVertex(Vertex vertex) {
        if (vertexs.contains(vertex)) {
            return;
        }
        vertexs.add(vertex);
        resize(vertexs.size());
    }

    @Override
    public void addEdge(Edge edge) {
        if (!vertexs.contains(edge.getSource()) || !vertexs.contains(edge.getDestination())) {
            throw new IllegalArgumentException("This edge contains vertices that are not part of the graph.");
        }

        matrix[vertexs.indexOf(edge.getSource())][vertexs.indexOf(edge.getDestination())] = edge;

    }

    @Override
    public List<Vertex> getVertexes() {
        return null;
    }

    @Override
    public List<Edge> getEdges() {
        return null;
    }
}
