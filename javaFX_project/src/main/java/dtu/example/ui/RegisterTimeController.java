package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterTimeController implements Initializable {
    @FXML
    public Label registerTimeLabel;
    @FXML
    public ChoiceBox<String> projectChoiceBox;
    @FXML
    public ChoiceBox<String> activityChoiceBox;
    @FXML
    public Label halfHoursLabel;
    @FXML
    public TextField halfHoursField;
    @FXML
    public Button registerTimeButton;
    @FXML
    public Button chooseActivityButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        activityChoiceBox.setVisible(false);
        registerTimeButton.setVisible(false);
        halfHoursLabel.setVisible(false);
        halfHoursField.setVisible(false);
        chooseActivityButton.setVisible(false);
    }
    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        activityChoiceBox.setVisible(true);
        chooseActivityButton.setVisible(true);
        activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getActivityListFromProject(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue())));
    }
    public void chooseActivity(ActionEvent actionEvent) throws IOException {
        halfHoursLabel.setVisible(true);
        halfHoursField.setVisible(true);
        registerTimeButton.setVisible(true);
    }
    public void registerTime(ActionEvent actionEvent) throws IOException{
        App.getProjectManagementApp().registerTime(App.getProjectManagementApp().getLoggedIn(), App.getProjectManagementApp().getActivityFromProject(projectChoiceBox.getValue(), activityChoiceBox.getValue()),Integer.parseInt(halfHoursField.getText()));
        registerTimeLabel.setText("Time has been registered!");
    }

    /*@FXML
    private void keyListenerRegisterEmployee(KeyEvent event) throws IOException{
        if(event.getCode() == KeyCode.ENTER){
            try{
                App.getProjectManagementApp().registerTime(App.getProjectManagementApp().getLoggedIn(), App.getProjectManagementApp().getActivityFromProject(projectChoiceBox.getValue(), activityChoiceBox.getValue()),Integer.parseInt(halfHoursField.getText()));
            } catch (OperationNotAllowedException e) {
                //registerFailTxt.setText(e.getMessage());
            }
        }
    }*/


}
