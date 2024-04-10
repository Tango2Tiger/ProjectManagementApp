//package dtu.example.ui;
//
//import java.io.IOException;
//
//import dtu.projectmanagement.app.ProjectManagementApp;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//public class SecondaryController {
//    public Label loginLabel;
//    @FXML
//    private TextField loginTextField;
//
//    @FXML
//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }
//    @FXML
//    public void loginEmployee(ActionEvent actionEvent) throws IOException {
//        App.getProjectManagementApp().login(loginTextField.getText());
//       loginLabel.setText(loginTextField.getText() + " logged in successfully");
//       App.setRoot("primary");
//    }
//}