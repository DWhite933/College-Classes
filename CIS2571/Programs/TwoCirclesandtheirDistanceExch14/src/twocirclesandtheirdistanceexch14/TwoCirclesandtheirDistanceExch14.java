/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twocirclesandtheirdistanceexch14;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Short Exercise Ch.14
File: TwoCirclesandtheirDistanceExch14.java
Description: Write a program that draws two filled circles with radius 15 pixels, centered at random locations, with a line connecting the circles. The distance between the two centers is displayed on the line
 */
public class TwoCirclesandtheirDistanceExch14 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create a circle with radius 15 in a random location
        Circle circle1 = new Circle(Math.random() * 500, Math.random() * 500, 15);
        circle1.setFill(Color.BLACK); //fill circle black
       
        
        //create anothor circel with radius 15 in a different random location
        Circle circle2 = new Circle(Math.random() * 500, Math.random() * 500, 15);
        circle1.setFill(Color.BLACK); //fill circle black
        
        //create a line between the 2 circles
        Line line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
                        
        //caclulate distance between center of circles
        double distance = Math.sqrt(Math.pow(line.getEndX() - line.getStartX(), 2) + Math.pow(line.getEndY() - line.getStartY(), 2));
        
        //create text
        Text text = new Text((line.getStartX() + line.getEndX()) / 2,
                (line.getStartY() + line.getEndY()) / 2, String.valueOf(distance));
        
        //add objecte to pane and create scene on stage
        Pane pane = new Pane(circle1, circle2, line, text);
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Short Exercice Ch. 14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
