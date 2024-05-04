package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class DeleteEmployeeController implements Initializable {
    @FXML
    private ChoiceBox<String> employeeChoiceBox;
    @FXML
    public Label deleteEmployeeLabel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeChoiceBox.getItems().addAll(App.getProjectManagementApp().getEmployeeInitialsList());
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewEmployees");
    }

    public void deleteEmployee() throws IOException, OperationNotAllowedException {
        if(isNull(employeeChoiceBox.getValue())){
            deleteEmployeeLabel.setText("Please choose a project.");
            return;
        }
        if (App.getProjectManagementApp().getEmployeeWithInitials(employeeChoiceBox.getValue()) == App.getProjectManagementApp().getLoggedIn()){
            deleteEmployeeLabel.setText("The Employee \'" + employeeChoiceBox.getValue() + "\' is currently logged. Please choose another employee.");
        }else {
            App.getProjectManagementApp().deleteEmployee(App.getProjectManagementApp().getEmployeeWithInitials(employeeChoiceBox.getValue()));
            deleteEmployeeLabel.setText("The Employee \'" + employeeChoiceBox.getValue() + "\' has been deleted.");
            employeeChoiceBox.getItems().clear();
            employeeChoiceBox.getItems().addAll(App.getProjectManagementApp().getEmployeeInitialsList());
        }
    }
}
