package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class registerEmployeeController {
    public TextField firstNameTxt;
    public TextField lastNameTxt;
    public Label registerFailTxt;
    public void registerEmployee(ActionEvent actionEvent){
        try{
            App.getProjectManagementApp().registerEmployee(firstNameTxt.getText(), lastNameTxt.getText());
            registerFailTxt.setText(firstNameTxt.getText() + " " + lastNameTxt.getText() + " has been added to the system.");
        } catch (OperationNotAllowedException e) {
            registerFailTxt.setText(e.getMessage());
        }
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
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
