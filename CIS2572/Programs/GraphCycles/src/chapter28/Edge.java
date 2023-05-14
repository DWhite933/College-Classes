package chapter28;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 28.7
File: Edge.java
Description:
Edge class from page 1045

 */

public class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }


    public boolean equals(Object o) {
        return u == ((Edge) o).u && v == ((Edge) o).v;
    }

}

