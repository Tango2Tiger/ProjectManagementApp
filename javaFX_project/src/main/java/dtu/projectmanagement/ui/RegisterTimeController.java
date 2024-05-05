package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.Activity;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    @FXML
    public Button editTimeButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        activityChoiceBox.setVisible(false);
        registerTimeButton.setVisible(false);
        editTimeButton.setVisible(false);
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
        App.setRoot("viewEmployees");
    }

    public void chooseProject(ActionEvent actionEvent) throws IOException {
        activityChoiceBox.setVisible(true);
        chooseActivityButton.setVisible(true);
        activityChoiceBox.getItems().clear();
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
        editTimeButton.setVisible(true);
        yearChoiceBox.getItems().clear();
        monthChoiceBox.getItems().clear();
        dayChoiceBox.getItems().clear();
        setYearChoiceBox();
        setMonthChoiceBox();
        setDayChoiceBox();
    }

    private void setYearChoiceBox() {
        ArrayList<String> yearList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            yearList.add(Integer.toString(i + 2023));
        }
        yearChoiceBox.getItems().addAll(yearList);

    }
    private void setMonthChoiceBox() {
        ArrayList<String> monthList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            monthList.add(Integer.toString(i));
        }
        monthChoiceBox.getItems().addAll(monthList);
    }
    private void setDayChoiceBox() {
        ArrayList<String> dayList = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            dayList.add(Integer.toString(i));
        }
        dayChoiceBox.getItems().addAll(dayList);
    }


    public void registerTime(ActionEvent actionEvent) throws IOException{
        try {
            Project project = App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue());
            Activity activity = project.getActivityWithName(activityChoiceBox.getValue());
            int halfHours = Integer.parseInt(halfHoursField.getText());
            int year = Integer.parseInt((String) yearChoiceBox.getValue());
            int day = Integer.parseInt((String) dayChoiceBox.getValue());
            int month = Integer.parseInt((String) monthChoiceBox.getValue()) - 1; // minus one since calendar object works with months 0-11

            App.getProjectManagementApp().registerTime(activity, halfHours, year, month, day);
            registerTimeLabel.setText("Succesfully registered " + halfHours + " half hours on activity " + activity.getName());
        } catch (OperationNotAllowedException e) {
            registerTimeLabel.setText(e.getMessage());
        } catch (NumberFormatException e) {
            registerTimeLabel.setText("Please fill all fields with integers");
        }

    }
    public void editTime(ActionEvent actionEvent) throws IOException{
        try {
            Project project = App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue());
            Activity activity = project.getActivityWithName(activityChoiceBox.getValue());
            int halfHours = Integer.parseInt(halfHoursField.getText());
            int year = Integer.parseInt((String) yearChoiceBox.getValue());
            int day = Integer.parseInt((String) dayChoiceBox.getValue());
            int month = Integer.parseInt((String) monthChoiceBox.getValue()) - 1; // minus one since calendar object works with months 0-11

            App.getProjectManagementApp().editTimeRegistrationForActivity(App.getProjectManagementApp().getLoggedIn(), activity, halfHours, year, month, day);
            registerTimeLabel.setText("Successfully edited " + halfHours + " half hours on activity " + activity.getName());
        } catch (OperationNotAllowedException e) {
            registerTimeLabel.setText(e.getMessage());
        } catch (NumberFormatException e) {
            registerTimeLabel.setText("Please fill all fields with integers");
        }

    }
}




