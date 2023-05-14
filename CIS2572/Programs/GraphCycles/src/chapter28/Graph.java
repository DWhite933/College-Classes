package chapter28;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 28.7
File: Graph.java
Description:
Graph interface from page 1051-1052
 */

import java.util.List;

public interface Graph<V> {
    /**
     * Return the number of vertices in the graph
     */
    int getSize();

    /**
     * Return the vertices in the graph
     */
    List<V> getVertices();

    /**
     * Return the object for the specified vertex index
     */
    V getVertex(int index);

    /**
     * Return the index for the specified vertex object
     */
    int getIndex(V vertex);

    /**
     * Return the neighbors of vertex with the specified index
     */
    List<Integer> getNeighbors(int index);

    /**
     * Return the degree for a specified vertex
     */
    int getDegree(int v);

    /**
     * Print the edges
     */
    void printEdges();

    /**
     * clear the graph
     */
    void clear();

    /**
     * Add a vertex to the graph
     */
    boolean addVertex(V vertex);

    /**
     * Add an edge to the graph
     */
    boolean addEdge(int u, int v);

    /**
     * add an edge to the graph
     */
    boolean addEdge(Edge e);

    /**
     * Obtain a depth-first search tree
     */
    UnweightedGraph<V>.SearchTree dfs(int v);

    /**
     * Obtain a breadth-first search tree
     */
    UnweightedGraph<V>.SearchTree bfs(int v);

}
