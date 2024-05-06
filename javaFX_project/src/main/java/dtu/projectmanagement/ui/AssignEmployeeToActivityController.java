package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class AssignEmployeeToActivityController implements Initializable {
    @FXML
    public Label assignEmployeeToActivityLabel;
    @FXML
    public Label noteLabel;
    @FXML
    public ChoiceBox<String> projectChoiceBox;
    @FXML
    public ChoiceBox<String> activityChoiceBox;
    @FXML
    public ChoiceBox<String> employeeChoiceBox;
    @FXML
    private Button chooseActivityButton;
    @FXML
    private Button assignEmployeeToActivityButton;
    @FXML
    private Project project;
    private Activity activity;
    private Employee employee;
    private ProjectManagementApp projectManagementApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        activityChoiceBox.setVisible(false);
        employeeChoiceBox.setVisible(false);
        noteLabel.setVisible(false);
        chooseActivityButton.setVisible(false);
        assignEmployeeToActivityButton.setVisible(false);
    }

    public void chooseProject(ActionEvent actionEvent) throws IOException {
        if (!isNull(projectChoiceBox.getValue())) {
            activityChoiceBox.setVisible(true);
            chooseActivityButton.setVisible(true);
            activityChoiceBox.getItems().clear();
            project = App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue());
            activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getActivityListFromProject(project));
        } else{
            assignEmployeeToActivityLabel.setText("Please choose a project.");
        }

    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewActivities");
    }

    public void chooseActivity(ActionEvent actionEvent) throws IOException {
        if (!isNull(activityChoiceBox.getValue())) {
            employeeChoiceBox.setVisible(true);
            noteLabel.setVisible(true);
            employeeChoiceBox.getItems().clear();
            activity = App.getProjectManagementApp().getActivityFromProject(project.getName(), activityChoiceBox.getValue());
            employeeChoiceBox.getItems().addAll(App.getProjectManagementApp().getEmployeeNameListFromProject(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue())));
            assignEmployeeToActivityButton.setVisible(true);
        } else{
            assignEmployeeToActivityLabel.setText("Please choose an activity");
        }
    }

    public void assignEmployee(ActionEvent actionEvent) throws OperationNotAllowedException {
        if(!isNull(employeeChoiceBox.getValue())){
            App.getProjectManagementApp().assignEmployeeToActivity(App.getProjectManagementApp().getEmployeeWithInitials(employeeChoiceBox.getValue()), App.getProjectManagementApp().getActivityFromProject(projectChoiceBox.getValue(), activityChoiceBox.getValue()));
            assignEmployeeToActivityLabel.setText("Employee " + employeeChoiceBox.getValue() + " has been assigned to the activity: " + activityChoiceBox.getValue() + " in the project: " + projectChoiceBox.getValue());
        } else{
            assignEmployeeToActivityLabel.setText("Please choose an employee.");
        }

    }
}
