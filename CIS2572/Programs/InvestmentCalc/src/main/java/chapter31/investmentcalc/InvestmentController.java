package chapter31.investmentcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.text.DecimalFormat;

public class InvestmentController {
    private final DecimalFormat df = new DecimalFormat("#.00");

    @FXML
    // text fields
    private TextField investmentTF, yearsTF, interestrateTF, futureValueTF;

    @FXML
    // buttons
    private Button exitBT, calcBT;

    @FXML
    private Text investmentTXT, yearsTXT, intrestrateTXT, futurevalueTXT;

    @FXML
    private Pane loanPane;

    @FXML
    private Menu menu;

    @FXML
    private MenuItem menuExit;

    @FXML
    // on button click exit program
    private void exitBTAction(ActionEvent e) {
        System.exit(0);
    }

    @FXML
    private void calcBTAction(ActionEvent e) {

        double investmentAmount = Double.parseDouble(investmentTF.getText());
        int numOfYears = Integer.parseInt(yearsTF.getText());
        double interestRate = (Double.parseDouble(interestrateTF.getText())) / 1200;

        double futureValue = investmentAmount * Math.pow((1 + interestRate), (numOfYears * 12));

        futureValueTF.setText("$"+df.format(futureValue));
    }

}