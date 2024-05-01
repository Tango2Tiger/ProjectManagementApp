package dtu.example.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dtu.projectmanagement.app.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class AssignProjectLeaderController implements Initializable {
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
    }
    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
}
