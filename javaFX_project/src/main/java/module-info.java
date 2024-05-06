module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    exports dtu.projectmanagement.businesslogic;
    opens dtu.projectmanagement.ui to javafx.fxml; // Gives access to fxml files'
}
