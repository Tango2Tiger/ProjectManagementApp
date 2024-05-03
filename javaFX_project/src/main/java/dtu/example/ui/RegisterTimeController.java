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
    public Label yearLabel;
    @FXML
    public Label monthLabel;
    @FXML
    public Label dayLabel;
    @FXML
    public TextField halfHoursField;
    @FXML
    public ChoiceBox yearChoiceBox;
    @FXML
    public ChoiceBox monthChoiceBox;
    @FXML
    public ChoiceBox dayChoiceBox;
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
        yearChoiceBox.setVisible(false);
        yearLabel.setVisible(false);
        monthChoiceBox.setVisible(false);
        monthLabel.setVisible(false);
        dayChoiceBox.setVisible(false);
        dayLabel.setVisible(false);
        chooseActivityButton.setVisible(false);
    }
    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        activityChoiceBox.setVisible(true);
        chooseActivityButton.setVisible(true);
        activityChoiceBox.getItems();
        activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getActivityListFromProject(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue())));
    }
    public void chooseActivity(ActionEvent actionEvent) throws IOException {
        halfHoursLabel.setVisible(true);
        halfHoursField.setVisible(true);
        yearChoiceBox.setVisible(true);
        yearLabel.setVisible(true);
        monthChoiceBox.setVisible(true);
        monthLabel.setVisible(true);
        dayChoiceBox.setVisible(true);
        dayLabel.setVisible(true);
        registerTimeButton.setVisible(true);


    }
    public void registerTime(ActionEvent actionEvent) throws IOException{
//        try {
//            int halfHours = Integer.parseInt(halfHoursField.getText());
//            int year = Integer.parseInt(yearField.getText());
//            int month = Integer.parseInt(monthField.getText());
//            int day = Integer.parseInt(dayField.getText());
//            App.getProjectManagementApp().registerTime(App.getProjectManagementApp().getLoggedIn(), App.getProjectManagementApp().getActivityFromProject(projectChoiceBox.getValue(), activityChoiceBox.getValue()),halfHours,year,month,day);
//            registerTimeLabel.setText("Time has been registered!");
//        } catch (NumberFormatException e) {
//            registerTimeLabel.setText("Please enter integers only");
//        } catch (OperationNotAllowedException e) {
//            registerTimeLabel.setText(e.getMessage());
        }

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



