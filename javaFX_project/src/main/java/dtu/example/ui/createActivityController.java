package dtu.example.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dtu.projectmanagement.app.Activity;
import dtu.projectmanagement.app.OperationNotAllowedException;
import dtu.projectmanagement.app.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import static java.util.Objects.isNull;

public class createActivityController implements Initializable {
    @FXML
    public Label createActivityLabel;
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private Button createActivityButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        createActivityButton.setVisible(false);
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        createActivityButton.setVisible(true);
    }

    public void createActivity(ActionEvent actionEvent) throws IOException{}

}
