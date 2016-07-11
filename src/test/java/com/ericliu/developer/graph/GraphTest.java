package com.ericliu.developer.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 19/04/2016.
 */
public class GraphTest {
    String[] cities = {"Sydney", "Perth", "Adelaide", "Brisbane", "Melbourne"};

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {
    }


    @Test
    public void testAdjacencyMatrix() {
        MatrixGraphImpl matrixGraph = new MatrixGraphImpl();
        for (String city : cities) {
            matrixGraph.addVertex(city);
        }

        matrixGraph.addEdge("Sydney", "Brisbane");
        matrixGraph.addEdge("Sydney", "Melbourne");


        matrixGraph.addEdge("Brisbane", "Melbourne");
        matrixGraph.addEdge("Brisbane", "Sydney");


        matrixGraph.addEdge("Perth", "Brisbane");
        matrixGraph.addEdge("Perth", "Adelaide");
        matrixGraph.addEdge("Perth", "Melbourne");
        matrixGraph.addEdge("Perth", "Sydney");

        matrixGraph.addEdge("Adelaide", "Melbourne");
        matrixGraph.addEdge("Adelaide", "Sydney");
        matrixGraph.addEdge("Adelaide", "Perth");


        printMatrixGraph(matrixGraph);
    }

    private void printMatrixGraph(MatrixGraphImpl graph) {
        for (String vertex : graph.vertexs) {
            System.out.print("      " + vertex + ", ");
        }

        System.out.print("\n");
        System.out.print("\n");

        int i = 0;
        for (String vertex : graph.vertexs) {
            System.out.print(vertex + ": ");
            for (int j = 0; j < graph.size; j++) {
                System.out.print(graph.matrix[i][j] + ", ");
            }


            System.out.print("\n");
            i++;
        }
    }

}
