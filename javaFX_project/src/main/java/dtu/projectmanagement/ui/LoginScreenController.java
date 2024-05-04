package dtu.projectmanagement.ui;

import java.io.IOException;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginScreenController {
    public Label loginLabel;
    @FXML
    private TextField loginTextField;

    @FXML
    public void loginEmployee(ActionEvent actionEvent) throws IOException {
        try {
            App.getProjectManagementApp().login(loginTextField.getText());
            loginLabel.setText(loginTextField.getText() + " logged in successfully");
            App.setRoot("loggedIn");
        } catch (OperationNotAllowedException e) {
            loginLabel.setText(e.getMessage());
        }

    }

    @FXML
    private void keyListenerLogIn(KeyEvent event) throws IOException{
        if(event.getCode() == KeyCode.ENTER){
            try {
                App.getProjectManagementApp().login(loginTextField.getText());
                loginLabel.setText(loginTextField.getText() + " logged in successfully");
                App.setRoot("loggedIn");
            } catch (OperationNotAllowedException e) {
                loginLabel.setText(e.getMessage());
            }
        }
    }


}