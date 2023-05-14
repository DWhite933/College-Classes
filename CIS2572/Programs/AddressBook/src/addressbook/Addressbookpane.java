/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/*
Name: David White
Class: CIS2572
Instructor: Barry Speller
Assignment: Unit 17 Binary IO
File: Addressbookpanepane.java
Description: User interface for addressbook
 */
public class Addressbookpane extends BorderPane{
    // text field for Names
    protected TextField nameTextField = new TextField();
    
    // text field for Street
    protected TextField streetTextField = new TextField();
    
    // text field for city
    protected TextField cityTextField = new TextField();
    
    // text field for state
    protected TextField stateTextField = new TextField();
    
    // text field for zip code
    protected TextField zipCodeTextField = new TextField();
    
    // button to add a new address
    protected Button addButton = new Button("Add");
    
    // button to go to the first address
    protected Button firstButton = new Button("First");
    
    // button to go to the next address
    protected Button nextButton = new Button("Next");
    
    // button to go to the previous address
    protected Button previousButton = new Button("Previous");
    
    // button to go to the last address
    protected Button lastButton = new Button("Last");
    
    // button to update an address
    protected Button updateButton = new Button("Update");
    
    private FlowPane InfoPane = new FlowPane(5, 5);
    private HBox buttonPane = new HBox(5);
    
    public Addressbookpane() {
        drawAddressBook();
    }
    
    private void drawAddressBook() {
        // set column size for each text field
        nameTextField.setPrefColumnCount(23);
        streetTextField.setPrefColumnCount(23);
        cityTextField.setPrefColumnCount(8);
        stateTextField.setPrefColumnCount(2);
        zipCodeTextField.setPrefColumnCount(4);
        
        // place nodes in flow pane
        InfoPane.setPadding(new Insets(10, 10, 0, 10));
        InfoPane.getChildren().addAll(new Label("Name: "), nameTextField,
                new Label("Street: "), streetTextField,
                new Label("City:  "), cityTextField,
                new Label("State:"), stateTextField,
                new Label("Zip:"), zipCodeTextField);
        
        // place noeds in hbox
        buttonPane.getChildren().addAll(addButton, firstButton, nextButton, previousButton, lastButton, updateButton);
        buttonPane.setAlignment(Pos.CENTER);
        
        //place nodes in pnae
        setCenter(InfoPane);
        setBottom(buttonPane);
    }
}
