package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerEmployeeController {
    public TextField firstNameTxt;
    public TextField lastNameTxt;
    public Label registerFailTxt;
    public void registerEmployee(ActionEvent actionEvent){
        try{
            App.getProjectManagementApp().registerEmployee(firstNameTxt.getText(), lastNameTxt.getText());
            registerFailTxt.setText("");
        } catch (OperationNotAllowedException e) {
            registerFailTxt.setText(e.getMessage());
        }
    }
}
