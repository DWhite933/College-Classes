package calandarlocale;

/**
 * @author David White
 * Class: CIS2572
 * Instructor:  Mohammad Morovati
 * Assignment: Programming exercise 36.9
 * File: CalandarLocale.java
 * Description:
 * Use Resource bundle to display a calendar to localize the 
 * labels "Choose a local" and "Calendar Demo" in French, German, Chinese,
 * or a language of your choice.
 **/

import javafx.application.Application;
import java.util.*;
import java.util.Locale;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalandarLocale extends Application {
    
    private CalendarPane calendarPane = new CalendarPane();
    private Button btPrior = new Button("Prior");
    private Button btNext = new Button("Next");
    private ComboBox<String> cboLocales = new ComboBox<>();
    private Locale[] availableLocales = {Locale.US, Locale.GERMANY};
    private Locale currentLocale = Locale.getDefault();
    private ResourceBundle res = ResourceBundle.getBundle("Resource");
    private Label localeLabel = new Label(res.getString("Choose_A_Locale"));
            
    @Override
    public void start(Stage primaryStage){
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(btPrior, btNext);
        hbox.setAlignment(Pos.CENTER);
        
        // Intialize cboLocales with available locales
        setAvailableLocales();
        HBox hBoxLocale = new HBox(5);
        
        hBoxLocale.getChildren().addAll(localeLabel, cboLocales);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(calendarPane);
        pane.setTop(hBoxLocale);
        hBoxLocale.setAlignment(Pos.CENTER);
        pane.setBottom(hbox);
        hbox.setAlignment(Pos.CENTER);
        
        // create scene and place in stage
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle(res.getString("Calendar_Demo"));
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btPrior.setOnAction(e -> {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 0){// the previous month is 11 for december
                calendarPane.setYear(calendarPane.getYear() - 1);
                calendarPane.setMonth(11);
              
            }else calendarPane.setMonth((currentMonth - 1 ) % 12);
        });
        
        btNext.setOnAction(e -> {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 11) 
                calendarPane.setYear(calendarPane.getYear() + 1);
            
            
            calendarPane.setMonth((currentMonth + 1) % 12);
        });
        
        cboLocales.setOnAction(e ->{
            calendarPane.setLocale(availableLocales[cboLocales.getSelectionModel().getSelectedIndex()]);
            currentLocale = availableLocales[cboLocales.getSelectionModel().getSelectedIndex()];
            updateStrings(primaryStage);
            
        });
    }

    private void setAvailableLocales() {
        for (Locale availableLocale : availableLocales) {
            cboLocales.getItems().add(availableLocale.getDisplayName() + " " + availableLocale.toString());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    private void updateStrings(Stage primaryStage) {
        res = ResourceBundle.getBundle("Resource", currentLocale);
        localeLabel.setText(res.getString("Choose_A_Locale"));
        primaryStage.setTitle(res.getString("Calendar_Demo"));
    }
}
