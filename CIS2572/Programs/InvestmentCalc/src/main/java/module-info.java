module chapter31.investmentcalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens chapter31.investmentcalc to javafx.fxml;
    exports chapter31.investmentcalc;
}