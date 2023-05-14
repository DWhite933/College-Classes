/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter22;

/**
 * @author David White
 * Class: CIS2572
 * Instructor:  Mohammad Morovati
 * Assignment: Programming exercise 22.17
 * File: ClosestPair.java
 * Description:
 * Write a program that enables the user to add/remove points by clicking the left/right mouse
 * button and displays a line that connects a pair of the nearest points.
 **/

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;




public class ClosestPairPane extends Pane {
    // list of all the circles
    private List<Circle> circles;

    // line connecting the two closest points
    private Line connection;

    // no arg constructor
    public ClosestPairPane(){
        circles = new ArrayList<>();
        drawPane();
    }
    
    /**
     * draws pane
     */
    private void drawPane(){
        setPrefSize(500,500);
        setOnMouseClicked(e -> placePoint(e));
    }

    /**
     * Place point where LMB is clicked
     * @param event a mouse click
     */
    
    private void placePoint(MouseEvent event) {
        if (!event.getButton().equals(MouseButton.PRIMARY)) {
            return;
        }
        Circle circle = new Circle(5);
        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());
        circle.setOnMouseClicked(e -> removePoint(e));
        circles.add(circle);
        getChildren().add(circle);
        connectClosestPoints();
    }

    /**
     * Remove point where RMB is clicked
     * @param event a mouse click
     */
    private void removePoint(MouseEvent event) {
        if (!event.getButton().equals(MouseButton.SECONDARY)){return;}
        Circle circle = (Circle)event.getSource();
        circles.remove(circle);
        getChildren().remove(circle);
        connectClosestPoints();
    }

    /**
     * connects the two closest points
     */
    private void connectClosestPoints() {
        if (circles.size() >= 2){

            double[][] points = getClosestPair(getCirclePoints());
            double[] pointA = points[0];
            double[] pointB = points[1];
            getChildren().remove(connection);
            connection = new Line(pointA[0], pointA[1], pointB[0], pointB[1]);
            getChildren().add(connection);
        } else {
            getChildren().remove(connection);
        }
    }

    /**
     * Returns the points of Circles as an array of doubles
     * @return list of circles points as doubles
     */
    private double[][] getCirclePoints(){
       double[][] points = new double[circles.size()][2];
        for (int i = 0; i < circles.size(); i++) {
          Circle c = circles.get(i);
          points[i][0] = c.getCenterX();
          points[i][1] = c.getCenterY();
        }
        return points;
    }
    
    /**
     * finds the closest pair of circles
     * inefficient but works
     * @param circlePoints 
     * @return 
     */
    private double[][] getClosestPair(double[][] s) {
        double[] p1 = s[0];
        double[] p2 = s[1];

        for (int i = 0; i < s.length; i++) {
          for (int j = i + 1; j < s.length; j++) {
            double closest = distance(p1[0], p1[1], p2[0], p2[1]);
            double candidate = distance(s[i][0], s[i][1], s[j][0], s[j][1]);
            if (candidate < closest) {
              p1 = s[i];
              p2 = s[j];
            }
          }
        }

        return new double[][]{p1, p2};
    }
  
    
    /**
     * calculates the distance between two points
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @return the distance between two points
     */
    private double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + (Math.pow(y1 - y2, 2)));
    }
  
}