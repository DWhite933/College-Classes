package chapter28;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 28.7
File: main.java
Description:
Create a class called UnweightedGraphFIndCycle that extends
Unweighted graph with a new method for finding a cycle starting
at vertex V with the following header:

public List<Integer> getCycle(int v);

The method returns a list that contains all the vertices
in a cycle starting from v. If the graph doesn't have a
cycle, the method returns null.

 */

import java.util.*;


public class UnweightedGraphDetectCycle<V> extends UnweightedGraph<V> {
    /**
     * Construct an empty graph
     */
    protected UnweightedGraphDetectCycle() {

    }

    /**
     * Construct a graph from vertices and edges stored in arrays
     */
    protected UnweightedGraphDetectCycle(V[] vertices, int[][] edges) {
        for (V vertex : vertices) addVertex(vertex);

        createAdjacencyLists(edges, vertices.length);
    }

    /**
     * Construct a graph from vertices and edges stored in List
     */
    protected UnweightedGraphDetectCycle(List<V> vertices, List<Edge> edges){
        for (V vertex : vertices) {
            addVertex(vertex);
        }

        createAdjacencyLists(edges, vertices.size());
    }

    /**
     * Construct a graph for integer vertices 0, 1, 2 and edge list
     */
    protected UnweightedGraphDetectCycle(List<Edge> edges, int numberOfVertices){
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V)(Integer.valueOf(i))); // vertices is {0, 1, ...}

        createAdjacencyLists(edges, numberOfVertices);
    }

    /**
     * Construct a graph from integer vertices 0, 1, and edge array
     */
    protected UnweightedGraphDetectCycle(int[][] edges, int numberOfVertices){
        for (int i = 0; i < numberOfVertices; i++){
            addVertex((V)(Integer.valueOf(i)));
        }

        createAdjacencyLists(edges, numberOfVertices);
    }

    /**
     * Create adjacency lists for each vertex
     */
    private void createAdjacencyLists(int[][] edges, int numberOfVertices){
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    /**
     * Create adjacency lists for each vertex
     */
    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices){
        for (Edge edge : edges) {
            addEdge(edge.u, edge.v);
        }
    }

    public List<Integer> getCycle(int v){
        SearchTree tree = dfs(v);
        return tree.getSearchOrder();
    }
}
