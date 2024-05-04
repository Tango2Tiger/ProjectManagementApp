module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens dtu.projectmanagement.ui to javafx.fxml; // Gives access to fxml files
    exports dtu.projectmanagement.ui; // Exports the class inheriting from javafx.application.Application
}