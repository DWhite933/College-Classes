package shortestpath;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 29.13
File: Shortestpath.java
Description:G
Revise GraphView in Listing 28.6 to display a weighted graph and a
shortest path between the two specified cities, as shown in Figure
29.25, You need to add a data field path in GraphView. If a path is
not null, the edges in the path are displayed in red. If a city not in
the map is entered, the program displays a text to alert the user.

 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Shortestpath extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        City[] vertices = { new City("Seattle", 75, 50),
        new City("San Francisco", 50, 210),
        new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
        new City("Kansas City", 400, 245), new City("Chicago", 450, 100),
        new City("Boston", 700, 80), new City("New York", 675, 120),
        new City("Atlanta", 575, 295), new City("Miami", 600, 400),
        new City("Dallas", 408, 325), new City("Houston", 450, 360) };

        int[][] edges = {
          {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
          {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
          {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
          {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, {3, 5, 1003},
          {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260}, {4, 8, 864}, {4, 10, 496},
          {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, {5, 6, 983}, {5, 7, 787},
          {6, 5, 983}, {6, 7, 214},
          {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
          {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, {8, 10, 781}, {8, 11, 810},
          {9, 8, 661}, {9, 11, 1187},
          {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
          {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
        };
        
        
        WeightedGraph<City> graph = new WeightedGraph<>(vertices, edges);
        
        GraphView graphView = new GraphView(graph);
        
        BorderPane borderpane = new BorderPane(graphView);
        
        //borderpane.setBottom(new HBox());
        
        
        Scene scene = new Scene(borderpane, 750, 450);
        
        /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn); */
        
               
        primaryStage.setTitle("USMap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    static class City implements Displayable{
        private double x, y;
        private String name;

        public City(String name, double x, double y) {
            this.x = x;
            this.y = y;
            this.name = name;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }

        
        
    }
}
