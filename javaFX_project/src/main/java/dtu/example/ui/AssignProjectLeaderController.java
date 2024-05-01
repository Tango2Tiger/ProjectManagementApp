package dtu.example.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dtu.projectmanagement.app.OperationNotAllowedException;
import dtu.projectmanagement.app.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AssignProjectLeaderController implements Initializable {
    @FXML
    public ChoiceBox<String> employeeChoiceBox;
    @FXML
    public Label assignLeaderLabel;
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        employeeChoiceBox.setVisible(false);
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        employeeChoiceBox.setVisible(true);
        employeeChoiceBox.getItems().addAll(App.getProjectManagementApp().getEmployeeInitialsList());
    }
    public void assignLeader() throws IOException, OperationNotAllowedException {
        App.getProjectManagementApp().setProjectLeader(App.getProjectManagementApp().getEmployeeWithInitials(employeeChoiceBox.getValue()), App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()));
        assignLeaderLabel.setText("Employee " + employeeChoiceBox.getValue() + " has been assigned as leader of project " + projectChoiceBox.getValue());
    }
}
