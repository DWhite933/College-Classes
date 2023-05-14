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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class ClosestPair extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClosestPairPane pane = new ClosestPairPane();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Closest Pairs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}