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


import java.util.List;

public class Main {

    public static void main(String[] args) {

	    String[] cityVertices = {"Seattle", "San Francisco", "Los Angeles",
        "Denver", "Kansas City", "Chicago", "Boston", "New York",
        "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] cityEdges = {
                {0,1}, {0,3}, {0,5},
                {1,0}, {1,2}, {1,3},
                {2,1}, {2,3}, {2,4}, {2,10},
                {3,0}, {3,1}, {3,2}, {3,4}, {3,5},
                {4,2}, {4,3}, {4,5}, {4,7}, {4,8}, {4, 10},
                {5,0}, {5,3}, {5,4}, {5,6}, {5,7},
                {6,5}, {6,7},
                {7,4}, {7,5}, {7,6}, {7,8},
                {8,4}, {8,7}, {8,9}, {8,10}, {8,11},
                {9,8}, {9,11},
                {10, 2}, {10, 4}, {10,8}, {10, 11},
                {11, 8}, {11,9}, {11,10}
        };

        // Create graph
        UnweightedGraphDetectCycle<String> cityGraph = new UnweightedGraphDetectCycle<>(cityVertices, cityEdges);

        // Print edges
        System.out.println("The edges for cityGraph: ");
        cityGraph.printEdges();

        System.out.println();
        List<Integer> cycle = cityGraph.getCycle(cityGraph.getIndex("Chicago"));

        System.out.println("The cycle vertices: ");
        for (int i = 0; i < cycle.size(); i++) {
            System.out.println(cityGraph.getVertex(cycle.get(i)));
        }


    }
}
