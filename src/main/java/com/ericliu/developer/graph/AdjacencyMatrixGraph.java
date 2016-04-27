package com.ericliu.developer.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericliu on 19/04/2016.
 */
public class AdjacencyMatrixGraph implements Graph {
    public int size = 2;
    public int[][] matrix = new int[size][size];
    public List<String> vertexs;


    public AdjacencyMatrixGraph(){
        vertexs = new ArrayList<String>();
    }


    private void resize(int index) {
        while (index >= size) {
            int newSize = 2 * size;
            int[][] newMatrix = new int[newSize][newSize];
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
    public void addVertex(String vertex) {
        if (vertexs.contains(vertex)) {
            return;
        }
        vertexs.add(vertex);
        resize(vertexs.size());
    }

    @Override
    public void addEdge(String x, String y) {
        if ((!vertexs.contains(x)) ||  (!vertexs.contains(y))) {
            return;
        }

        matrix[vertexs.indexOf(x)][vertexs.indexOf(y)] = 1;
    }
}
