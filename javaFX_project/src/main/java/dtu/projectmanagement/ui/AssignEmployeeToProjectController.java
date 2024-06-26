package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
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

/**
 @author s235233
 */
public class AssignEmployeeToProjectController implements Initializable{
    @FXML
    public ChoiceBox<String> employeeChoiceBox;
    @FXML
    public Label assignEmployeeLabel;
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private Button assignEmployeeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        employeeChoiceBox.setVisible(false);
        assignEmployeeButton.setVisible(false);
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

    public void chooseProject(ActionEvent actionEvent) throws IOException {
        if(projectChoiceBox.getValue() != null){
            employeeChoiceBox.setVisible(true);
            assignEmployeeButton.setVisible(true);
            employeeChoiceBox.getItems().clear();
            employeeChoiceBox.getItems().addAll(App.getProjectManagementApp().getEmployeeInitialsList());
        } else{
            assignEmployeeLabel.setText("Please select project.");
        }

    }

    public void assignEmployee() throws IOException, OperationNotAllowedException {
        if(isNull(employeeChoiceBox.getValue()) || isNull(projectChoiceBox.getValue())){
            assignEmployeeLabel.setText("Please choose an employee");
            return;
        }
        App.getProjectManagementApp().addEmployeeToProject(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()), App.getProjectManagementApp().getEmployeeWithInitials(employeeChoiceBox.getValue()));
        assignEmployeeLabel.setText("Employee " + employeeChoiceBox.getValue() + " has been assigned to project " + projectChoiceBox.getValue());
    }

}
