package shortestpath;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 29.13
File: GraphView.java
Description:
GraphView class from page 1058-1059 

 */

import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class GraphView extends BorderPane {
    private WeightedGraph<? extends Displayable> graph;
    private Group group = new Group();
    
    // text field for the starting city  
    TextField cityStartTextField = new TextField();
        
    // Text field for the ending city
    TextField cityEndTextField = new TextField();
    
    // path between the two given cities
    private List<? extends Displayable> path = null;
    
    
    /**
     * GraphView constructor
     */
    public GraphView(WeightedGraph<? extends Displayable> graph){
        this.graph = graph;
        this.setCenter(group); // center the group
        repaintGraph();
        paintHBox();
        
        
    }
    /**
     * paints the graph
     */
    private void repaintGraph(){
        group.getChildren().clear(); // Clear group for a new display
        
        // Draw vertices and text for vertices
        List<? extends Displayable> vertices = graph.getVertices();
        
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();
            String name = vertices.get(i).getName();
            
            group.getChildren().add(new Circle(x,y, 10));
            group.getChildren().add(new Text(x-10, y-15, name));
        }
        
        // draw edges for pairs of vertices
        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            double x1 = graph.getVertex(i).getX();
            double y1 = graph.getVertex(i).getY();
            for (int v: neighbors){
                double x2 = graph.getVertex(v).getX();
                double y2 = graph.getVertex(v).getY();
            
                // draw an edge for (i,v)
                group.getChildren().add(new Line(x1, y1, x2, y2));
                
                try {
                   group.getChildren().add(new Text(((x1 + x2) / 2), ((y1 + y2) / 2), String.valueOf(graph.getWeight(i, v))));
                } catch (Exception e) {
                    System.out.println("Edge doesn't exist");
                }     
            }
        } // end for
    }
    /**
     * paints the HBox
     */
      private void paintHBox() {
        
        
        Button btn = new Button("Display Shortest Path");
        
        HBox hbox = new HBox(25);
        hbox.setPrefWidth(300);
        hbox.setAlignment(Pos.CENTER);
    
        
        hbox.getChildren().add(new Label("Enter Starting City"));
        hbox.getChildren().add(cityStartTextField);
        hbox.getChildren().add(new Label("Enter Ending City"));
        hbox.getChildren().add(cityEndTextField);
        hbox.getChildren().add(btn);
        btn.setOnAction((event) -> {pathFinder(cityStartTextField.getText(), cityEndTextField.getText());
        });
        
        this.setBottom(hbox);
    }
    
      /**
       * finds and displays a path between the two given city
       */
    private void pathFinder(String cityStart, String cityEnd){
      
        boolean cityCheck = true;
        
        List<? extends Displayable> vertices = graph.getVertices();
        
        int cityA = getCityIndex(cityStart);
        int cityB = getCityIndex(cityEnd);
        
        // check if cities given are in the graph
        if (cityA == -1) {
            cityStartTextField.setText("City Not Found");
            return;
        }
        if (cityB == -1) {
            cityEndTextField.setText("City Not Found");
            return;
        }

        // get shortest path
        WeightedGraph.ShortestPathTree tree1 = graph.getShortestPath(cityB);
        path = tree1.getPath(cityA);

 

        // display shortest path
        for (int i = 0; i < path.size() - 1; i++) {

            Line line = new Line(path.get(i).getX(), path.get(i).getY(), path.get(i+1).getX() , path.get(i+1).getY());
            line.setStroke(Color.RED);
            line.setStrokeWidth(5);
            group.getChildren().add(line);
        }

        
    }

    /**
     * 
     */
    private int getCityIndex(String city) {
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getName().equals(city)) {
                return i;
            }
        }
        return -1;
    }

  
}
