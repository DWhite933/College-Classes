package shortestpath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 29.13
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
