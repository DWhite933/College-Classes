package shortestpath;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 29.13
File: WeightedGraph.java
Description:
WeightedGraph class from page 1090-1094

 */

import java.util.*;

public class WeightedGraph<V>extends UnweightedGraph<V>{
    
    /**
     * Construct an empty graph
     */
    public WeightedGraph(){
        
    }
    
    /**
     * Construct a WeightedGraph from vertices and edged in arrays
     */
    public WeightedGraph(V[] vertices, int[][] edges){
        createWeightedGraph(Arrays.asList(vertices), edges);
    }
    
    /**
     * Construct a WeightedGraph form vertices and edges in list
     */
    public WeightedGraph(int numberOfVertices, int[][] edges){
        List<V> vertices = new ArrayList<>();
        
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add((V)(Integer.valueOf(i)));  
            
        }
        
        createWeightedGraph(vertices, edges);
    }
    
    /**
     * Construct a WeightedGraph for vertices 0, 1, 2 and edge list
     */
    public WeightedGraph(List<V> vertices, List<WeightedEdge> edges){
        createWeightedGraph(vertices, edges);
    }
    
    /**
     * Construct a WeightedGraph from vertices 0, 1, and edge array
     */
    public WeightedGraph(int numberOfVertices, List<WeightedEdge> edges){
        
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add((V)(Integer.valueOf(i)));
        }
        
        createWeightedGraph(vertices, edges);
    }
    
    /**
     * Create adjacency lists from edge arrays
     */
    private void createWeightedGraph(List<V> vertices, int[][] edges){
        this.vertices = vertices;
        
        for (V vertex : vertices) {
            neighbors.add(new ArrayList<Edge>()); // Create a  list for vertices
        }
        
        for (int i = 0; i < edges.length; i++) {
            neighbors.get(edges[i][0]).add(
                    new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }
    
    /**
     * Create adjacency lists from edge lists
     */
    private void createWeightedGraph(
            List<V> vertices, List<WeightedEdge> edges){
        this.vertices = vertices;
        
        for (V vertex : vertices){
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        }
        
        for (WeightedEdge edge : edges){
            neighbors.get(edge.u).add(edge); // Add an edge into the list
        }
    }
    
    public double getWeight(int u, int v) throws Exception{
        for (Edge edge : neighbors.get(u)){
            if (edge.v == v) {
                return ((WeightedEdge)edge).weight;
            }
        }
        
        throw new Exception("Edge does not exist.");
    }
    
    
    /**
     * Display edges with weights
     */
    public void printWeightedEdges() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (Edge edge : neighbors.get(i)){
                System.out.print("(" + edge.u +
                        ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
            }
            System.out.println();
        }
    }
    
    /**
     * Add edges to the weighted graph
     */
    public boolean addEdge(int u, int v, double weight){
        return addEdge(new WeightedEdge(u, v, weight));
    }
    
    /**
     * Get a minimum spanning tree rotted at vertex 0
     */
    public MST getMinimumSpanningTree(){
        return getMinimumSpaningTree(0);
    }
    
    public MST getMinimumSpaningTree(int startingVertex){
        // cost[v] stores the cost by adding v to the tree
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost
            
        }
        cost[startingVertex] = 0; // Cost of source is 0
        
        int[] parent = new int[getSize()]; // parent of a vertex
        parent[startingVertex] = -1; // startingVertex is the root
        double totalWeight = 0; // Total weight of the tree thus far
        
        List<Integer> T = new ArrayList<>();
        
        // expand T
        while (T.size() < getSize()) {            
            // Find smallest cost u in V - T
            int u = -1; // Vertex TBD
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
                
            }
            
            if (u == -1) break; else T.add(u); // Add a new vertex to T
            
            totalWeight += cost[u]; // Add cost[u] to the tree
            
            
            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u)){
                if (!T.contains(e.v) && cost[e.v] > ((WeightedEdge)e).weight){
                    cost[e.v] = ((WeightedEdge)e).weight;
                    parent[e.v] = u;
                }
                    
            }                   
        } // End While
        
        return new MST(startingVertex, parent, T, totalWeight);
    }
    
    /**
     * MST is an inner class in WeightedGraph
     */
    public class MST extends SearchTree {
        private double totalWeight; // total weight of all edges in the tree
        
        public MST(int root, int[] parent, List<Integer> searchOrder,
                double totalWeight){
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }
        
        public double getTotalWeight(){
            return totalWeight;
        }
    }
    
    /**
     * find single-source shortest paths
     */
    public ShortestPathTree getShortestPath(int sourceVertex){
        // cost[v] stores the cost of the path from v to the source
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.POSITIVE_INFINITY; // initial cost is set to infinity
        }
        cost[sourceVertex] = 0; // cost of source is 0
        
        // parent[v] stores the previous vertex of v in the path
        int[] parent = new int[getSize()];
        parent[sourceVertex] = -1; // parent of souce is set to -1;
        
        // T stores the vertices whose path found so far
        List<Integer> T = new ArrayList<>();
        
        // expand T
        while (T.size() < getSize()) {            
            // find smallest cost u in V - T
            int u = -1; // vertex TBD
            double currentMinCost = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            }
            
            if (u == -1) break; else T.add(u); // Add a new vertex to T
            
            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e: neighbors.get(u)) {
                if (!T.contains(e.v)
                    && cost[e.v] > cost[u] + ((WeightedEdge)e).weight) {
                    cost[e.v] = cost[u] + ((WeightedEdge)e).weight;
                    parent[e.v] = u;
                }
            }
        } // End while
        
        // Create ShortestPathTree
        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }
    
    /**
     * ShortestPathTree is an inner class in WeightedGraph
     */
    public class ShortestPathTree extends SearchTree {
        private double[] cost; // cost[v] is the cost form v to source
        
        /**
         * Construct path
         */
        public ShortestPathTree(int source, int[] parent,
                List<Integer> searchOrder, double[] cost){
            super(source, parent, searchOrder);
            this.cost = cost;
        }
        
        /**
         * Return the cost for a path from the root to vertex v
         */
        public double getCost(int v){
            return cost[v];
        }
        
        /**
         * Print paths from all vertices to the source
         */
        public void printAllPaths(){
            System.out.println("All shortests paths from " +
                    vertices.get(getRoot()) + " are: ");
            
            for (int i = 0; i < cost.length; i++) {
                printPath(i); // Print a path from i to the source
                System.out.println("(Cost: " + cost[i] + ")");
            }
        }
    }
}
