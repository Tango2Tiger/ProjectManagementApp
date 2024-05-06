package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.Activity;
import dtu.projectmanagement.businesslogic.Employee;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class RegisterEmployeeController {
    public TextField firstNameTxt;
    public TextField lastNameTxt;
    public Label registerFailTxt;

    public Employee employee;

    public void registerEmployee(ActionEvent actionEvent){
        try{
            App.getProjectManagementApp().registerEmployee(firstNameTxt.getText(), lastNameTxt.getText());
            registerFailTxt.setText(firstNameTxt.getText() + " " + lastNameTxt.getText() + " has been added to the system.\n Use initials: "+firstNameTxt.getText(0,2).toLowerCase()+lastNameTxt.getText(0,2).toLowerCase()+" to log in");
        } catch (OperationNotAllowedException e) {
            registerFailTxt.setText(e.getMessage());
        }
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewEmployees");
    }

    @FXML
    private void keyListenerRegisterEmployee(KeyEvent event) throws IOException{
        if(event.getCode() == KeyCode.ENTER){
            try{
                App.getProjectManagementApp().registerEmployee(firstNameTxt.getText(), lastNameTxt.getText());
                registerFailTxt.setText(firstNameTxt.getText() + " " + lastNameTxt.getText() + " has been added to the system.");
            } catch (OperationNotAllowedException e) {
                registerFailTxt.setText(e.getMessage());
            }
        }
    }
}
