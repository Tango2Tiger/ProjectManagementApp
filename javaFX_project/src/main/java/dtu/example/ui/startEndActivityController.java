package dtu.example.ui;

import dtu.projectmanagement.app.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class startEndActivityController implements Initializable {
    @FXML
    public Label setDateScreenLabel;
    @FXML
    public ChoiceBox<String> projectChoiceBox;
    @FXML
    public ChoiceBox<String> activityChoiceBox;
    @FXML
    public TextField setStartYear;
    @FXML
    public TextField setStartWeek;
    @FXML
    public TextField setEndYear;
    @FXML
    public TextField setEndWeek;

    @FXML
    private Button chooseActivityButton;
    @FXML
    private Button setStartDateButton;
    @FXML
    private Project project;
    private Activity activity;
    private ProjectManagementApp projectManagementApp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        activityChoiceBox.setVisible(false);
        chooseActivityButton.setVisible(false);
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        if (!isNull(projectChoiceBox.getValue())) {
            activityChoiceBox.setVisible(true);
            chooseActivityButton.setVisible(true);
            project = App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue());
            activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getActivityListFromProject(project));
            setDateScreenLabel.setText("Please choose an activity");
        }

    }
    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

    public void chooseActivity(ActionEvent actionEvent) {
        if(!isNull(activityChoiceBox.getValue())) {
            activity = project.getActivityWithName(activityChoiceBox.getValue());
            setDateScreenLabel.setText("Activity "+ activity.getName() + " has no date");
        }
    }


    public void setDate(ActionEvent actionEvent) throws NumberFormatException{
        try {
            int s_year = Integer.parseInt(setStartYear.getText());
            int s_week = Integer.parseInt(setStartWeek.getText());
            int e_year = Integer.parseInt(setEndYear.getText());
            int e_week = Integer.parseInt(setEndWeek.getText());
            activity.setStartDate(new ActivityDate(s_year, s_week));
            activity.setEndDate(new ActivityDate(e_year,e_week));
            setDateScreenLabel.setText("Activity "+ activity.getName() + " has start week 20"
                    + activity.getStartDate().getYear() + "-" +activity.getStartDate().getWeek()
                        +" and end week 20"+activity.getEndDate().getYear()+"-"+activity.getEndDate().getWeek());
            App.getProjectManagementApp().setStartEndActivity(s_year,s_week,e_year,e_week,project.getName(),activity.getName());
        } catch (NumberFormatException e) {
            setDateScreenLabel.setText("Please enter an integer");
        } catch (OperationNotAllowedException e) {
            setDateScreenLabel.setText(e.getMessage());
        }
    }

}
