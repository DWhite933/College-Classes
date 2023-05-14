package homework14;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author
 */
public class Homework14 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Create random object
        Random random = new Random();
        // My name is...
        String myName = "David";
        
        // Get playing card images
        Image spadeCard = new Image("images/" + random.nextInt(13 + 1) + ".png");
        Image heartCard = new Image("images/" + (14 + random.nextInt(26 - 14) + 1) + ".png");
        Image diamondCard = new Image("images/" + (27 + random.nextInt(39 - 27) + 1) + ".png");
        Image clubCard = new Image("images/" + (40 + random.nextInt(52 - 40) + 1) + ".png");
        
        // Layout grid
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        pane.getChildren().addAll(new ImageView(spadeCard), new ImageView(heartCard), new ImageView(diamondCard), new ImageView(clubCard));
        
        // Place pane on scene
        Scene scene = new Scene(pane);

        // Setup and show stage
        primaryStage.setTitle(myName + "'s Lab 14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

   
    
}
